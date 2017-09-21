package com.huiben.app.floatmenudemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.huiben.app.floatmenudemo.R;
import com.huiben.app.floatmenudemo.activity.HomeActivity;
import com.huiben.app.floatmenudemo.fragment.HomeBottomFragment;
import com.huiben.app.floatmenudemo.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liuran on 2017/9/15.
 * 主页用recyclerview的方式可能会有问题
 * 1. View + 2.ViewPager
 * 2. 这里的bug是ViewPager在Recyclerview中的高度需要重新计算 计算策略用的是最大值
 * 3. 每次viewpager滑动到新的一页 高度会重新测量 导致viewpager会滚动到最顶部
 * 4. 用viewpager作为内容展示 下拉加载还是个问题 到时候测量岂不是更复杂？待改进
 * 5. 推翻 更美的根本不是可滚动 所以不是viewpager 这里可能就是错误的方向
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> bannerItems;
    private List<String> mainItems;
    private Context context;
    private FragmentManager fm;
    private SlidingTabLayout slidingTabLayout;
    private HomeFragment fragment;

    public HomeAdapter(HomeFragment fragment) {
        this.fragment=fragment;
        this.context = fragment.getContext();
        fm=fragment.getFragmentManager();
        slidingTabLayout=fragment.homeFloatSlide;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {
            View headView = View.inflate(context, R.layout.view_home_recycler_head, null);
            return new HeadHolder(headView);
        } else {
            View mainView = View.inflate(context, R.layout.view_home_recycler_main, null);
            return new MainHolder(mainView);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeadHolder) {


        } else if (holder instanceof MainHolder) {
            String[] arr = context.getResources().getStringArray(R.array.home_menu);
            List<Fragment> list = new ArrayList<>();
            for(String item:arr){
                list.add(HomeBottomFragment.newInstance(item));
            }
            HomePagerAdapter adapter=new HomePagerAdapter(fm,list,arr);
            ((MainHolder) holder).homeRecyclerMainVp.setAdapter(adapter);
            ((MainHolder) holder).homeRecyclerMainSliding.setViewPager(((MainHolder) holder).homeRecyclerMainVp);
            this.slidingTabLayout.setViewPager(((MainHolder) holder).homeRecyclerMainVp);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class HeadHolder extends RecyclerView.ViewHolder {


        public HeadHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


    public class MainHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_recycler_main_sliding)
        SlidingTabLayout homeRecyclerMainSliding;
        @BindView(R.id.home_recycler_main_vp)
        ViewPager homeRecyclerMainVp;
        public MainHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            homeRecyclerMainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                    fragment.updateFloat(0);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        }
    }
}
