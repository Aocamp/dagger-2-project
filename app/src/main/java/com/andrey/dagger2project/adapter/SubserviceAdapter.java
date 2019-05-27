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
import com.andrey.dagger2project.activity.SubserviceActivity;
import com.andrey.dagger2project.model.Subservice;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubserviceAdapter extends RecyclerView.Adapter<SubserviceAdapter.SubserviceViewHolder>{
    private final LayoutInflater mInflater;
    private List<Subservice> mSubserviceList;
    private Context mContext;

    public SubserviceAdapter(Context context, List<Subservice> mList) {
        mSubserviceList = mList;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public SubserviceAdapter.SubserviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.service_category, parent, false);
        return new SubserviceAdapter.SubserviceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubserviceAdapter.SubserviceViewHolder holder, int position) {
        Picasso.with(mContext).load(mSubserviceList.get(position).getPictureUrl()).into(holder.picture);
        holder.title.setText(mSubserviceList.get(position).getTitle());
    }

    public void setItem(List<Subservice> messages){
        mSubserviceList = messages;
    }

    public void clearItem() {
        mSubserviceList.clear();
    }

    @Override
    public int getItemCount() {
        if (mSubserviceList != null)
            return mSubserviceList.size();
        else return 0;
    }

    class SubserviceViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.picture)
        ImageView picture;
        @BindView(R.id.title)
        TextView title;

        public SubserviceViewHolder(View v){
            super(v);

            ButterKnife.bind(this, v);
            v.setTag(this);
            View.OnClickListener mOnItemClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
                    int position = viewHolder.getAdapterPosition();
                    Subservice service = mSubserviceList.get(position);
                    Gson gson = new Gson();
                    try {
                        JSONObject json = new JSONObject(gson.toJson(service));
                        Intent intent = new Intent(mContext, ServiceFieldActivity.class);
                        intent.putExtra("service", json.toString());

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