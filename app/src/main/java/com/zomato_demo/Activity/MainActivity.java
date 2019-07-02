package com.zomato_demo.ZomotoList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.View;

import com.zomato_demo.R;
import com.zomato_demo.ViewModels.ListViewModel;
import com.zomato_demo.adapter.MyDataAdapter;
import com.zomato_demo.databinding.ActivityMainBinding;
import com.zomato_demo.models.Example;
import com.zomato_demo.models.DataList;

import java.util.List;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    ListViewModel listViewModel;
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    MyDataAdapter myDataAdapter;
    List<Example> maindata;
    boolean firsttime =true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.llPgbar.setVisibility(View.VISIBLE);

        ListViewModel.Factory factory = new ListViewModel.Factory(getApplication(), "");
        listViewModel = ViewModelProviders.of(MainActivity.this, factory).get(ListViewModel.class);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.rvNews.setLayoutManager(linearLayoutManager);
        binding.swNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(maindata!=null){

                    if(firsttime){
                        for (int i = 0 ;i<maindata.size();i++){
                            maindata.get(i).setBigView(true);
                        }
                            firsttime =false;
                    }else {
                        for (int i = 0 ;i<maindata.size();i++){
                            maindata.get(i).setBigView(false);
                        }
                        firsttime =true;
                    }
                    binding.rvNews.setAdapter(myDataAdapter);
                    myDataAdapter.notifyDataSetChanged();

                }

            }
        });
        observeViewModel();


    }

    private void observeViewModel() {
        binding.llPgbar.setVisibility(View.GONE);
        listViewModel.getObservable().observe(this, new Observer<List<Example>>() {
            @Override
            public void onChanged(List<Example> examples) {

                maindata = examples;

                myDataAdapter = new MyDataAdapter(maindata,MainActivity.this);
                binding.rvNews.setAdapter(myDataAdapter);
            }
        });
    }
}
