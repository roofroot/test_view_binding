package com.my.test2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<T extends ViewBinding,M extends  BaseModel> extends Fragment {
    protected T binding;
    protected M model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        onPrepare();
        binding=getBinding(inflater,container,savedInstanceState);
        model=getModel();
        return binding.getRoot();
    }

    protected abstract void onPrepare();
    protected abstract T  getBinding(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState);
    protected abstract M getModel();
}
