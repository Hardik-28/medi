package com.example.medi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {
    String doctorName,doctorPhoto;
    ImageView doctorProfilePhoto;
    TextView doctorNameProfile;
    Button appointmentButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        doctorName = getIntent().getStringExtra("DoctorName");
        doctorPhoto = getIntent().getStringExtra("DoctorPhoto");
        doctorProfilePhoto = findViewById(R.id.doctorProfilePhoto);
        doctorNameProfile = findViewById(R.id.doctorNameProfile);
        appointmentButton = findViewById(R.id.appointmentButton);
        doctorNameProfile.setText(doctorName);
        Picasso.get().load(doctorPhoto).into(doctorProfilePhoto);
        appointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AppointmentActivity.class);
                intent.putExtra("doctorConfirmName",doctorName);
                startActivity(intent);
            }
        });


    }


}