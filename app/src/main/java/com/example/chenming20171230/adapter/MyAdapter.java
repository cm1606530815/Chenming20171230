package com.example.chenming20171230.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenming20171230.R;
import com.example.chenming20171230.bean.MyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 九号 on 2017/12/30.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<MyBean.DataBean.DefaultGoodsListBean> goodsListBeans = new ArrayList<>();

    public MyAdapter(Context context, List<MyBean.DataBean.DefaultGoodsListBean> goodsListBeans) {
        this.context = context;
        this.goodsListBeans = goodsListBeans;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.simple.setImageURI(goodsListBeans.get(position).getGoods_img());
        holder.title.setText(goodsListBeans.get(position).getGoods_name());
        holder.des.setText(goodsListBeans.get(position).getEfficacy());
    }

    @Override
    public int getItemCount() {
        return goodsListBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.des)
        TextView des;
        @BindView(R.id.simple)
        SimpleDraweeView simple;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
