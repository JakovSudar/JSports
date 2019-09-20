package hr.ferit.sudar.jakov.jsports;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<String> arrayList;
    private ItemClickListener listener;


    public RecyclerAdapter(ArrayList<String> arrayList, ItemClickListener listener){
        this.arrayList = arrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder viewHolder, int position) {
        viewHolder.textView.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        LinearLayout linearLayout;

        public RecyclerViewHolder(View view){
            super (view);
            textView = view.findViewById(R.id.tv_item);
            linearLayout = view.findViewById(R.id.ll_row);
            linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.OnItemClick(getAdapterPosition());

        }
    }

}
