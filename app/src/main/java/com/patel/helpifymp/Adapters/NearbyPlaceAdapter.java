package com.patel.helpifymp.Adapters;

import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.patel.helpifymp.Models.ItemNearbyPlace;
import com.patel.helpifymp.databinding.ItemNearbyPlacesBinding;

import java.util.ArrayList;

public class NearbyPlaceAdapter extends RecyclerView.Adapter<NearbyPlaceAdapter.ViewHolder> {
    
    private ArrayList<ItemNearbyPlace> list;
    private Context context;

    public NearbyPlaceAdapter(ArrayList<ItemNearbyPlace> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(ItemNearbyPlacesBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemNearbyPlace contact = list.get(position);

        holder.binding.nameHospital.setText(contact.name);
        holder.binding.addressHospital.setText(contact.address);

        holder.binding.callIcon.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + contact.phoneNumber));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemNearbyPlacesBinding binding;

        public ViewHolder(ItemNearbyPlacesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
