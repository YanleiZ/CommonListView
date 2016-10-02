package com.yanlei_baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yanlei_baseadapter.bean.Bean;
import com.yanlei_baseadapter.utils.CommonAdapter;
import com.yanlei_baseadapter.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private List<Bean> mDatas;
    //private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initView();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("====", parent.toString() + " " + position + " " + id);
            }
        });
    }

    private void initDatas() {
        mDatas = new ArrayList<Bean>();
        Bean bean = new Bean("zyl", "张延磊张延磊张延磊张延磊张延磊", "2016-10-01", "15820097006");
        mDatas.add(bean);
        bean = new Bean("zyl1", "张延磊张延磊张延磊张延磊张延磊", "2016-10-01", "15820097006");
        mDatas.add(bean);
        bean = new Bean("zyl2", "张延磊张延磊张延磊张延磊张延磊", "2016-10-01", "15820097006");
        mDatas.add(bean);
        bean = new Bean("zyl3", "张延磊张延磊张延磊张延磊张延磊", "2016-10-01", "15820097006");
        mDatas.add(bean);
        bean = new Bean("zyl4", "张延磊张延磊张延磊张延磊张延磊", "2016-10-01", "15820097006");
        mDatas.add(bean);
        bean = new Bean("zyl5", "张延磊张延磊张延磊张延磊张延磊", "2016-10-01", "15820097006");
        mDatas.add(bean);
        bean = new Bean("zyl6", "张延磊张延磊张延磊张延磊张延磊", "2016-10-01", "15820097006");
        mDatas.add(bean);
        //mAdapter = new MyAdapter(this, mDatas);

    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.id_listview);
        // mListView.setAdapter(mAdapter);
        mListView.setAdapter(new CommonAdapter<Bean>(MainActivity.this, mDatas) {
            @Override
            public void convert(ViewHolder hoder, Bean bean) {
                hoder.setText(R.id.id_title, bean.getTitle())
                        .setText(R.id.id_desc, bean.getDesc())
                        .setText(R.id.id_time, bean.getTime())
                        .setText(R.id.id_phone, bean.getPhone());
            }
        });
    }

}
