package com.example.molitvum_grioe;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Настройка нижнего меню
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Установите обработчик нажатий
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Используем if-else вместо switch
                if (item.getItemId() == R.id.menu_home) {
                    // Главный экран
                    return true;
                } else if (item.getItemId() == R.id.menu_calendar) {
                    // Переход на экран календаря
                    startActivity(new Intent(MainActivity.this, CalendarActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.menu_candle) {
                    // Переход на экран с свечой
                    startActivity(new Intent(MainActivity.this, CandleActivity.class));
                    return true;
                }
                return false;
            }
        });

        // Настройка кнопок для переходов
        Button btnStudyPrayers = findViewById(R.id.btnStudyPrayers);
        Button btnPersonalPrayers = findViewById(R.id.btnPersonalPrayers);

        // Установите обработчики нажатий для кнопок
        btnStudyPrayers.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StudyPrayersActivity.class);
            startActivity(intent);
        });

        btnPersonalPrayers.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PersonalPrayersActivity.class);
            startActivity(intent);
        });
    }
}
