package com.example.androidhomework5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.txtViewResult);
        Button btn = findViewById(R.id.btnClose);

        ArrayList<String> res = getIntent().getExtras().getStringArrayList("SELECTED_COUNTRIES");

        tv.setText(Arrays.toString(res.toArray()));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
