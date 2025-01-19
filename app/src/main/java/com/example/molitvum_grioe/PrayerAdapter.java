package com.example.molitvum_grioe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PrayerAdapter extends RecyclerView.Adapter<PrayerAdapter.PrayerViewHolder> {

    private List<Prayer> prayers;

    public PrayerAdapter(List<Prayer> prayers) {
        this.prayers = prayers;
    }

    @NonNull
    @Override
    public PrayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_prayer, parent, false);
        return new PrayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrayerViewHolder holder, int position) {
        Prayer prayer = prayers.get(position);
        holder.tvTitle.setText(prayer.getTitle());
        holder.tvText.setText(prayer.getText());
    }

    @Override
    public int getItemCount() {
        return prayers.size();
    }

    public void toggleLanguage() {
        for (Prayer prayer : prayers) {
            prayer.toggleLanguage();
        }
        notifyDataSetChanged();
    }

    static class PrayerViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvText;

        public PrayerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvPrayerTitle);
            tvText = itemView.findViewById(R.id.tvPrayerText);
        }
    }
}
