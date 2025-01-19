package com.example.molitvum.ui.personal;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.molitvum.databinding.FragmentPersonalPrayersBinding;
import com.example.molitvum.ui.prayers.PrayersViewModel;

import java.util.ArrayList;
import java.util.List;

public class PersonalPrayersFragment extends Fragment {

    private PersonalPrayersViewModel mViewModel;
    private FragmentPersonalPrayersBinding binding;
    public static PersonalPrayersFragment newInstance() {
        return new PersonalPrayersFragment();
    }
    private List<String> personalPrayersList;
    private int currentPrayerIndex = 0;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        PrayersViewModel prayersViewModel =
                new ViewModelProvider(this).get(PrayersViewModel.class);

        binding = FragmentPersonalPrayersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        // Список молитв
        personalPrayersList = new ArrayList<>();



        binding.textPersonalPrayers.setText("Молитвослов");

        binding.buttonAddPrayer.setOnClickListener(v -> {
            String newPrayer = binding.editTextPrayer.getText().toString().trim();
            if (!newPrayer.isEmpty()) {
                personalPrayersList.add(newPrayer);
                binding.editTextPrayer.setText("");
                Toast.makeText(getContext(), "Молитва добавлена", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Введите молитву", Toast.LENGTH_SHORT).show();
            }
        });


        // Обработчик кнопки для переключения молитвы
        binding.buttonNextPersonalPrayer.setOnClickListener(v -> {
            if(personalPrayersList.isEmpty()){
                binding.textPersonalPrayers.setText("Добавить молитву");
            } else {
                currentPrayerIndex = (currentPrayerIndex + 1) % personalPrayersList.size();
                binding.textPersonalPrayers.setText(personalPrayersList.get(currentPrayerIndex));
            }
        });
        return root;
    }



}