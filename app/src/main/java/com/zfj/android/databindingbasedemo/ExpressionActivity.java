package com.zfj.android.databindingbasedemo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zfj.android.databindingbasedemo.databinding.ActivityExpressionBinding;

import java.util.Random;

/**
 * Created by zfj_ on 2017/6/22.
 */

public class ExpressionActivity extends AppCompatActivity {
    ActivityExpressionBinding mBinding;
    private Random mRandom = new Random(System.currentTimeMillis());
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isFired = mRandom.nextBoolean();
        Employee employee = new Employee("mark","zhai");
        employee.setIsFired(isFired);
        employee.setAvatar("http://dynamic-image.yesky.com/600x-/uploadImages/upload/20141120/g41axeshctbjpg.jpg");
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_expression);
        mBinding.setEmployee(employee);
    }
}
