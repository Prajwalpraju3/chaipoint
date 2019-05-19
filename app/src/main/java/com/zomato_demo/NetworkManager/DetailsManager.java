package com.zomato_demo.NetworkManager;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zomato_demo.Interfaces.ApiInterface;
import com.zomato_demo.Interfaces.DataCallBackListener;
import com.zomato_demo.Models.DetailsModel;
import com.zomato_demo.R;
import com.zomato_demo.common.AppUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;


public class DetailsManager {
    private Context context;
    private Call<DetailsModel> modelCall;
    private PreferenceManager preferenceManager;
    private final MutableLiveData<DetailsModel> data;
    private int page_count=10;
    public DetailsManager(Context context){
        this.context=context;
        preferenceManager=new PreferenceManager(context);
        data = new MutableLiveData<>();
    }

    public LiveData<DetailsModel> getDetailsModelRequest(String id) {
        //oAuthentication
//        final MutableLiveData<DetailsModel> data = new MutableLiveData<>();
        if (!AppUtils.isNetworkAvailable(context)) {
            Toast.makeText(context, R.string.no_internet, Toast.LENGTH_SHORT).show();
            return data;
        }

       ApiInterface storeInterface = NetworkGenerator.getAuthClient(context).create(ApiInterface.class);
        modelCall = storeInterface.getDetails("16774318");
        BaseManager baseManager = new BaseManager(context);
        baseManager.sendRequest(modelCall, new DataCallBackListener() {
            @Override
            public void onResponse(Object body) {
                if (body instanceof DetailsModel) {
                    DetailsModel DetailsModel = (DetailsModel) body;
                   Toast.makeText(context, DetailsModel.getName(),Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onError(Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }


    public void cancelRequest() {
        modelCall.cancel();
    }
}
