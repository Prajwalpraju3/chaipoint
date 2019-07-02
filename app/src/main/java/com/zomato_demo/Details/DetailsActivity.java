package com.zomato_demo.ZomotoDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.zomato_demo.models.DetailsModel;
import com.zomato_demo.R;
import com.zomato_demo.ViewModels.DeatailsViewModel;
import com.zomato_demo.common.Const;
import com.zomato_demo.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    public ActivityDetailsBinding binding;
    private String res_id ="";
    DeatailsViewModel deatailsViewModel;
    String deeplink="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_details);
        binding.setActivity(DetailsActivity.this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
//            if (!TextUtils.isEmpty(bundle.getString(Const.Local.ID))) {
//                res_id = bundle.getString(Const.Local.ID);
//            }
        }

        binding.pg.setVisibility(View.VISIBLE);


        DeatailsViewModel.Factory factory = new DeatailsViewModel.Factory(getApplication(), res_id);
        deatailsViewModel = ViewModelProviders.of(DetailsActivity.this, factory).get(DeatailsViewModel.class);

        observeViewModel();
binding.btDeeplink.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {
            Toast.makeText(DetailsActivity.this,deeplink,Toast.LENGTH_LONG).show();
            Uri myAction = Uri.parse("http://"+deeplink);

            PackageManager packageManager = getPackageManager();
            Intent intent = packageManager.getLaunchIntentForPackage("com.application.zomato");

            if (intent != null) {
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(myAction);
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});

    }


public void nothing(){

}


    private void observeViewModel() {
        // Observe project data
//        deatailsViewModel.getObservable().observe(this, new Observer<DetailsModel>() {
//            @Override
//            public void onChanged(DetailsModel detailsModel) {
//                if (detailsModel!=null){
//                    binding.pg.setVisibility(View.GONE);
//                    binding.setDetails(detailsModel);
//                    deeplink=detailsModel.getDeeplink();
//
//
//                }
//            }
//        });
    }



    public void onButtonClick(View view) {
        try {
            Intent intent = new Intent (Intent.ACTION_VIEW);
            intent.setData (Uri.parse (""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
