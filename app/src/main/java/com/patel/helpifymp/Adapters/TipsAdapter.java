package com.patel.helpifymp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.patel.helpifymp.ItemClickListener;
import com.patel.helpifymp.MentalHealthTips2Activity;
import com.patel.helpifymp.Models.MentalHealthProblem;
import com.patel.helpifymp.R;

import java.util.ArrayList;

public class TipsAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    ArrayList<MentalHealthProblem> array;

    public TipsAdapter(Context context, ArrayList<MentalHealthProblem> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mental_health_tips, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.pn.setText(array.get(position).getPname());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                String mName = array.get(position).getPname();
                String mTip = array.get(position).getPtip();

                Intent intent = new Intent(context, MentalHealthTips2Activity.class);
                intent.putExtra("Pname",mName);
                intent.putExtra("Ptip",mTip);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return array.size();
    }
}
