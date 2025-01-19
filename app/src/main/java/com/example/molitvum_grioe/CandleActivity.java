package com.example.molitvum_grioe;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide; // Для загрузки гифок с помощью Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class CandleActivity extends AppCompatActivity {

    private boolean isCandleVisible = false; // Флаг, который отслеживает видимость свечи

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candle);

        // Найдите ImageView для гифки
        ImageView imageView = findViewById(R.id.imageViewCandle);

        // Сначала скрываем гифку
        imageView.setVisibility(View.INVISIBLE);

        // Устанавливаем обработчик нажатия на экран
        findViewById(R.id.candleScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCandleVisible) {
                    // Если свеча уже отображается, скрыть её
                    imageView.setVisibility(View.INVISIBLE);
                } else {
                    // Если свеча не отображается, показать её
                    Glide.with(CandleActivity.this)
                            .load(R.drawable.candle) // Путь к гифке
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .into(imageView);
                    imageView.setVisibility(View.VISIBLE);
                }

                // Переключаем флаг
                isCandleVisible = !isCandleVisible;
            }
        });
    }
}
