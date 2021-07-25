package com.example.medi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class DoctorAdpater extends FirestoreRecyclerAdapter<Doctor,DoctorAdpater.Doctorholder> {


    public DoctorAdpater(@NonNull @NotNull FirestoreRecyclerOptions<Doctor> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull DoctorAdpater.Doctorholder holder, int position, @NonNull @NotNull Doctor model) {
        holder.doctorName.setText(model.getDoctorName());
        Picasso.get().load(model.DoctorPhoto).into(holder.doctorPhoto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ProfileActivity.class);
                intent.putExtra("DoctorPhoto",model.getDoctorPhoto());
                intent.putExtra("DoctorName",model.getDoctorName());
                v.getContext().startActivity(intent);
            }
        });


    }


    @NonNull
    @NotNull
    @Override
    public Doctorholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sampledoctor,parent,false);
        return new Doctorholder(view);

    }

    public static class Doctorholder extends RecyclerView.ViewHolder{
        TextView doctorName;
        ImageView doctorPhoto;

        public Doctorholder(View view){
            super(view);
            doctorName = view.findViewById(R.id.doctorName);
            doctorPhoto=view.findViewById(R.id.doctorPhoto);

        }
    }
}
