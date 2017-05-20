package com.example.catlittlebox04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Button calenderBtn = (Button) findViewById(R.id.calenderBtn);
        calenderBtn.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {
                Intent intent = new Intent(StatisticsActivity.this, CalandarActivity.class);
                startActivity(intent);
            }
        });

        Button settingsBtn = (Button) findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {
                Intent intent = new Intent(StatisticsActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
