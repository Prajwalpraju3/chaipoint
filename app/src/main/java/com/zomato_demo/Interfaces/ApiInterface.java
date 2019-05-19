package com.zomato_demo.Interfaces;

import com.zomato_demo.Models.DetailsModel;
import com.zomato_demo.common.Const;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {
//    @GET(Const.Route.STORE_LIST_URL)
//    Call<DetailsModel> geStoreModelResponse();

    @GET(Const.Local.RESTAURANT)
    Call<DetailsModel> getDetails(@Query("res_id") String res_id);
}
