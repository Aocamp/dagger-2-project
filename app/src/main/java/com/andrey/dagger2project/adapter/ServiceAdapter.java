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
import com.andrey.dagger2project.activity.ServiceFieldActivity;
import com.andrey.dagger2project.activity.SubServiceActivity;
import com.andrey.dagger2project.database.model.Service;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>{
    private final LayoutInflater mInflater;
    private List<Service> mServiceList;
    private Context mContext;

    public ServiceAdapter(Context context, List<Service> mList) {
        mServiceList = mList;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public ServiceAdapter.ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.service_category, parent, false);
        return new ServiceAdapter.ServiceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.ServiceViewHolder holder, int position) {
        Picasso.with(mContext).load(mServiceList.get(position).getPictureUrl()).into(holder.picture);
        holder.title.setText(mServiceList.get(position).getTitle());
    }

    public void setItem(List<Service> messages){
        mServiceList = messages;
    }

    public void clearItem() {
        mServiceList.clear();
    }

    @Override
    public int getItemCount() {
        if (mServiceList != null)
            return mServiceList.size();
        else return 0;
    }

    class ServiceViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.picture)
        ImageView picture;
        @BindView(R.id.title)
        TextView title;

        public ServiceViewHolder(View v){
            super(v);

            ButterKnife.bind(this, v);
            v.setTag(this);
            View.OnClickListener mOnItemClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
                    int position = viewHolder.getAdapterPosition();
                    Service service = mServiceList.get(position);
                    Gson gson = new Gson();
                    try {
                        JSONObject json = new JSONObject(gson.toJson(service));
                        Intent intent = new Intent();
                        intent.putExtra("service", json.toString());
                        if (!service.getChildren().isEmpty()){
                            intent.setClass(mContext, SubServiceActivity.class);
                        } else {
                            intent.setClass(mContext, ServiceFieldActivity.class);
                        }
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
