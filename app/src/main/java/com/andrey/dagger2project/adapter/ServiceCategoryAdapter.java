package com.andrey.dagger2project.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrey.dagger2project.R;
import com.andrey.dagger2project.model.Message;
import com.andrey.dagger2project.model.ServiceCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceCategoryAdapter extends RecyclerView.Adapter<ServiceCategoryAdapter.ServiceCategoryViewHolder> {
    private List<ServiceCategory> serviceCategoryList;
    private final LayoutInflater mInflater;
    private Context mContext;

    public ServiceCategoryAdapter(Context context, List<ServiceCategory> mList) {
        serviceCategoryList = mList;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public ServiceCategoryAdapter.ServiceCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.service_category, parent, false);
        return new ServiceCategoryAdapter.ServiceCategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceCategoryAdapter.ServiceCategoryViewHolder holder, int position) {
        Picasso.with(mContext).load(serviceCategoryList.get(position).getPictureUrl()).into(holder.picture);
        holder.title.setText(serviceCategoryList.get(position).getTitle());
    }

    public void setItem(List<ServiceCategory> messages){
        serviceCategoryList = messages;
    }

    public void clearItem() {
        serviceCategoryList.clear();
    }

    @Override
    public int getItemCount() {
        if (serviceCategoryList != null)
            return serviceCategoryList.size();
        else return 0;
    }

    class ServiceCategoryViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.picture)
        ImageView picture;

        @BindView(R.id.title)
        TextView title;

        public ServiceCategoryViewHolder(View v){
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
