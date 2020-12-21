package livscode.tes.greenly;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import livscode.tes.greenly.databinding.FragmentAnswerOneBinding;

public class AnswerOneFragment extends Fragment {


FragmentAnswerOneBinding binding;
    public AnswerOneFragment() {
        // Required empty public constructor
    }

    public static AnswerOneFragment newInstance(String param1, String param2) {
        AnswerOneFragment fragment = new AnswerOneFragment();
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
        binding = FragmentAnswerOneBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}