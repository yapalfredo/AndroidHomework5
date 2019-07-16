package com.example.androidhomework5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private String[] countries = {"USA", "UK","PHILIPPINES","BRAZIL","SOUTH KOREA","MYANMAR","KAZAKHSTAN","INDIA"};
    private String[] countriesCapital = {"Washington, DC", "London", "Manila", "Brasilia", "Seoul" ,"Naypyitaw","Astana","New Delhi"};
    private String[] countriesFlag = {
            "us",
            "uk",
            "ph",
            "br",
            "sk",
            "mm",
            "kz",
            "in"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter myAdapter = new MyAdapter(this, countries, countriesCapital,countriesFlag);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
