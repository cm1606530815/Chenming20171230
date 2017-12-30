package com.example.chenming20171230.view;

import com.example.chenming20171230.bean.MyBean;

/**
 * Created by 九号 on 2017/12/30.
 */

public interface MainView {
    void onSuccess(MyBean myBean);
    void onFailure(Exception e);
}
