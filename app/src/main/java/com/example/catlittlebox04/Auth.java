package com.example.catlittlebox04;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Auth extends AppCompatActivity {
    TextView serialNum;
    Button okBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        NetworkTask networkTask = new NetworkTask();
        networkTask.execute("");
        serialNum = (TextView)findViewById(R.id.serialNum);
        okBtn = (Button)findViewById(R.id.okBtn);
    }

    public class NetworkTask extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... params) {
            // HTTP 요청 준비
            HttpClient.Builder http = new HttpClient.Builder("POST", "http://52.78.207.144/application/matchSerialNum:8080/SpringToAndroid/android");
            // HTTP 요청 전송
            HttpClient post = http.create();
            post.request();

            int statusCode = post.getHttpStatusCode();

            // 응답 본문 가져오기
            String body = post.getBody();
            return body;
        }

        //@param s : doInBackground가 리턴한 값이 들어옴

        protected void onPostExecute(String s) {
            Log.d("HTTP_RESULT", s);
        }
    }

    public void authOK(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}

