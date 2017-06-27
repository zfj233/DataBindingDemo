package com.zfj.android.databindingbasedemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zfj.android.databindingbasedemo.databinding.ActivityBaseBinding;


public class BaseSampleActivity extends AppCompatActivity {
    Employee employee = new Employee("zheng", "hhh");
    ActivityBaseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_base);
        binding.setEmployee(employee);
        binding.setPresenter(new Presenter());
       // binding.viewstub.getViewStub().inflate();
    }

    public class Presenter {
        public void onTextChanged(CharSequence s,int start,int before ,int count) {
            employee.setFirstName(s.toString());
            //binding.setEmployee(employee);
            employee.setIsFired(!employee.isFired().get());
        }
        public void onClick(View view){
            Toast.makeText(BaseSampleActivity.this,"点到了！",Toast.LENGTH_SHORT).show();
        }
        public void onClickListenerBinding(Employee employee){
            Toast.makeText(BaseSampleActivity.this,employee.getLastName(),Toast.LENGTH_SHORT).show();
        }
    }
}
