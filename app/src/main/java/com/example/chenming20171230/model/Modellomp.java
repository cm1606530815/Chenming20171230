package com.example.chenming20171230.model;

import com.example.chenming20171230.bean.MyBean;
import com.example.chenming20171230.utils1.GsonObjectCallback;
import com.example.chenming20171230.utils1.OkHttp3Utils;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by 九号 on 2017/12/30.
 */

public class Modellomp {
    private ModelCallBack callBack;
    public void setCallBack(ModelCallBack callBack){
        this.callBack = callBack;
    }
    private String url = "http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage";
    public void getData(){
        OkHttp3Utils.getInstance().doGet(url, new GsonObjectCallback<MyBean>() {
            @Override
            public void onUi(MyBean myBean) {
                callBack.onSuccess(myBean);
            }

            @Override
            public void onFailed(Call call, IOException e) {
                callBack.onFailure(e);
            }
        });
    }


}
