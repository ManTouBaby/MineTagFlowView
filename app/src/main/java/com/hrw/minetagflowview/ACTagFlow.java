package com.hrw.minetagflowview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hrw.tagflowlibrary.OnTagMultipleSelectListener;
import com.hrw.tagflowlibrary.TagFlowView;
import com.hrw.tagflowlibrary.TagMultipleSelectAdapter;

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
        List<Book> strings = new ArrayList<>();
        strings.add(new Book("物理"));
        strings.add(new Book("英语"));
        strings.add(new Book("动物世界"));
        strings.add(new Book("生物与科学"));
        strings.add(new Book("Android开发之深入浅出"));
        strings.add(new Book("Android英雄传"));
        strings.add(new Book("Android开发艺术"));
        strings.add(new Book("物理---"));
        strings.add(new Book("英语---"));
        strings.add(new Book("动物世界---"));
        strings.add(new Book("生物与科学---"));
        strings.add(new Book("Android开发之深入浅出---"));
        strings.add(new Book("Android英雄传---"));
        strings.add(new Book("Android开发艺术---"));
        strings.add(new Book("物理+++"));
        strings.add(new Book("英语+++"));
        strings.add(new Book("动物世界+++"));
        strings.add(new Book("生物与科学+++"));
        strings.add(new Book("Android开发之深入浅出+++"));
        strings.add(new Book("Android英雄传+++"));
        strings.add(new Book("Android开发艺术+++"));
        strings.add(new Book("物理+++"));
        strings.add(new Book("英语+++"));
        strings.add(new Book("动物世界+++"));
        strings.add(new Book("生物与科学+++"));
        strings.add(new Book("Android开发之深入浅出+++"));
        strings.add(new Book("Android英雄传+++"));
        strings.add(new Book("Android开发艺术+++"));


        tagFlowView.setAdapter(new TagMultipleSelectAdapter<Book>(this, strings) {
            @Override
            protected String getTagValue(Book book) {
                return book.bookName;
            }

        }.setOnTagMultipleSelectListener(new OnTagMultipleSelectListener<Book>() {
            @Override
            public void tagSelectClick(List<Book> mData, Book book, int position) {
                StringBuffer stringBuffer = new StringBuffer();
                for (Book book1 : mData) {
                    stringBuffer.append(book1.bookName + "  ");
                }
                System.out.println("选中数据:" + stringBuffer.toString());
            }
        })).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("单击TagFlowView");
            }
        });

    }
}
