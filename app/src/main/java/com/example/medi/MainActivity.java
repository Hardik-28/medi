package com.example.medi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    DoctorAdpater doctorAdpater;


    RecyclerView doctorRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doctorRecyclerview = findViewById(R.id.doctorRecyclerview);
        doctorRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        FirestoreRecyclerOptions<Doctor> doctors = new FirestoreRecyclerOptions.Builder<Doctor>().
                setQuery(FirebaseFirestore.getInstance().collection("Doctor"),Doctor.class).build();
        doctorAdpater=new DoctorAdpater(doctors);
        doctorRecyclerview.setAdapter(doctorAdpater);


    }

    @Override
    protected void onStart() {
        super.onStart();
        doctorAdpater.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        doctorAdpater.stopListening();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}