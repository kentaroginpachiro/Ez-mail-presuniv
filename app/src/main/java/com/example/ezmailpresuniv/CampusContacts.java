package com.example.ezmailpresuniv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CampusContacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_contacts);
        CardView academic = findViewById(R.id.academic);
        CardView finance = findViewById(R.id.finance);
        CardView icc = findViewById(R.id.icc);
        CardView ellc = findViewById(R.id.ellc);
        CardView ga = findViewById(R.id.ga);
        CardView sa = findViewById(R.id.sa);
        CardView io = findViewById(R.id.io);
        CardView alumni = findViewById(R.id.alumni);
        CardView dewan = findViewById(R.id.dewan);
        CardView dev = findViewById(R.id.dev);

        academic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampusContacts.this, Academic.class);

                startActivity(intent);
            }
        });
        finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampusContacts.this, Finance.class);

                startActivity(intent);
            }
        });
        icc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampusContacts.this, ICC.class);

                startActivity(intent);
            }
        });
        ellc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampusContacts.this, ELLC.class);

                startActivity(intent);
            }
        });
        ga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampusContacts.this, GA.class);

                startActivity(intent);
            }
        });
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampusContacts.this, SA.class);

                startActivity(intent);
            }
        });
        io.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampusContacts.this, IO.class);

                startActivity(intent);
            }
        });
        alumni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampusContacts.this, Alumni.class);

                startActivity(intent);
            }
        });
        dewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampusContacts.this, DewanEtik.class);

                startActivity(intent);
            }
        });
        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampusContacts.this, Developer.class);

                startActivity(intent);
            }
        });
    }
}