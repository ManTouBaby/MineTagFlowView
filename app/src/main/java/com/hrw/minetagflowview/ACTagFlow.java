package com.hrw.minetagflowview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.hrw.tagflowlibrary.TagAdapter;
import com.hrw.tagflowlibrary.TagFlowView;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/12/10 10:20
 * @desc:
 */
public class ACTagFlow extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_tag_flow);
        TagFlowView tagFlowView = findViewById(R.id.tfv_show);
        List<String> strings = new ArrayList<>();
        strings.add("物理");
        strings.add("英语");
        strings.add("动物世界");
        strings.add("生物与科学");
        strings.add("Android开发之深入浅出");
        strings.add("Android英雄传");
        strings.add("Android开发艺术");
        strings.add("物理---");
        strings.add("英语---");
        strings.add("动物世界---");
        strings.add("生物与科学---");
        strings.add("Android开发之深入浅出---");
        strings.add("Android英雄传---");
        strings.add("Android开发艺术---");

        tagFlowView.setAdapter(new TagAdapter<String>(strings) {
            @Override
            protected View bindView(String s, int position) {
                TextView textView = (TextView) LayoutInflater.from(ACTagFlow.this).inflate(R.layout.item_tag_flow, null);
                textView.setText(s);
                return textView;
            }

        });
    }
}
