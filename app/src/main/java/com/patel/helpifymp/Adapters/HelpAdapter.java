package com.patel.helpifymp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.patel.helpifymp.Models.ProfessionalHelp;
import com.patel.helpifymp.R;

import java.util.ArrayList;

public class HelpAdapter extends RecyclerView.Adapter<MyViewHolder2> {

    private Context context;
    private ArrayList<ProfessionalHelp> array;

    public HelpAdapter(Context context, ArrayList<ProfessionalHelp> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_professional_help, null);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {

        ProfessionalHelp contact = array.get(position);

        holder.dn.setText(array.get(position).getDName());
        holder.ds.setText(array.get(position).getDSpecilize());
        holder.de.setText(array.get(position).getDExperience());
        holder.dm.setText(array.get(position).getDMobile());

        holder.ivcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + contact.DMobile));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return array.size();
    }
}

