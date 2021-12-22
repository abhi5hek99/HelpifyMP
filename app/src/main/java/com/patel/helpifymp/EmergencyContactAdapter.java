package com.patel.helpifymp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.patel.helpifymp.Models.EmergencyContacts;
import com.patel.helpifymp.databinding.ItemEmergencyContactsBinding;

import java.util.ArrayList;

public class EmergencyContactAdapter extends RecyclerView.Adapter<EmergencyContactAdapter.ViewHolder> {

    private ArrayList<EmergencyContacts> list;
    private Context context;
    private ClickListener clickListener;

    public EmergencyContactAdapter(ArrayList<EmergencyContacts> list, Context context, ClickListener clickListener) {
        this.list = list;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(ItemEmergencyContactsBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EmergencyContacts contact = list.get(position);

        holder.binding.namePerson.setText(contact.Name);
        holder.binding.relationPerson.setText(contact.relation);

        holder.binding.callIcon.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + contact.contact));
            context.startActivity(intent);
        });

        holder.binding.deleteIcon.setOnClickListener(view -> {
            clickListener.onClick(contact.contact);
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemEmergencyContactsBinding binding;

        public ViewHolder(ItemEmergencyContactsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
