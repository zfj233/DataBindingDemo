package com.zfj.android.databindingbasedemo;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zfj_ on 2017/6/21.
 */
public class BindingViewHolder <T extends ViewDataBinding> extends
        RecyclerView.ViewHolder{
    private T mBinding;
    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public T getBinding() {
        return mBinding;
    }
}
