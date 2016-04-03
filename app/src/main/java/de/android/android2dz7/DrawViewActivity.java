package de.android.android2dz7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawViewActivity extends AppCompatActivity {
    private DrawThread drawThread;
    private Paint p;
    private Path path, pathDst;
    private Matrix matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends SurfaceView implements SurfaceHolder.Callback {


        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);
            path = new Path();
            path.addCircle(100, 100, 25, Path.Direction.CW);
            path.addCircle(100, 175, 50, Path.Direction.CW);
            path.addCircle(100, 300, 75, Path.Direction.CW);
            pathDst = new Path();
            matrix = new Matrix();
            matrix.reset();
//            pathDst.addPath(path);
            for (int i = 0; i < 5; i++) {
                path.transform(matrix);
                matrix.setTranslate(150, 0);
                pathDst.addPath(path, matrix);
            }
            getHolder().addCallback(this);
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            drawThread = new DrawThread(getHolder());
            drawThread.setRunning(true);
            drawThread.start();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            boolean retry = true;
            drawThread.setRunning(false);
            while (retry) {
                try {
                    drawThread.join();
                    retry = false;
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    class DrawThread extends Thread {
        private boolean running = false;
        private SurfaceHolder surfaceHolder;
        public DrawThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
        }
        public void setRunning(boolean running) {
            this.running = running;
        }

        @Override
        public void run() {
            Canvas canvas;
            while (running) {
                canvas = null;
                try {
                    canvas = surfaceHolder.lockCanvas(null);
                    if (canvas == null) continue;
                    canvas.drawARGB(80, 102, 204, 255);
                    p.setColor(Color.BLUE);
                    canvas.drawPath(pathDst, p);

                }finally {
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }
    }
}
