package livscode.tes.greenly;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import livscode.tes.greenly.databinding.FragmentAnswerOneBinding;
import livscode.tes.greenly.databinding.FragmentAnswerThreeBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnswerThreeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerThreeFragment extends Fragment {
FragmentAnswerThreeBinding binding;

    public AnswerThreeFragment() {
        // Required empty public constructor
    }


    public static AnswerThreeFragment newInstance(String param1, String param2) {
        AnswerThreeFragment fragment = new AnswerThreeFragment();
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
        binding = FragmentAnswerThreeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}