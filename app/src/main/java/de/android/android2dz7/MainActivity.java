package de.android.android2dz7;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private AnimationDrawable animationDrawable;
    private Button btnStart, btnStop;
    private Animation myAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnStop = (Button)findViewById(R.id.btnStop);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.animation);
        animationDrawable = (AnimationDrawable)imageView.getBackground();
        myAnimation = AnimationUtils.loadAnimation(this, R.anim.my_animation);

    }

    public void onClickStart(View view) {
        animationDrawable.start();
        btnStart.startAnimation(myAnimation);
    }

    public void onClickStop(View view) {
        animationDrawable.stop();
        btnStop.startAnimation(myAnimation);
    }

    public void onDrawView(View view) {
        startActivity(new Intent(this, DrawViewActivity.class));
    }
}
