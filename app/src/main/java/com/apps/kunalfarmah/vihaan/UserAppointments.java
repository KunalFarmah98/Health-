package com.apps.kunalfarmah.vihaan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class UserAppointments extends AppCompatActivity {

    RecyclerView appointmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_appointments);

        appointmentList = findViewById(R.id.user_appointments_list);

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("userbase")
                .child("patients")
                .child(FirebaseAuth.getInstance().getUid())
                .child("appointments")
                .limitToFirst(50);

        AppointmentListAdapter appointmentListAdapter = new AppointmentListAdapter(R.layout.appointment_layout, query, getApplicationContext());
        appointmentList.setAdapter(appointmentListAdapter);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        appointmentList.setLayoutManager(layoutManager);
    }
}
