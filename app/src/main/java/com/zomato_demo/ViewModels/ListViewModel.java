package com.zomato_demo.ViewModels;

import android.app.Application;

import com.zomato_demo.NetworkManager.DetailsManager;
import com.zomato_demo.models.DataList;
import com.zomato_demo.models.DetailsModel;
import com.zomato_demo.models.Example;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class ListViewModel extends BaseViewModel {

    private LiveData<List<Example>> liveData;
    private ObservableField<List<Example>> observableField = new ObservableField<>();
    private DetailsManager detailsManager;
    private ListViewModel(Application application, String id){
        super(application);
        detailsManager = new DetailsManager(application);
        callNextPageResult(id);
    }

    private void callNextPageResult(String id){
        this.liveData= detailsManager.getDetailsModelRequest(id);
    }


    public LiveData<List<Example>> getObservable() {
        return liveData;
    }


    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application application;

        private final String id;

        public Factory(@NonNull Application application, String id) {
            this.application = application;
            this.id = id;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new ListViewModel(application,id);
        }
    }

}
