package com.xuchaoji.android.superppsphone;

import android.app.Application;
import android.util.Log;

import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.IHiAd;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        IHiAd hiAd = HiAd.getInstance(this);
        hiAd.enableUserInfo(true);
        hiAd.initLog(true, Log.DEBUG);
        hiAd.initGrs("himovie", "CN");
    }
}
