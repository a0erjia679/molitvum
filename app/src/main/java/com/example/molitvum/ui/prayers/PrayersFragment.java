package com.example.molitvum.ui.prayers;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.molitvum.R;
import com.example.molitvum.databinding.FragmentNotificationsBinding;
import com.example.molitvum.databinding.FragmentPrayersBinding;

import java.util.ArrayList;
import java.util.List;

public class PrayersFragment extends Fragment {

    private PrayersViewModel mViewModel;
    private List<String> prayersList;
    private int currentPrayerIndex = 0;

    public static PrayersFragment newInstance() {
        return new PrayersFragment();
    }
    private FragmentPrayersBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        PrayersViewModel prayersViewModel =
                new ViewModelProvider(this).get(PrayersViewModel.class);

        binding = FragmentPrayersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        // Список молитв
        prayersList = new ArrayList<>();
        prayersList.add("Премилосердый Господь! Пошли нам благодать Духа Твоего Святого, которая бы дала нам понятливость и укрепила наши душевные силы, чтобы мы, слушая преподаваемое нам учение, возросли Тебе, нашему Создателю, во славу, родителям нашим на утешение, Церкви и Отечеству на пользу.");
        prayersList.add("Царь Небесный, Утешитель, Дух Истины, везде пребывающий и всё наполняющий, Сокровищница благ и жизни Податель, приди и вселись в нас, и очисти нас от всякой скверны, и спаси, Благой, души наши.");
        prayersList.add("Господь Бог и Создатель наш, который Своим образом украсил нас, людей, и избранных Твоих научил закону Твоему, так что те, которые слушают его удивляются, детям тайны мудрости Своей открыл, Соломону и всем тем, которые ищут её, дал – открой сердца, умы и уста этих рабов Твоих (имена), чтобы понять силу Твоего закона и успешно познать преподаваемые им полезные знания, для славы Пресвятого Твоего имени, для пользы и устроения Святой Твоей Церкви и разумения благой и совершенной Твоей воли. Избавь их от всех козней вражьих, сохрани их в вере Христовой и чистоте во всё время их жизни, да будут сильные разумом и в исполнении Твоих заповедей, и так наученные прославят Пресвятое имя Твоё и будут наследниками Царства Твоего, потому что Ты – Бог, с сильной милостью и благой силой, и Тебе подобает вся слава, честь и поклонение, Отцу и Сыну и Святому Духу, всегда, ныне и во веки веков. Аминь.");
        prayersList.add("Благодарим Тебя, Создатель, потому что Ты сподобил нас благодати Твоей, чтобы понимать учение. Благослови наших начальников, родителей и учителей, ведущих нас к познанию хорошего, дай нам силу и крепость к продолжению этого обучения.");

        // Устанавливаем начальный текст молитвы
        binding.textPrayers.setText(prayersList.get(currentPrayerIndex));

        // Обработчик кнопки для переключения молитвы
        binding.buttonNextPrayer.setOnClickListener(v -> {
            // Переключаем на следующую молитву
            currentPrayerIndex = (currentPrayerIndex + 1) % prayersList.size();
            binding.textPrayers.setText(prayersList.get(currentPrayerIndex));
        });
        return root;


    }



}