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
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.huiben.app.floatmenudemo.R;
import com.huiben.app.floatmenudemo.activity.HomeActivity;
import com.huiben.app.floatmenudemo.adapter.HomeAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liuran on 2017/9/16.
 */

public class HomeFragment extends Fragment {
    @BindView(R.id.home_recycler)
    RecyclerView homeRecycler;
    Unbinder unbinder;
    @BindView(R.id.home_float_slide)
    public SlidingTabLayout homeFloatSlide;


    private HomeAdapter homeAdapter;
    private LinearLayoutManager manager;
    private String TAG = "HomeFragment";
    private View mainView;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        homeRecycler.setLayoutManager(manager);
        homeRecycler.setItemAnimator(new DefaultItemAnimator());

        homeAdapter = new HomeAdapter(HomeFragment.this);
        homeRecycler.setAdapter(homeAdapter);


        homeRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                updateFloat(dy);
            }
        });
    }

    public void updateFloat(int dy) {
        mainView = manager.findViewByPosition(1);
        if(mainView.getTop()>0){
            homeFloatSlide.setVisibility(View.GONE);
        }else{
            homeFloatSlide.setVisibility(View.VISIBLE);
        }


        SlidingTabLayout actTabLayout=((HomeActivity)getActivity()).homeSliding;

        int hei=actTabLayout.getHeight();

        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) actTabLayout.getLayoutParams();
        if(mainView.getTop()<0&&mainView.getTop()>-hei){
            params.topMargin=mainView.getTop();
        }else if(mainView.getTop()<-hei){
            params.topMargin=-hei;
        }else{
            params.topMargin=0;
        }

        actTabLayout.setLayoutParams(params);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
