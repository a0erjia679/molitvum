package com.example.molitvum_grioe;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide; // Для загрузки гифок с помощью Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class CandleActivity extends AppCompatActivity {

    private boolean isCandleVisible = false; // Флаг, который отслеживает видимость свечи
    private MediaPlayer mediaPlayer; // Переменная для проигрывания музыки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candle);

        // Найдите ImageView для гифки
        ImageView imageView = findViewById(R.id.imageViewCandle);

        // Сначала скрываем гифку
        imageView.setVisibility(View.INVISIBLE);

        // Инициализация MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.pray); // Путь к вашему mp3 файлу (res/raw/pray.mp3)

        // Устанавливаем обработчик нажатия на экран
        findViewById(R.id.candleScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCandleVisible) {
                    // Если свеча уже отображается, скрыть её
                    imageView.setVisibility(View.INVISIBLE);
                    stopMusic(); // Останавливаем музыку
                } else {
                    // Если свеча не отображается, показать её
                    Glide.with(CandleActivity.this)
                            .load(R.drawable.candle) // Путь к гифке
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .into(imageView);
                    imageView.setVisibility(View.VISIBLE);
                    startMusic(); // Включаем музыку
                }

                // Переключаем флаг
                isCandleVisible = !isCandleVisible;
            }
        });
    }

    // Метод для воспроизведения музыки
    private void startMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(true); // Включаем зацикливание музыки
            mediaPlayer.start();
        }
    }

    // Метод для остановки музыки
    private void stopMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.prepareAsync(); // Подготавливаем MediaPlayer для повторного воспроизведения
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopMusic(); // Останавливаем музыку, если пользователь покидает экран
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Освобождаем ресурсы, когда активность уничтожается
        }
    }
}
