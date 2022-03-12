package com.xuchaoji.android.superppsphone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.huawei.openalliance.ad.constant.DeviceType;
import com.huawei.openalliance.ad.inter.RewardAdLoader;
import com.huawei.openalliance.ad.inter.data.IRewardAd;
import com.huawei.openalliance.ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.ad.inter.listeners.RewardAdListener;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    public static final String ADID = "testx9dtjwj8hp";

    private Button reqReward;

    IRewardAd rewardAd;

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
            loadAd();
        }
    }

    private void showAd(IRewardAd rewardAd) {
        rewardAd.show(this, new IRewardAdStatusListener() {
            @Override
            public void onAdShown() {

            }

            @Override
            public void onAdClicked() {

            }

            @Override
            public void onAdCompleted() {

            }

            @Override
            public void onAdClosed() {

            }

            @Override
            public void onRewarded() {

            }

            @Override
            public void onAdError(int i, int i1) {

            }
        });
    }

    private void loadAd() {
        RewardAdLoader rewardAdLoader = new RewardAdLoader(this, new String[]{ADID});
        rewardAdLoader.setListener(new RewardAdListener() {
            @Override
            public void onAdsLoaded(Map<String, List<IRewardAd>> map) {
                if (map != null && map.size() > 0) {
                    try {
                        rewardAd = map.get(ADID).get(0);
                        showAd(rewardAd);
                    } catch (Throwable throwable) {

                    }


                }
            }

            @Override
            public void onAdFailed(int i) {

            }
        });
        rewardAdLoader.loadAds(DeviceType.PHONE, false);

    }
}