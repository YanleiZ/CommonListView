package com.yanlei_baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yanlei_baseadapter.bean.Bean;
import com.yanlei_baseadapter.utils.CommonAdapter;
import com.yanlei_baseadapter.utils.ViewHolder;

import java.util.List;

/**
 * Created by Yanlei on 2016/10/1.
 */

public class MyAdapter extends CommonAdapter<Bean> {

    public MyAdapter(Context context, List<Bean> datas) {
        super(context, datas);
    }

    @Override
    public void convert(ViewHolder hoder, Bean bean) {
        hoder.setText(R.id.id_title, bean.getTitle())
                .setText(R.id.id_desc, bean.getDesc())
                .setText(R.id.id_time, bean.getTime())
                .setText(R.id.id_phone, bean.getPhone());
//        ((TextView) hoder.getView(R.id.id_title)).setText(bean.getTitle());
//        ((TextView) hoder.getView(R.id.id_desc)).setText(bean.getDesc());
//        ((TextView) hoder.getView(R.id.id_time)).setText(bean.getTime());
//        ((TextView) hoder.getView(R.id.id_phone)).setText(bean.getPhone());
        //如果bean里面有int类型的数据，要转为String类型，以免当做资源的id从而引发错误
    }


}

