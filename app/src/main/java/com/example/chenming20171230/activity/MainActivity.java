package com.example.chenming20171230.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chenming20171230.R;
import com.example.chenming20171230.adapter.MyAdapter;
import com.example.chenming20171230.bean.MyBean;
import com.example.chenming20171230.presenter.MainPresenter;
import com.example.chenming20171230.view.MainView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private String[] banner = new String[4];
    @BindView(R.id.myBanner)
    Banner myBanner;
    MainPresenter presenter;
    private MyAdapter adapter;
    private List<MyBean.DataBean.Ad1Bean> ad1Beans = new ArrayList<>();
    private List<MyBean.DataBean.DefaultGoodsListBean> defaultGoodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.get();

    }

    @Override
    public void onSuccess(MyBean myBean) {
        ad1Beans = myBean.getData().getAd1();
        for (int i = 0; i < ad1Beans.size(); i++) {
            String str = ad1Beans.get(i).getImage();
            banner[i] = str;
        }
        myBanner.setImages(banner);
        myBanner.setBannerStyle(Banner.CIRCLE_INDICATOR);
        myBanner.setDelayTime(3000);
        defaultGoodsList = myBean.getData().getDefaultGoodsList();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new MyAdapter(this,defaultGoodsList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.Detach();
    }
}
