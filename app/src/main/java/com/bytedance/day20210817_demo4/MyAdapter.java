package com.bytedance.day20210817_demo4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> list;

    public MyAdapter(List<String> list){
        this.list=list;
    }


    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
//        return new MyViewHolder(view);
            View view=null;
            switch (viewType){
                case 0:
                    view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item1,parent,false);
                    break;
                case 1:
                    view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item2,parent,false);
                    break;
                case 2:
                    view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item3,parent,false);
                    break;
            }
            return new MyViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyAdapter.MyViewHolder holder, int position) {
        holder.bindData(list.get(position));
    }


    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.my_textview);
        }

        public void bindData(String str){
            textView.setText(str);
        }
    }
}
