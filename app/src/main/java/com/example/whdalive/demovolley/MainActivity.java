package com.example.whdalive.demovolley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.whdalive.demovolley.Custom.VolleyCustom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //简单Request--StringRequest，JSONRequest
        findViewById(R.id.request_simple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VolleySimple.class));
            }
        });
        //图片相关的Request
        findViewById(R.id.request_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VolleyImage.class));
            }
        });
        //自定义Request
        findViewById(R.id.request_custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VolleyCustom.class));
            }
        });
    }
}
