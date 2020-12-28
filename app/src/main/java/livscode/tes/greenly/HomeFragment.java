package livscode.tes.greenly;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import livscode.tes.greenly.adapter.ListDataAdapter;
import livscode.tes.greenly.core.Logic;
import livscode.tes.greenly.data.BoardingPassEntity;
import livscode.tes.greenly.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements
    ListDataAdapter.OnDetailView{

    FragmentHomeBinding binding;
    private ListDataAdapter listDataAdapter;
    private ArrayList<String> inputListString;
    private Logic logic;
    private ArrayList<BoardingPassEntity> listEntity = new ArrayList<>();

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
        listDataAdapter = new ListDataAdapter(listEntity,this::onDetail);
        binding.listRecycleview.setAdapter(listDataAdapter);
        //binding.listRecycleview.setLayoutManager(new GridLayoutManager(getContext(), 8));
        binding.listRecycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        inputListString = MyApp.getBoardingPassCode();
        strToEntity();
        binding.button.setOnClickListener(view -> {
            strToEntity();
        });
    }

    private void strToEntity() {
        BoardingPassEntity entity;
        for (String input : inputListString) {
            logic = new Logic();
            int row = logic.eliminateRow(input);
            int column = logic.eliminateRow(input);
            int seatID = logic.getSeatId(row,column);
            entity = new BoardingPassEntity(input,seatID,row,column);
            listEntity.add(entity);
        }

        listDataAdapter.notifyDataSetChanged();

    }


    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }

    @Override
    public void onDetail(BoardingPassEntity boardingPassEntity) {

    }
}