package com.example.chenming20171230.utils1;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;


/**
 * 作者：${九号} on 2017/10/20 09:26
 * 班级：Android1508A
 */

public class Myapp extends Application {

    public static Myapp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        mInstance = this;
    }

    public static Myapp getInstance(){
        return mInstance;
    }

}
