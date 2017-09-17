package com.huiben.app.floatmenudemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huiben.app.floatmenudemo.R;
import com.huiben.app.floatmenudemo.ViewFinish;
import com.huiben.app.floatmenudemo.adapter.HomeBottomAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liuran on 2017/9/16.
 */

public class HomeBottomFragment extends Fragment {
    @BindView(R.id.home_bottom_recycler)
    RecyclerView homeBottomRecycler;
    Unbinder unbinder;

    private String item;
    private List<String>list;
    private String TAG="HomeBottomFragment";
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_bottom, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getParentFragment() instanceof  TestHomeFragment){
            ViewFinish inter= (ViewFinish) getParentFragment();
            inter.viewCreate(view);
        }
    }

    private void initData() {
        Bundle bundle=getArguments();
        item=bundle.getString("item");
        list=new ArrayList<>();
        for(int i=0;i<40;i++){
            list.add(item+i);
        }
        homeBottomRecycler.setAdapter(new HomeBottomAdapter(list));

    }

    private void initView() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        homeBottomRecycler.setLayoutManager(manager);
        homeBottomRecycler.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public static HomeBottomFragment newInstance(String item){
        Bundle bundle=new Bundle();
        bundle.putString("item",item);
        HomeBottomFragment fragment=new HomeBottomFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


}
