package com.example.medi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class AppointmentActivity extends AppCompatActivity {
    private final FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    EditText userFullName,userMobileNumber,userAddress;
    TextView doctorConfirmName;
    Button confirmButton;
    String doctorConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        userFullName = findViewById(R.id.UserFullName);
        userMobileNumber = findViewById(R.id.UserMobileNumber);
        userAddress = findViewById(R.id.UserAddress);
        doctorConfirmName=findViewById(R.id.doctorConfirmName);
        confirmButton=findViewById(R.id.confirmBooking);

        doctorConfirm = getIntent().getStringExtra("doctorConfirmName");
        doctorConfirmName.setText(doctorConfirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userFullNameGet = userFullName.getText().toString().trim();
                String userMobileNumberGet = userMobileNumber.getText().toString().trim();
                String userAddressGet = userAddress.getText().toString().trim();

                DocumentReference documentReference = fStore.collection("Booking").document();
                Map<String,Object> booking = new HashMap<>();
                booking.put("UserName",userFullNameGet);
                booking.put("UserMobileNumber",userMobileNumberGet);
                booking.put("UserAddress",userAddressGet);
                documentReference.set(booking).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(AppointmentActivity.this, "Thank You For Booking", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}