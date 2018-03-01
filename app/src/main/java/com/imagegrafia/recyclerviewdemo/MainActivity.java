package com.imagegrafia.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intialize recyclerView compulsary we need to set all these attributes
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //Compulsary req

        //productListName
        ArrayList<String> productList=new ArrayList(Arrays.asList("Apple","Dell","Acer","Lenovo","hp"));
        Log.i("list",productList.toString());

        //create CustomAdapter object with context and ArrayList
        CustomAdapter adapter=new CustomAdapter(this, productList);
        //attach CustomAdapter
        recyclerView.setAdapter(adapter);

    }
}
