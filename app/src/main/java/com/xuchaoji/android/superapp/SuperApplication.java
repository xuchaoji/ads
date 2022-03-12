package com.xuchaoji.android.superapp;

import android.app.Application;

import com.huawei.hms.ads.HwAds;

public class SuperApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HwAds.init(this);
    }
}
