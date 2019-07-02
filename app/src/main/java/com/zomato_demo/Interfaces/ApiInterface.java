package com.zomato_demo.Interfaces;

import com.zomato_demo.common.Const;
import com.zomato_demo.models.DataList;
import com.zomato_demo.models.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
//    @GET(Const.Route.STORE_LIST_URL)
//    Call<DetailsModel> geStoreModelResponse();

    @GET(Const.Local.SUBDOMAIN)
    Call<List<Example>> getDetails();
}
