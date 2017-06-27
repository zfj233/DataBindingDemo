package com.zfj.android.databindingbasedemo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zfj.android.databindingbasedemo.databinding.ActivityTwoWayBinding;

/**
 * Created by zfj_ on 2017/6/22.
 */

public class TwoWayActivity extends AppCompatActivity {
    ActivityTwoWayBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_two_way);
        FormModel model = new FormModel("dad", "123");
        model.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Toast.makeText(TwoWayActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
            }
        });
        mBinding.setModel(model);

    }
}
