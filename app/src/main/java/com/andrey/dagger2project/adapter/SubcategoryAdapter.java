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
import com.andrey.dagger2project.activity.ServiceActivity;
import com.andrey.dagger2project.database.model.Subcategory;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubcategoryAdapter extends RecyclerView.Adapter<SubcategoryAdapter.SubcategoryViewHolder> {
    private final LayoutInflater mInflater;
    private List<Subcategory> mServiceCategoryList;
    private Context mContext;

    public SubcategoryAdapter(Context context, List<Subcategory> mList) {
        mServiceCategoryList = mList;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public SubcategoryAdapter.SubcategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.service_category, parent, false);
        return new SubcategoryAdapter.SubcategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubcategoryAdapter.SubcategoryViewHolder holder, int position) {
        Picasso.with(mContext).load(mServiceCategoryList.get(position).getPictureUrl()).into(holder.picture);
        holder.title.setText(mServiceCategoryList.get(position).getTitle());
    }

    public void setItem(List<Subcategory> messages){
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

    class SubcategoryViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.picture)
        ImageView picture;
        @BindView(R.id.title)
        TextView title;

        public SubcategoryViewHolder(View v){
            super(v);

            ButterKnife.bind(this, v);
            v.setTag(this);
            View.OnClickListener mOnItemClickListener = view -> {
                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
                int position = viewHolder.getAdapterPosition();
                Long id = mServiceCategoryList.get(position).getId();
                Intent intent = new Intent(mContext, ServiceActivity.class);
                intent.putExtra("id", id);
                mContext.startActivity(intent);
            };
            v.setOnClickListener(mOnItemClickListener);
        }
    }
}
