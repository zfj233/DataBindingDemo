package com.zfj.android.databindingbasedemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.zfj.android.databindingbasedemo.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfj_ on 2017/6/20.
 */

public class ListActivity extends AppCompatActivity {
    ActivityListBinding mBinding;
    EmployeeAdapter mEmployeeAdapter ;
    public class Presenter{
        public void onItemAdd(View view){
            mEmployeeAdapter.add(new Employee("gaga","haha",false));
        }
        public void onItemRemove(View view){
            mEmployeeAdapter.remove();
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        mBinding.setPresenter(new Presenter());
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mEmployeeAdapter = new EmployeeAdapter(this);
        List<Employee> demoList = new ArrayList<>();
        demoList.add(new Employee("zfj","ddd",false));
        demoList.add(new Employee("zfj","zzz",false));
        demoList.add(new Employee("zfj","sss",true));
        demoList.add(new Employee("zfj","aaa",false));
        mEmployeeAdapter.addAll(demoList);
        mBinding.recyclerView.setAdapter(mEmployeeAdapter);
        mEmployeeAdapter.setListener(new EmployeeAdapter.OnItemClickListener() {
            @Override
            public void onEmployeeClick(Employee employee) {
                Toast.makeText(ListActivity.this,
                        employee.getFirstName(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}
