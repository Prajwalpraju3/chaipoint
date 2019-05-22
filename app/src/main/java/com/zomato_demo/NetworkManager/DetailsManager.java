package com.zomato_demo.NetworkManager;

import android.content.Context;
import android.widget.Toast;

import com.zomato_demo.Interfaces.ApiInterface;
import com.zomato_demo.Interfaces.DataCallBackListener;
import com.zomato_demo.models.DetailsModel;
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
//        modelCall = storeInterface.getDetails("16774318");
        modelCall = storeInterface.getDetails(id);
        BaseManager baseManager = new BaseManager(context);
        baseManager.sendRequest(modelCall, new DataCallBackListener() {
            @Override
            public void onResponse(Object body) {
                if (body instanceof DetailsModel) {
                    DetailsModel detailsModel = (DetailsModel) body;
                    data.setValue(detailsModel);

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
