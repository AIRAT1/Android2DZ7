# Android2DZ7
Приложение представляет собой реализацию домашнего задания https://geekbrains.ru/streams/441/lessons/3843
View 
Нужно создать свой собственный View - SnegovikView. Отрисовывать его при помощи трёх кругов, 
при желании можно сделать ему рот и глаза. Разместите его на xml макете и запустите приложение, 
чтобы убедиться что всё хорошо

SurfaceView
Создайте SurfaceView и нарисуйте в нём такого же снеговика. Далее, попробуйте отрисовать 
5,10,50,100 снеговиков на этом SurfaceView. Будет идеально если сделаете их маленькими и они будут 
вмещаться на SurfaceView. Пояснение: 50,100 и дальше - большие количества, делать столько вьюх будет 
затратно для основного потока, для такого случая нужно научится рисовать на SurfaceView.
Подсказка: вынесите отрисовку снеговика в цикл, рисуя каждый новый делайте смещение. Лучше сделать 
двойной цикл и рисовать их рядами.

Анимация
а) Создайте стандартную android-анимацию трансформации для любого View какого хотите. Тип анимации 
тоже на выбор (rotate, translate, и т.д)
б) Создайте покадровую анимацию. Выберите для этого любую раскадровку, например: 
http://demiart.ru/forum/uploads7/post-93580-1291183526.jpg
