package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private TextView mTextViewResult1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);

        OkHttpClient client = new OkHttpClient();

        String url = "https://reqres.in/api/users?pages=1";

        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    String myResponse = response.body().string();

                    MainActivity.this.runOnUiThread(() -> mTextViewResult.setText(myResponse));
                }
            }
        });
    }

    public void requesterOn (View view) {
        mTextViewResult1 = findViewById(R.id.textView1);

        OkHttpClient client2 = new OkHttpClient();

        String url2 = "https://reqres.in/api/users?page=3";

        Request request = new Request.Builder().url(url2).build();

        client2.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    String myResponse2 = response.body().string();

                    MainActivity.this.runOnUiThread(() -> mTextViewResult1.setText(myResponse2));
                }
            }
        });
    }

    public String requestPost(View view) throws IOException {
        PostExample example = new PostExample();
        String json = example.bowlingJson("Jesse", "Jake");
        String response = example.post("http://www.roundsapp.com/post", json);
        System.out.println(response);

    }


}