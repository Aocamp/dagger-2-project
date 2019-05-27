package com.andrey.dagger2project.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrey.dagger2project.R;
import com.andrey.dagger2project.activity.SubcategoryActivity;
import com.andrey.dagger2project.database.model.ServiceCategory;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceCategoryAdapter extends RecyclerView.Adapter<ServiceCategoryAdapter.ServiceCategoryViewHolder> {
    private final LayoutInflater mInflater;
    private List<ServiceCategory> mServiceCategoryList;
    private Context mContext;

    public ServiceCategoryAdapter(Context context, List<ServiceCategory> mList) {
        mServiceCategoryList = mList;
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
        Picasso.with(mContext).load(mServiceCategoryList.get(position).getPictureUrl()).into(holder.picture);
        holder.title.setText(mServiceCategoryList.get(position).getTitle());
    }

    public void setItem(List<ServiceCategory> messages){
        mServiceCategoryList = messages;
    }

    public void clearItem() {
        mServiceCategoryList.clear();
    }

    @Override
    public int getItemCount() {
        if (mServiceCategoryList != null)
            return mServiceCategoryList.size();
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
            v.setTag(this);
            View.OnClickListener mOnItemClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
                    int position = viewHolder.getAdapterPosition();
                    ServiceCategory serviceCategory = mServiceCategoryList.get(position);
                    Intent intent = new Intent(mContext, SubcategoryActivity.class);
                    Gson gson = new Gson();
                    try {
                        JSONObject json = new JSONObject(gson.toJson(serviceCategory));
                        intent.putExtra("subcategories", json.toString());
                        intent.putExtra("id", serviceCategory.getId());
                        mContext.startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            v.setOnClickListener(mOnItemClickListener);
        }
    }
}
