package com.patel.helpifymp.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.patel.helpifymp.R;

public class MyViewHolder2 extends RecyclerView.ViewHolder {

    TextView dn, ds, de, dm;
    ImageView ivcall;


    public MyViewHolder2(@NonNull View itemView) {
        super(itemView);

        this.dn = itemView.findViewById(R.id.tvDocName);
        this.ds = itemView.findViewById(R.id.tvSpecialization);
        this.de = itemView.findViewById(R.id.tvExperience);
        this.dm = itemView.findViewById(R.id.tvMobile);
        this.ivcall = itemView.findViewById(R.id.ivMobile);
    }
}
