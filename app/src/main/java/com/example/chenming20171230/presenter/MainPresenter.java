package com.example.chenming20171230.presenter;

import com.example.chenming20171230.bean.MyBean;
import com.example.chenming20171230.model.ModelCallBack;
import com.example.chenming20171230.model.Modellomp;
import com.example.chenming20171230.view.MainView;

import java.lang.ref.WeakReference;

/**
 * Created by 九号 on 2017/12/30.
 */

public class MainPresenter implements ModelCallBack{
    private Modellomp modellomp;
    WeakReference<MainView> weakReference ;
    public MainPresenter(MainView mainView){
        this.Attach(mainView);
        modellomp = new Modellomp();
        modellomp.setCallBack(this);
    }
    @Override
    public void onSuccess(MyBean myBean) {
        weakReference.get().onSuccess(myBean);
    }

    @Override
    public void onFailure(Exception e) {
        weakReference.get().onFailure(e);
    }
    public  void get(){
        modellomp.getData();
    }
    public void Attach(MainView mainView){
        weakReference = new WeakReference<MainView>(mainView);
    }
    public void Detach(){
        weakReference.clear();
    }
}
