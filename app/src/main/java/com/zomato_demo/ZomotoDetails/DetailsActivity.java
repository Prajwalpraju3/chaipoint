package com.zomato_demo.ZomotoDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.zomato_demo.models.DetailsModel;
import com.zomato_demo.R;
import com.zomato_demo.ViewModels.DeatailsViewModel;
import com.zomato_demo.common.Const;
import com.zomato_demo.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    public ActivityDetailsBinding binding;
    private String res_id ="";
    DeatailsViewModel deatailsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (!TextUtils.isEmpty(bundle.getString(Const.Local.ID))) {
                res_id = bundle.getString(Const.Local.ID);
            }
        }

        binding.pg.setVisibility(View.VISIBLE);
        DeatailsViewModel.Factory factory = new DeatailsViewModel.Factory(getApplication(), res_id);
        deatailsViewModel = ViewModelProviders.of(DetailsActivity.this, factory).get(DeatailsViewModel.class);

        observeViewModel();


    }


    private void observeViewModel() {
        // Observe project data
        deatailsViewModel.getObservable().observe(this, new Observer<DetailsModel>() {
            @Override
            public void onChanged(DetailsModel detailsModel) {
                if (detailsModel!=null){
                    binding.pg.setVisibility(View.GONE);
                    binding.setDetails(detailsModel);

                }
            }
        });
    }
}
