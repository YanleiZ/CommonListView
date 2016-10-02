package com.yanlei_baseadapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;

import com.yanlei_baseadapter.bean.Bean;
import com.yanlei_baseadapter.utils.CommonAdapter;
import com.yanlei_baseadapter.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yanlei on 2016/10/1.
 */

public class MyAdapter extends CommonAdapter<Bean> {
    private List<Integer> mPos = new ArrayList<Integer>();

    public MyAdapter(Context context, List<Bean> datas) {
        super(context, datas,R.layout.item_listview);
    }

    @Override
    public void convert(final ViewHolder hoder, final Bean bean) {
        hoder.setText(R.id.id_title, bean.getTitle())
                .setText(R.id.id_desc, bean.getDesc())
                .setText(R.id.id_time, bean.getTime())
                .setText(R.id.id_phone, bean.getPhone());
        final CheckBox cb = hoder.getView(R.id.id_cb);
        //cb.setChecked(bean.isChecked());
        cb.setChecked(false);
        if (mPos.contains(hoder.getPosition())){
            cb.setChecked(true);
        }
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bean.setChecked(cb.isChecked());
                if (cb.isChecked()) {
                    mPos.add(hoder.getPosition());
                } else {
                    //这里要注意remove的是对象而不是位置（index），所以强转为Integer类型
                    mPos.remove((Integer) hoder.getPosition());
                }
            }
        });
//        ((TextView) hoder.getView(R.id.id_title)).setText(bean.getTitle());
//        ((TextView) hoder.getView(R.id.id_desc)).setText(bean.getDesc());
//        ((TextView) hoder.getView(R.id.id_time)).setText(bean.getTime());
//        ((TextView) hoder.getView(R.id.id_phone)).setText(bean.getPhone());
        //如果bean里面有int类型的数据，要转为String类型，以免当做资源的id从而引发错误
    }


}

