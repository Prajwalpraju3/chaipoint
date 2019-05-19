package com.zomato_demo.Interfaces;


public interface DataCallBackListener<E>{
    void onResponse(E body);
    void onError(Throwable t);
}
