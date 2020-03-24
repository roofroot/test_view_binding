package com.my.test2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/**
 * Created by Administrator on 16-7-18.
 */
public abstract class BaseAdapter<T, B extends ViewBinding> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {
    protected OnItemClick onItemClick;
    protected List<T> mDatas;
    protected Context context;

    public List<T> getmDatas() {
        return mDatas;
    }

    public void setmDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    public BaseAdapter(Context context) {
        this.context = context;
    }

    public BaseAdapter(Context context, List<T> mDatas) {
        this.mDatas = mDatas;
        this.context = context;
    }

    public OnItemClick getOnItemClick() {
        return onItemClick;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        B binding = setBinding(inflater, parent);
        ViewHolder<B> viewHolder = new ViewHolder<B>(binding.getRoot());
        viewHolder.setBinding(binding);
        if(onItemClick!=null){
            viewHolder.setOnItemClick(onItemClick);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder<B> myholder=(ViewHolder<B>) holder;
        onBindHolder(myholder,position);
    }
    protected abstract void onBindHolder(ViewHolder<B> holder, int position);

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected abstract B setBinding(LayoutInflater inflater, ViewGroup parent);

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public static class ViewHolder<B extends ViewBinding> extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected OnItemClick onItemClick;
        public B binding;

        public OnItemClick getOnItemClick() {
            return onItemClick;
        }

        public void setOnItemClick(OnItemClick onItemClick) {
            this.onItemClick = onItemClick;
        }

        public B getBinding() {
            return binding;
        }

        public void setBinding(B binding) {
            this.binding = binding;
        }

        public ViewHolder(View itemView) {
            super(itemView);
        }
        public void setClick(View... views){
            if(onItemClick!=null) {
                for (View view : views) {
                    view.setOnClickListener(this);
                }
            }
        }

        @Override
        public void onClick(View v) {
            onItemClick.onClick(v,getAdapterPosition());
        }
    }

    public static interface  OnItemClick{
        void onClick(View view, int position);
    }

}