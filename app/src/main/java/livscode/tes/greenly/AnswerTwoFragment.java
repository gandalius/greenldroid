package livscode.tes.greenly;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import livscode.tes.greenly.databinding.FragmentAnswerOneBinding;
import livscode.tes.greenly.databinding.FragmentAnswerTwoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnswerTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerTwoFragment extends Fragment {

FragmentAnswerTwoBinding binding;
    public AnswerTwoFragment() {
        // Required empty public constructor
    }


    public static AnswerTwoFragment newInstance(String param1, String param2) {
        AnswerTwoFragment fragment = new AnswerTwoFragment();
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
        binding = FragmentAnswerTwoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}