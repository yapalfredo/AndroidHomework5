package com.example.androidhomework5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private String[] countries = {"USA", "UK","PHILIPPINES","BRAZIL","SOUTH KOREA","MYANMAR","KAZAKHSTAN","INDIA"};
    private String[] countriesCapital = {"Washington, DC", "London", "Manila", "Brasilia", "Seoul" ,"Naypyitaw","Astana","New Delhi"};
    private String[] countriesFlag = {"us","uk","ph","br","sk","mm","kz","in"};

    private Button btn;

    ArrayList<String> selectedCountries = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Handle the RecyclerView
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        btn = findViewById(R.id.btnMainSend);

        //Adapter for the RecyclerView
        MyAdapter myAdapter = new MyAdapter(this, countries, countriesCapital,countriesFlag, selectedCountries);

        //Assign the Adapter to the RecyclerView
        recyclerView.setAdapter(myAdapter);

        //LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putStringArrayListExtra("SELECTED_COUNTRIES",selectedCountries);
                startActivity(i);
            }
        });
    }
}
