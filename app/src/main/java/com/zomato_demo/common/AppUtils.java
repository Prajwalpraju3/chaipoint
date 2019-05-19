package com.zomato_demo.common;


import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zomato_demo.R;


import androidx.databinding.BindingAdapter;

public class AppUtils {

    @BindingAdapter({"imageUrl"})
    public static void imageUrl(ImageView view, String imageUrl) {
        try {
            if (imageUrl != null) {
                RequestOptions requestOptions = new RequestOptions();
                Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(imageUrl).apply(requestOptions.placeholder(R.drawable.ic_launcher_background)).into(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //use this below method for store and wallpaper since the image sizes are different
    @BindingAdapter({"imageUrlWp"})
    public static void imageUrlWp(ImageView view, String imageUrl) {
        try {
            if (imageUrl != null) {
                RequestOptions requestOptions = new RequestOptions();
                Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(imageUrl).into(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @BindingAdapter({"imageBWUrl"})
    public static void imageBWUrl(ImageView view, String imageUrl) {
        try {
            if (imageUrl != null) {
                RequestOptions requestOptions = new RequestOptions();
                Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(imageUrl).apply(requestOptions.placeholder(R.drawable.ic_launcher_background)).into(view);
                ColorMatrix matrix = new ColorMatrix();
                matrix.setSaturation(0);

                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
                view.setColorFilter(filter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (NetworkInfo state : info) {
                    if (state.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

                }
//                for (int i = 0; i < info.length; i++)
//                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
//                        return true;
//                    }
            }

        }

        return false;
    }






}
