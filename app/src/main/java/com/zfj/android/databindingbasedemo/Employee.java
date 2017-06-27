package com.zfj.android.databindingbasedemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

import com.android.databinding.library.baseAdapters.*;


/**
 * Created by zfj_ on 2017/6/13.
 */

public class Employee extends BaseObservable {
    private String mFirstName;
    private String mLastName;



    private String mAvatar;

    private ObservableBoolean mIsFired;

    public Employee(String firstName, String lastName) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
        mIsFired = new ObservableBoolean();
        mIsFired.set(false);
    }
    public Employee(String firstName, String lastName, boolean isFired) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
        mIsFired = new ObservableBoolean();
        mIsFired.set(isFired);
    }
    public ObservableBoolean isFired() {
        return mIsFired;
    }

    public void setIsFired(boolean isFired) {
        mIsFired.set(isFired);
        //notifyChange();
    }

    @Bindable
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
        notifyPropertyChanged(com.zfj.android.databindingbasedemo.BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
        notifyPropertyChanged(com.zfj.android.databindingbasedemo.BR.lastName);
    }
    @Bindable
    public String getAvatar() {
        return mAvatar;
    }
    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

}
