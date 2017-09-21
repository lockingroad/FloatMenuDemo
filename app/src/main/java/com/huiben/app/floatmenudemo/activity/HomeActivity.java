package com.huiben.app.floatmenudemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.huiben.app.floatmenudemo.R;
import com.huiben.app.floatmenudemo.adapter.HomePagerAdapter;
import com.huiben.app.floatmenudemo.fragment.HomeFragment;
import com.huiben.app.floatmenudemo.fragment.SampleFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**start
 * 首页是viewpager的结构
 *
 */
public class HomeActivity extends AppCompatActivity {


    @BindView(R.id.home_sliding)
    public SlidingTabLayout homeSliding;
    @BindView(R.id.home_vp)
    ViewPager homeVp;
    private String TAG = "HomeActivity";

    private String[]titles;
    private List<Fragment>fragments;
    private HomePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titles=getResources().getStringArray(R.array.home_top_menu);
        fragments=new ArrayList<>();
        fragments.add(new HomeFragment());
        for(int i=1;i<titles.length;i++){
            fragments.add(SampleFragment.newInstance(titles[i]));
        }

        adapter=new HomePagerAdapter(getSupportFragmentManager(),fragments,titles);
        homeVp.setAdapter(adapter);
        homeSliding.setViewPager(homeVp);

        homeVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position!=0){
                    LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) homeSliding.getLayoutParams();
                    params.topMargin=0;
                    homeSliding.setLayoutParams(params);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
