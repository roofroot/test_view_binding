package com.dsf.vms

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dsf.dsfwarehouse.base.BaseHaveFooterAdapter
import com.dsf.vms.databinding.AdapterFootTestBinding
import com.dsf.vms.databinding.AdapterItemTestBinding

class  TestAdapter(context: Context, mDatas: List<String>?) :
    BaseHaveFooterAdapter<String, AdapterItemTestBinding, AdapterFootTestBinding>(context, mDatas) {
    override fun onBindHolder(holder: ViewHolder<AdapterFootTestBinding>, position: Int) {
        val binding=holder.binding as AdapterItemTestBinding;
        binding.tv.setText(mDatas?.get(position))
        holder.setClick(binding.root)

    }

    override fun onBindFooterHolder(holder: ViewHolder<AdapterItemTestBinding>, position: Int) {
        val binding=holder.binding as AdapterFootTestBinding
        holder.setOnFooterClick(binding.foot)
    }

    override fun setBinding(inflater: LayoutInflater?, parent: ViewGroup?): AdapterItemTestBinding {
        return AdapterItemTestBinding.inflate(inflater!!,parent,false);
    }

    override fun setFootBinding(
        inflater: LayoutInflater?,
        parent: ViewGroup?
    ): AdapterFootTestBinding {
        return AdapterFootTestBinding.inflate(inflater!!,parent,false);
    }

}