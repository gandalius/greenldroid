package livscode.tes.greenly;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import livscode.tes.greenly.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.button1.setOnClickListener(view -> {
           Navigation.findNavController(view)
                    .navigate(HomeFragmentDirections
                            .actionHomeFragmentToAnswerOneFragment());
        });

        binding.button2.setOnClickListener(view -> {
            Navigation.findNavController(view)
                    .navigate(HomeFragmentDirections
                            .actionHomeFragmentToAnswerTwoFragment());
        });

        binding.button3.setOnClickListener(view -> {
            Navigation.findNavController(view)
                    .navigate(HomeFragmentDirections
                            .actionHomeFragmentToAnswerThreeFragment());
        });
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}