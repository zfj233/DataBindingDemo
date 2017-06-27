package com.zfj.android.databindingbasedemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by zfj_ on 2017/6/21.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    public static final int ITEM_VIEW_TYPE_ON = 1;
    public static final int ITEM_VIEW_TYPE_OFF = 2;
    private LayoutInflater mInflater;
    private OnItemClickListener mListener;
    private List<Employee> mEmployeeList;

    public interface OnItemClickListener {
        void onEmployeeClick(Employee employee);
    }

    public EmployeeAdapter(Context context) {
        super();
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mEmployeeList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        Employee employee = mEmployeeList.get(position);
        if (employee.isFired().get()) {
            return ITEM_VIEW_TYPE_OFF;
        } else {
            return ITEM_VIEW_TYPE_ON;
        }
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if (viewType == ITEM_VIEW_TYPE_ON) {
            binding = DataBindingUtil.inflate(mInflater,
                    R.layout.item_employee, parent, false);
        } else {
            binding = DataBindingUtil.inflate(mInflater,
                    R.layout.item_employee_off, parent, false);
        }
        return new BindingViewHolder(binding);
    }

    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }

    Random mRandom = new Random(System.currentTimeMillis());

    public void addAll(List<Employee> employees) {
        mEmployeeList.addAll(employees);
    }

    public void add(Employee employee) {
        int position = mRandom.nextInt(mEmployeeList.size());
        mEmployeeList.add(position, employee);
        notifyItemInserted(position);
    }

    public void remove() {
        if (mEmployeeList.size() == 0) {
            return;
        }
        int position = mRandom.nextInt(mEmployeeList.size());
        mEmployeeList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        final Employee employee = mEmployeeList.get(position);
        holder.getBinding().setVariable(com.zfj.android.databindingbasedemo.BR.item, employee);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onEmployeeClick(employee);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEmployeeList.size();
    }
}
