package com.example.molitvum_grioe;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar); // Убедитесь, что ваш макет правильный

        // Найдите ImageView в макете
        ImageView imageView = findViewById(R.id.imageViewCalendar);

        // Установите картинку для отображения
        imageView.setImageResource(R.drawable.calendar); // calendar.png
    }
}
