package com.zfj.android.databindingbasedemo;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by zfj_ on 2017/6/22.
 */

public class DemoBindingAdapter {
    @BindingAdapter({"app:imageUrl","app:placeholder"})
    public static void loadPathFromUrl(ImageView view,
                                       String url,
                                       Drawable drawable){
        Glide.with(view.getContext()).load(url).placeholder(drawable).into(view);
    }
}
