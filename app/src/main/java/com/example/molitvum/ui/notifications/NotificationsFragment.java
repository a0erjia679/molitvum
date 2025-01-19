package com.example.molitvum.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.molitvum.R;
import com.example.molitvum.databinding.FragmentNotificationsBinding;
import com.example.molitvum.ui.prayers.PrayersFragment;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        Button button = root.findViewById(R.id.prayers_studying);
        button.setOnClickListener(v -> {
             NavController navController = Navigation.findNavController(requireActivity(),  R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_to_navigation_prayers);
        });

        Button button2 = root.findViewById(R.id.personal);
        button2.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(requireActivity(),  R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_to_navigation_personal_prayers);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}