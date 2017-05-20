package com.example.catlittlebox04;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import retrofit2.http.Url;

public class SettingActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    Url imageURL;
    ImageView catImage;
    Button catBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        Button staticsBtn = (Button) findViewById(R.id.statisticsBtn);
        staticsBtn.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });

        Button calenderBtn = (Button) findViewById(R.id.calenderBtn);
        calenderBtn.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, CalandarActivity.class);
                startActivity(intent);
            }
        });

        catImage = (ImageView) findViewById(R.id.catImage);
        catBtn = (Button) findViewById(R.id.catBtn);

        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openGallery();
            }
        });
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE){
            imageURL = (Url) data.getData();
            catImage.setImageURI((Uri) imageURL);
        }
    }
}
