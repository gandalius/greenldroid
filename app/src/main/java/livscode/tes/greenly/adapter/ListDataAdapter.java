package livscode.tes.greenly.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import livscode.tes.greenly.data.BoardingPassEntity;
import livscode.tes.greenly.databinding.HolderViewBoardingPassBinding;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.DataViewHolder> {

    ArrayList<BoardingPassEntity> boardingPassEntities;

    public ListDataAdapter(ArrayList<BoardingPassEntity> boardingPassEntities) {
        this.boardingPassEntities = boardingPassEntities;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataViewHolder(
                HolderViewBoardingPassBinding
                        .inflate(
                                LayoutInflater.from(parent.getContext()),
                                parent,
                                false
                )
        );
    }



    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        BoardingPassEntity b = boardingPassEntities.get(position);
        DataViewHolder holder1 = holder;
        holder1.binding.boardingPassCode.setText(b.getBoardingPassCode());
        holder1.binding.seatId.setText(String.valueOf(b.getSeatId()));
    }

    @Override
    public int getItemCount() {
        return boardingPassEntities.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder {

        HolderViewBoardingPassBinding binding;
        public DataViewHolder(HolderViewBoardingPassBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

    }
}
