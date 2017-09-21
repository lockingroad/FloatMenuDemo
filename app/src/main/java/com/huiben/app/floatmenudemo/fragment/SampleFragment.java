package com.huiben.app.floatmenudemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huiben.app.floatmenudemo.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liuran on 2017/9/16.
 * 滑动的示例页
 */

public class SampleFragment extends Fragment {
    @BindView(R.id.sample_main_tv)
    TextView sampleMainTv;
    Unbinder unbinder;


    private String title;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        Bundle bundle=getArguments();
        title=bundle.getString("title");
        if(title!=null){
            sampleMainTv.setText(title);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    public static SampleFragment newInstance(String title){
        SampleFragment fragment=new SampleFragment();
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;


    }


}
