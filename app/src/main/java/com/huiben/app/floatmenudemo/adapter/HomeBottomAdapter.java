package com.huiben.app.floatmenudemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huiben.app.floatmenudemo.R;

import java.util.List;

/**
 * Created by liuran on 2017/9/15.
 * 主页最下面的列表条目内容
 */

public class HomeBottomAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public HomeBottomAdapter(@Nullable List<String> data) {
        super(R.layout.item_home_main,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_home_main_tv,item);
    }
}
