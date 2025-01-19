package com.example.molitvum_grioe;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EditPrayerActivity extends AppCompatActivity {

    private EditText etTitle, etTextRussian, etTextChurchSlavonic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_prayer);

        etTitle = findViewById(R.id.etPrayerTitle);
        etTextRussian = findViewById(R.id.etPrayerTextRussian);
        etTextChurchSlavonic = findViewById(R.id.etPrayerTextChurchSlavonic);
        Button btnSave = findViewById(R.id.btnSavePrayer);
        Button btnDelete = findViewById(R.id.btnDeletePrayer);

        Intent intent = getIntent();
        if (intent.hasExtra("prayer_title")) {
            etTitle.setText(intent.getStringExtra("prayer_title"));
            etTextRussian.setText(intent.getStringExtra("prayer_text_russian"));
            etTextChurchSlavonic.setText(intent.getStringExtra("prayer_text_church_slavonic"));
        }

        btnSave.setOnClickListener(v -> {
            String title = etTitle.getText().toString().trim();
            String textRussian = etTextRussian.getText().toString().trim();
            String textChurchSlavonic = etTextChurchSlavonic.getText().toString().trim();

            if (!TextUtils.isEmpty(title) && (!TextUtils.isEmpty(textRussian) || !TextUtils.isEmpty(textChurchSlavonic))) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("prayer_title", title);
                resultIntent.putExtra("prayer_text_russian", textRussian);
                resultIntent.putExtra("prayer_text_church_slavonic", textChurchSlavonic);
                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                // Покажите ошибку (например, Toast)
            }
        });

        btnDelete.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}
