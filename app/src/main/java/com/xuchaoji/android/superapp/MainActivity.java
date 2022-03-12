package com.xuchaoji.android.superapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.reward.RewardAd;
import com.huawei.hms.ads.reward.RewardAdLoadListener;
import com.huawei.openalliance.ad.ppskit.beans.parameter.AdSlotParam;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private Button reqReward;

    RewardAd rewardAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reqReward = findViewById(R.id.req_reward);
        reqReward.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (R.id.req_reward == view.getId()) {
            loadReward();
        }
    }

    private void loadReward() {
        rewardAd = new RewardAd(this, "testx9dtjwj8hp");
        rewardAd.loadAd(new AdParam.Builder().build(), new MyRewardLoadListener());
    }

    private class MyRewardLoadListener extends RewardAdLoadListener {
        @Override
        public void onRewardAdFailedToLoad(int i) {

        }

        @Override
        public void onRewardedLoaded() {
            rewardAd.show(MainActivity.this);
        }
    }
}