package com.kavya.farmersapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.kavya.farmersapp.Models.Farm;
import com.kavya.farmersapp.ViewModels.FarmsViewModel;
import com.kavya.farmersapp.adapters.FarmRecylerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FarmsViewModel farmsViewModel;
    private FarmRecylerAdapter recylerAdapter;
    private RecyclerView recyclerView;
    private EditText inputSearch;
    private List<Farm> farmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.farms_list_view);
        inputSearch = findViewById(R.id.inputSearch);

        farmsViewModel = ViewModelProviders.of(this).get(FarmsViewModel.class);

        farmsViewModel.getFarm().observe(this, new Observer<List<Farm>>() {
            @Override
            public void onChanged(@Nullable List<Farm> farms) {
                farmList = farms;
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recylerAdapter = new FarmRecylerAdapter(farms,getApplicationContext());
                recyclerView.setAdapter(recylerAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    void filter(String text){
        List<Farm> temp = new ArrayList();
        for (int i =0 ;i<farmList.size(); i++){
            if(farmList.get(i).farm_owner.contains(text)){
                temp.add(farmList.get(i));
            }
        }
        //update recyclerview
        recylerAdapter.updateList(temp);
    }
}
