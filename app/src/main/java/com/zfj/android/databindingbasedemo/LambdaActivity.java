package com.zfj.android.databindingbasedemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zfj.android.databindingbasedemo.databinding.ActivityLambdaBinding;

/**
 * Created by zfj_ on 2017/6/22.
 */

public class LambdaActivity extends AppCompatActivity {
    ActivityLambdaBinding mBinding;
    public class Presenter {
        public void onEmployeeClick(Employee employee) {
            Toast.makeText(LambdaActivity.this, "onEmployeeClick",
                    Toast.LENGTH_SHORT).show();
        }

        public void onEmployeeLongClick(Employee employee, Context context) {
            Toast.makeText(LambdaActivity.this, "onEmployeeLongClick",
                    Toast.LENGTH_SHORT).show();
        }

        public void onFocusChange(Employee employee) {
            Toast.makeText(LambdaActivity.this, "onFocusChanged",
                    Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lambda);
        mBinding.setEmployee(new Employee("daddy", "father"));
        mBinding.setPresenter(new Presenter());
    }
}