package com.huiben.app.floatmenudemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huiben.app.floatmenudemo.R;

import java.util.List;

/**
 * Created by liuran on 2017/9/15.
 */

public class HomeMenuAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public HomeMenuAdapter(@Nullable List<String> data) {
        super(R.layout.item_home_menu,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.item_home_menu_tv,item);
    }
}
