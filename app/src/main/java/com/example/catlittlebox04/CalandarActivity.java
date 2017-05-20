package com.example.catlittlebox04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalandarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calandar);

        Button staticsBtn = (Button) findViewById(R.id.statisticsBtn);
        staticsBtn.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {
                Intent intent = new Intent(CalandarActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });

        Button settingsBtn = (Button) findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {
                Intent intent = new Intent(CalandarActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
