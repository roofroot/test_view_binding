package com.my.test2.kotlinbase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Administrator on 16-7-18.
 */
abstract class BaseHaveFooterAdapter<T,  B:ViewBinding, F : ViewBinding> :RecyclerView.Adapter<BaseHaveFooterAdapter.ViewHolder<in ViewBinding>>{
    var onItemClick: OnItemClick? = null


    protected var mDatas:List<T>? = null
    protected var context: android.content.Context
    fun getmDatas(): List<T>? {
        return mDatas
    }

    fun setmDatas(mDatas:List<T>?) {
        this.mDatas = mDatas
    }

    constructor(context: android.content.Context) {
        this.context = context
    }

    constructor(context: android.content.Context, mDatas: kotlin.collections.List<T>?) {
        this.mDatas = mDatas
        this.context = context
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder<in ViewBinding> {
        val inflater = LayoutInflater.from(context)
       if (viewType == 0) {
            val binding = setBinding(inflater, parent)
            val viewHolder =   BaseHaveFooterAdapter.ViewHolder<B>(binding!!.root)
            viewHolder.binding=binding;
            if (onItemClick != null) {
                viewHolder.onItemClick = onItemClick
            }
           return viewHolder as ViewHolder<in ViewBinding>;
        } else {
            val binding = setFootBinding(inflater, parent)
            val viewHolder =
                BaseHaveFooterAdapter.ViewHolder<F>(binding!!.root)
            viewHolder.binding=binding;
            if (onItemClick != null) {
                viewHolder.onItemClick = onItemClick
            }
            return viewHolder as ViewHolder<in ViewBinding>;
        }
    }

    override fun onBindViewHolder(
        holder: BaseHaveFooterAdapter.ViewHolder<ViewBinding>,
        position: Int
    ): kotlin.Unit {
        if (position == mDatas?.size) {
            val myholder =
                holder as BaseHaveFooterAdapter.ViewHolder<B>
            onBindFooterHolder(myholder, position)
        } else {
            val myholder =
                holder as BaseHaveFooterAdapter.ViewHolder<F>
            onBindHolder(myholder, position)
        }
    }

    protected abstract fun onBindHolder(
        holder: ViewHolder<F>,
        position: Int
    ): kotlin.Unit

    protected abstract fun onBindFooterHolder(
        holder: ViewHolder<B>,
        position: Int
    ): kotlin.Unit

    override fun getItemViewType(position: Int): Int {
        return if (position == mDatas!!.size) 1 else 0
    }

    override fun getItemId(position: Int): kotlin.Long {
        return position.toLong()
    }

    protected abstract fun setBinding(inflater: LayoutInflater?, parent: ViewGroup?): B
    protected abstract fun setFootBinding(inflater: LayoutInflater?, parent: ViewGroup?): F
    override fun getItemCount(): Int {
        return if (mDatas == null) 1 else mDatas!!.size + 1
    }

    class ViewHolder<in ViewBinding>(itemView: android.view.View) :
        RecyclerView.ViewHolder(itemView), android.view.View.OnClickListener {
        var onItemClick: OnItemClick? =
            null
        var binding: androidx.viewbinding.ViewBinding? = null


        fun setClick(vararg views: android.view.View): kotlin.Unit {
            if (onItemClick != null) {
                for (view in views) {
                    view.setOnClickListener(this)
                }
            }
        }

        fun setOnFooterClick(vararg views: android.view.View) {
            if (onItemClick != null) {
                for (view in views) {
                    view.setOnClickListener { v -> onItemClick?.onFooterClick(v) }
                }
            }
        }

        override fun onClick(v: android.view.View){
            onItemClick?.onClick(v, getAdapterPosition())
        }
    }

    interface OnItemClick {
        fun onClick(view: android.view.View, position: Int)
        fun onFooterClick(view: android.view.View)
    }
}