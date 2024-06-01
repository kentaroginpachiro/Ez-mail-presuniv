package com.example.ezmailpresuniv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OrganizationContacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_contacts);
        CardView pusc = findViewById(R.id.pusc);
        CardView computing = findViewById(R.id.computing);
        CardView pufa = findViewById(R.id.pufa);
        CardView pufa1 = findViewById(R.id.pufa1);
        CardView pufa2 = findViewById(R.id.pufa2);
        CardView pufa3 = findViewById(R.id.pufa3);

        pusc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrganizationContacts.this, PUSC.class);

                startActivity(intent);
            }
        });
        computing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrganizationContacts.this, Computing.class);

                startActivity(intent);
            }
        });
        pufa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrganizationContacts.this, PUFA.class);

                startActivity(intent);
            }
        });
        pufa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrganizationContacts.this, PUFA.class);

                startActivity(intent);
            }
        });
        pufa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrganizationContacts.this, PUFA.class);

                startActivity(intent);
            }
        });
        pufa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrganizationContacts.this, PUFA.class);

                startActivity(intent);
            }
        });
    }
}