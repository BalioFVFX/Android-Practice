package com.example.erik.recyclerview.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.erik.recyclerview.R;
import com.example.erik.recyclerview.models.Computer;

import java.util.List;

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyRecyclerViewHolder> {

    private final ICheckBoxListener iCheckBoxListener;
    private Context context;
    private List<Computer> data;

    public MyRecyclerView(Context context, List<Computer> data, ICheckBoxListener iCheckBoxListener) {
        this.context = context;
        this.data = data;
        this.iCheckBoxListener = iCheckBoxListener;
    }

    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Here we make an instance of our ViewHolder
        LayoutInflater inflater = LayoutInflater.from(context);
        View recView = inflater.inflate(R.layout.rec_view, null);
        return new MyRecyclerViewHolder(recView, iCheckBoxListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder myRecyclerViewHolder, int i) {
        // Here we persist our data to the views
        myRecyclerViewHolder.nameTextView.setText(data.get(i).getName());
        myRecyclerViewHolder.cpuTextView.setText(data.get(i).getCpu());
        myRecyclerViewHolder.ramTextView.setText(data.get(i).getRam());
        myRecyclerViewHolder.priceTextView.setText(data.get(i).getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    class MyRecyclerViewHolder extends RecyclerView.ViewHolder{

        private final ICheckBoxListener iCheckBoxListener;
        public TextView nameTextView;
        public TextView cpuTextView;
        public TextView ramTextView;
        public TextView priceTextView;
        public CheckBox checkBox;

        public MyRecyclerViewHolder(@NonNull final View itemView, final ICheckBoxListener iCheckBoxListener) {
            super(itemView);
            this.nameTextView = itemView.findViewById(R.id.tv_name);
            this.cpuTextView = itemView.findViewById(R.id.tv_cpu);
            this.ramTextView = itemView.findViewById(R.id.tv_ram);
            this.priceTextView = itemView.findViewById(R.id.tv_price);
            this.checkBox = itemView.findViewById(R.id.checkbox);
            this.iCheckBoxListener = iCheckBoxListener;
            this.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iCheckBoxListener.onCheckBoxClickListener(nameTextView, getAdapterPosition());
                }
            });
        }
    }

    public interface ICheckBoxListener{
        void onCheckBoxClickListener(TextView name, int position);
    }

}
