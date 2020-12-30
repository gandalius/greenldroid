package livscode.tes.greenly;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import livscode.tes.greenly.adapter.ListDataAdapter;
import livscode.tes.greenly.core.Logic;
import livscode.tes.greenly.data.BoardingPassEntity;
import livscode.tes.greenly.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements
        ListDataAdapter.OnDetailView {

    FragmentHomeBinding binding;
    private ListDataAdapter listDataAdapter;
    private ArrayList<String> inputListString;
    private Logic logic;
    private List<BoardingPassEntity> listEntity = new ArrayList<>();
    public static Comparator<BoardingPassEntity> seatIdSortComparator = new Comparator<BoardingPassEntity>() {
        @Override
        public int compare(BoardingPassEntity s1, BoardingPassEntity s2) {
            /*For ascending order*//*
            //return s1.getSeatId()-s2.getSeatId();

            /*For descending order  */
            return s2.getSeatId() - s1.getSeatId();

        }
    };

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
        listDataAdapter = new ListDataAdapter(listEntity, this::onDetail);
        binding.listRecycleview.setAdapter(listDataAdapter);
        binding.listRecycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        strToEntity();
        binding.buttonReset.setOnClickListener(view -> {
            strToEntity();
        });
        binding.buttonMax.setOnClickListener(view -> {
            //listEntity.sort(seatIdSortComparator);
            sorting();
        });

        binding.searchView.setQueryHint("Find Boarding Pass Code..");
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String keyword) {
                //progressBar.setVisibility(View.VISIBLE);
                if (keyword.length() > 0) {
                    find(keyword);
                } else {
                    strToEntity();
                }

                return false;
            }
        });

        binding.searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                strToEntity();
                return false;
            }
        });

    }

    public void find(String key) {
        listDataAdapter.getFilter().filter(key);
    }

    private void strToEntity() {
        binding.progressbar.setVisibility(View.VISIBLE);
        listEntity.clear();
        listDataAdapter.notifyDataSetChanged();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                BoardingPassEntity entity;
                inputListString = MyApp.getBoardingPassCode();
                for (String input : inputListString) {
                    logic = new Logic();
                    int row = logic.eliminateRow(input);
                    int column = logic.eliminateColumn(input);
                    int seatID = logic.getSeatId(row, column);
                    entity = new BoardingPassEntity(input, seatID, row, column);
                    listEntity.add(entity);
                }

                listDataAdapter.setList(listEntity);
                listDataAdapter.notifyDataSetChanged();
                binding.textView.setText(String.valueOf(listEntity.size()));
                binding.progressbar.setVisibility(View.GONE);
            }
        }, 3000);
    }

    private void sorting() {
        binding.progressbar.setVisibility(View.VISIBLE);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                List<BoardingPassEntity> sortedList = listEntity.stream()
                        .sorted(seatIdSortComparator)
                        .collect(Collectors.toList());
                listDataAdapter.setList(sortedList);
                binding.textView.setText(String.valueOf(listEntity.size()));
                binding.progressbar.setVisibility(View.GONE);
            }
        }, 3000);
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