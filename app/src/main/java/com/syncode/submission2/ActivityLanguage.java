package com.syncode.submission2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLanguage extends AppCompatActivity {
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        radioGroup = findViewById(R.id.rb_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_bahasa:
                        sendLang("in");
                        break;
                    case R.id.rb_english:
                        sendLang("en");
                        break;
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }


    private void sendLang(String lang) {
        Intent gotomain = new Intent(this, MainActivity.class);
        gotomain.putExtra("lang", lang);
        startActivity(gotomain);
        finish();
    }
}
