package com.my.test2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.my.test2.databinding.ItemTestBinding;

import java.util.List;

/**
 * @author : yx^_^
 * @e-mail : 565749553@qq.com
 * @date : 2020/3/24 14:38
 * @desc : better than before
 */
public class TestAdapter extends BaseAdapter<String,ItemTestBinding> {
    public TestAdapter(Context context, List <String>mDatas) {
        super(context, mDatas);
    }

    @Override
    protected void onBindHolder(ViewHolder<ItemTestBinding> holder, int position) {
            holder.getBinding().tx.setText(mDatas.get(position));
    }

    @Override
    protected ItemTestBinding setBinding(LayoutInflater inflater, ViewGroup parent) {
        return ItemTestBinding.inflate(inflater,parent,false);
    }
}
