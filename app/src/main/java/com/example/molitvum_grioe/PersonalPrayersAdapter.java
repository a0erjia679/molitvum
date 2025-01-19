package com.example.molitvum_grioe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PersonalPrayersAdapter extends RecyclerView.Adapter<PersonalPrayersAdapter.PrayerViewHolder> {

    private List<Prayer> prayers;
    private OnPrayerActionListener listener;

    // Интерфейс для обработки нажатий на элементы списка
    public interface OnPrayerActionListener {
        void onEditPrayer(int position);
    }

    public PersonalPrayersAdapter(List<Prayer> prayers, OnPrayerActionListener listener) {
        this.prayers = prayers;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PrayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_personal_prayer, parent, false);
        return new PrayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrayerViewHolder holder, int position) {
        Prayer prayer = prayers.get(position);
        holder.tvTitle.setText(prayer.getTitle());
        holder.tvText.setText(prayer.getTextRussian()); // Отображаем русский текст по умолчанию

        // Обработка нажатия на кнопку редактирования
        holder.btnEdit.setOnClickListener(v -> {
            if (listener != null) {
                listener.onEditPrayer(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return prayers.size();
    }

    public static class PrayerViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvText;
        ImageButton btnEdit;

        public PrayerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvPrayerTitle);
            tvText = itemView.findViewById(R.id.tvPrayerText);
            btnEdit = itemView.findViewById(R.id.btnEditPrayer);
        }
    }
}
