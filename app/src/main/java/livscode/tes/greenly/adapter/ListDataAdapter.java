package livscode.tes.greenly.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import livscode.tes.greenly.data.BoardingPassEntity;
import livscode.tes.greenly.databinding.HolderViewBoardingPassBinding;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.DataViewHolder>
        implements Filterable {

    private static ArrayList<BoardingPassEntity> boardingPassEntities,boardingPassEntitiesFiltered;
    private OnDetailView onDetailView;
    private ValueFilter valueFilter;

    public ListDataAdapter(ArrayList<BoardingPassEntity> boardingPassEntities, OnDetailView onDetailView) {
        this.boardingPassEntities = boardingPassEntities;
        this.boardingPassEntitiesFiltered = boardingPassEntities;
        this.onDetailView = onDetailView;
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    static class DataViewHolder extends RecyclerView.ViewHolder {

        HolderViewBoardingPassBinding binding;

        public DataViewHolder(HolderViewBoardingPassBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

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
        BoardingPassEntity b = boardingPassEntitiesFiltered.get(position);
        DataViewHolder holder1 = holder;
        holder1.binding.boardingPassCode.setText(b.getBoardingPassCode());
        holder1.binding.seatId.setText("Seat ID : " + String.valueOf(b.getSeatId()));
        holder1.binding.row.setText("Row : " + String.valueOf(b.getRow()));
        holder1.binding.column.setText("Column : " + String.valueOf(b.getColumn()));
    }

    @Override
    public int getItemCount() {
        return boardingPassEntitiesFiltered.size();
    }

    private class ValueFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            CharSequence constraintUpperCase = constraint.toString().toUpperCase();
            if (constraintUpperCase != null && constraintUpperCase.toString().length() > 0) {
                ArrayList<BoardingPassEntity> hasilFilter = new ArrayList<>();
                for (BoardingPassEntity inventory : boardingPassEntities) {
                    if ((inventory.getBoardingPassCode().toUpperCase()).contains(constraintUpperCase)) {
                        hasilFilter.add(inventory);
                    }
                }
                results.values = hasilFilter;
            }else {
                results.values = boardingPassEntities;
            }

            return results;

        }
        @Override
        protected void publishResults (CharSequence charSequence, FilterResults filterResults){
            boardingPassEntitiesFiltered = (ArrayList<BoardingPassEntity>) filterResults.values;
            notifyDataSetChanged();
        }
    }

    public interface OnDetailView {
        void onDetail(BoardingPassEntity boardingPassEntity);
    }
}
