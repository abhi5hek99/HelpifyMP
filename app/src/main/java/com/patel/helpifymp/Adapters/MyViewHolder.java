package com.patel.helpifymp.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.patel.helpifymp.ItemClickListener;
import com.patel.helpifymp.R;


public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView pn;
    ItemClickListener itemClickListener;

    MyViewHolder(@NonNull View itemView) {
        super(itemView);

        this.pn = itemView.findViewById(R.id.tvProblemName);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v,getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }
}
