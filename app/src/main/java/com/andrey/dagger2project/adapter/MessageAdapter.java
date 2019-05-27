package com.andrey.dagger2project.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrey.dagger2project.R;
import com.andrey.dagger2project.database.model.Message;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private List<Message> messageList;
    private final LayoutInflater mInflater;

    public MessageAdapter(Context context, List<Message> mMessages) {
        messageList = mMessages;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.message, parent, false);
        return new MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.messageUser.setText(messageList.get(position).getUserLogin());
        holder.messageText.setText(messageList.get(position).getMessageText());
    }

    public void setItem(List<Message> messages){
        messageList = messages;
    }

    public void clearItem() {
        messageList.clear();
    }

    @Override
    public int getItemCount() {
        if (messageList != null)
            return messageList.size();
        else return 0;
    }

    class MessageViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.message_user) TextView messageUser;
        @BindView(R.id.message_text) TextView messageText;

        public MessageViewHolder(View v){
            super(v);
            ButterKnife.bind(this, v);
        }
    }

}






