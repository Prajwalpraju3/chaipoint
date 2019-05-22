package com.zomato_demo.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zomato_demo.BR;
import com.zomato_demo.R;
import com.zomato_demo.databinding.ItemDetailsBinding;
import com.zomato_demo.models.ListModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ListModel> list;
    private String title;

    public ListAdapter(String title, final Context context, List<ListModel> list) {
        this.context = context;
        this.list = list;
        this.title = title;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDetailsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_details, parent, false);
        return new ListViewHolder(context, binding.getRoot(),title);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ListViewHolder) {
            ListViewHolder listViewHolder= (ListViewHolder) holder;
            ListModel listModel = list.get(position);
            ItemDetailsBinding binding = (ItemDetailsBinding) listViewHolder.getBinding();
            binding.setVariable(BR.detailsModel,listModel);
            binding.executePendingBindings();

        }
    }

    @Override
    public int getItemViewType(int position) {
        int VIEW_TYPE_ITEM = 0;
        return list.get(position) == null ? VIEW_TYPE_ITEM : VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }


}
