package com.trojx.mytouchgallery;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**Simple TouchGallery demo based on ViewPager and Photoview.
 * Created by lax on 2021/1/3.
 */
public class PicViewerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView tv_indicator;
    private ArrayList<String> urlList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_viewer);

        String [] urls={"https://img1.baidu.com/it/u=11123195,2687773733&fm=26&fmt=auto",
                "https://img0.baidu.com/it/u=1377351719,1863175279&fm=26&fmt=auto",
                "https://img1.baidu.com/it/u=1816550749,1823509751&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=949",
                "https://img2.baidu.com/it/u=563902411,394967528&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=1082"

        };

        urlList = new ArrayList<>();
        Collections.addAll(urlList, urls);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tv_indicator = (TextView) findViewById(R.id.tv_indicator);

        viewPager.setAdapter(new PictureSlidePagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tv_indicator.setText(String.valueOf(position+1)+"/"+urlList.size());
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private  class PictureSlidePagerAdapter extends FragmentStatePagerAdapter {

        public PictureSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PictureSlideFragment.newInstance(urlList.get(position));
        }

        @Override
        public int getCount() {
            return urlList.size();
        }
    }
}
