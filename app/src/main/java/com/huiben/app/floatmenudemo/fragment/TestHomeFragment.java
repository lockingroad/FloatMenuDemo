package com.huiben.app.floatmenudemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.huiben.app.floatmenudemo.R;
import com.huiben.app.floatmenudemo.adapter.HomeAdapter;
import com.huiben.app.floatmenudemo.adapter.HomePagerAdapter;
import com.huiben.app.floatmenudemo.view.WrapContentHeightViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liuran on 2017/9/16.
 * （用scrollview 嵌套）
 * 未使用
 *
 */

public class TestHomeFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.home_recycler_main_sliding)
    SlidingTabLayout homeRecyclerMainSliding;
    @BindView(R.id.home_recycler_main_vp)
    WrapContentHeightViewPager homeRecyclerMainVp;
    @BindView(R.id.test_scroll)
    NestedScrollView testScroll;
    @BindView(R.id.home_recycler_main_float_sliding)
    SlidingTabLayout homeRecyclerMainFloatSliding;


    private HomeAdapter homeAdapter;
    private LinearLayoutManager manager;
    private String TAG = "TestHomeFragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        String[] arr = getContext().getResources().getStringArray(R.array.home_menu);
        List<Fragment> list = new ArrayList<>();
        for (String item : arr) {
            list.add(HomeBottomFragment.newInstance(item));
        }
        HomePagerAdapter adapter = new HomePagerAdapter(getFragmentManager(), list, arr);
        homeRecyclerMainVp.setAdapter(adapter);
        homeRecyclerMainSliding.setViewPager(homeRecyclerMainVp);
        homeRecyclerMainFloatSliding.setViewPager(homeRecyclerMainVp);

        testScroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if(oldScrollY>600){
                    homeRecyclerMainFloatSliding.setVisibility(View.VISIBLE);
                }else{
                    homeRecyclerMainFloatSliding.setVisibility(View.GONE);
                }
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
