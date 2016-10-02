package com.yanlei_baseadapter.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yanlei_baseadapter.R;
import com.yanlei_baseadapter.bean.Bean;

import java.util.List;

/**
 * Created by Yanlei on 2016/10/2.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mDatas = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder hoder = ViewHolder.get(mContext, convertView, parent, R.layout.item_listview, position);
        convert(hoder, getItem(position));
        return hoder.getConvertView();
    }

    public abstract void convert(ViewHolder hoder, T t);
}
