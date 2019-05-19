package com.zomato_demo.ZomotoDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;

import com.zomato_demo.R;
import com.zomato_demo.ViewModels.DeatailsViewModel;
import com.zomato_demo.common.Const;
import com.zomato_demo.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    private String res_id;
    DeatailsViewModel deatailsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_details);
        DeatailsViewModel.Factory factory = new DeatailsViewModel.Factory(getApplication(), "");
        deatailsViewModel = ViewModelProviders.of(DetailsActivity.this, factory).get(DeatailsViewModel.class);



        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (!TextUtils.isEmpty(bundle.getString(Const.Local.ID))) {
                res_id = bundle.getString(Const.Local.ID);
            }
        }
    }
}
