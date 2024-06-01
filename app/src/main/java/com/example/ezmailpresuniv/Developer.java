package com.example.ezmailpresuniv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Developer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        TextView descTextView = findViewById(R.id.desc);
        String description = getString(R.string.dev_desc);

        description= description.replace("<br/>", "\n");

        descTextView.setText(HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_LEGACY));
    }
    public void sendEmail(View view) {
        String email = "muhammadyusuf.muhayuf@gmail.com";
        String subject = getString(R.string.emailSubject);
        String body = getString(R.string.emailBody);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

        startActivity(emailIntent);
    }
}