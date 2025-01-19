package com.example.molitvum_grioe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PersonalPrayersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PersonalPrayersAdapter adapter;
    private List<Prayer> prayers;
    private boolean isRussian = true; // По умолчанию русский язык

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_prayers);

        recyclerView = findViewById(R.id.recyclerViewPersonalPrayers);
        ImageButton btnAddPrayer = findViewById(R.id.btnAddPrayer);
        ImageButton btnChangeLanguage = findViewById(R.id.btnChangeLanguage);

        // Инициализация списка молитв
        prayers = new ArrayList<>();
        prayers.add(new Prayer("Молитва об учёбе", "Текст молитвы на русском", "Текст молитвы на церковнославянском"));
        prayers.add(new Prayer("Молитва за здоровье", "Текст на русском", "Текст на церковнославянском"));

        // Настройка RecyclerView
        adapter = new PersonalPrayersAdapter(prayers, position -> {
            // Открытие экрана редактирования
            Intent intent = new Intent(PersonalPrayersActivity.this, EditPrayerActivity.class);
            intent.putExtra("prayer_position", position);
            intent.putExtra("prayer_title", prayers.get(position).getTitle());
            intent.putExtra("prayer_text_russian", prayers.get(position).getTextRussian());
            intent.putExtra("prayer_text_church_slavonic", prayers.get(position).getTextChurchSlavonic());
            startActivityForResult(intent, 2); // Request Code: 2
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Обработка нажатия на кнопку добавления молитвы
        btnAddPrayer.setOnClickListener(v -> {
            Intent intent = new Intent(PersonalPrayersActivity.this, EditPrayerActivity.class);
            startActivityForResult(intent, 1); // Request Code: 1
        });

        // Обработка смены языка
        btnChangeLanguage.setOnClickListener(v -> {
            isRussian = !isRussian; // Переключаем язык
            for (Prayer prayer : prayers) {
                if (isRussian) {
                    prayer.setTextRussian(prayer.getTextRussian());
                } else {
                    prayer.setTextChurchSlavonic(prayer.getTextChurchSlavonic());
                }
            }
            adapter.notifyDataSetChanged(); // Обновляем список
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("prayer_title");
            String textRussian = data.getStringExtra("prayer_text_russian");
            String textChurchSlavonic = data.getStringExtra("prayer_text_church_slavonic");

            if (requestCode == 1) { // Добавление новой молитвы
                prayers.add(new Prayer(title, textRussian, textChurchSlavonic));
                adapter.notifyItemInserted(prayers.size() - 1);
            } else if (requestCode == 2) { // Редактирование существующей молитвы
                int position = data.getIntExtra("prayer_position", -1);
                if (position != -1) {
                    prayers.get(position).setTitle(title);
                    prayers.get(position).setTextRussian(textRussian);
                    prayers.get(position).setTextChurchSlavonic(textChurchSlavonic);
                    adapter.notifyItemChanged(position);
                }
            }
        }
    }
}
