package redix.booxtown.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import redix.booxtown.R;
import redix.booxtown.autoviewpager.AutoScrollViewPager;

public class WelcomeActivity extends AppCompatActivity {

    private AutoScrollViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnsigup, btnsignin;
//    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()
//        prefManager = new PrefManager(this);
//        if (!prefManager.isFirstTimeLaunch()) {
//            launchHomeScreen();
//            finish();
//        }

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_welcome);

        //get image by picaso
        ImageView signin_fb = (ImageView)findViewById(R.id.signin_fb);
        Picasso.with(WelcomeActivity.this).load(R.mipmap.fb).into(signin_fb);
        ImageView signin_twitter = (ImageView)findViewById(R.id.signin_twitter);
        Picasso.with(WelcomeActivity.this).load(R.mipmap.twetter).into(signin_twitter);
        ImageView signin_google = (ImageView)findViewById(R.id.signin_google);
        Picasso.with(WelcomeActivity.this).load(R.mipmap.g).into(signin_google);

        //end

        viewPager = (AutoScrollViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnsigup = (Button) findViewById(R.id.btn_sigup_wellcome);
        btnsignin = (Button) findViewById(R.id.btn_sigin_wellcome);


        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.welcome_slide1,
                R.layout.welcome_slide2,
                R.layout.welcome_slide3,
                R.layout.welcome_slide4};
        // adding bottom dots

//        ImageView imageView1_icon_booxtown_intro = (ImageView)findViewById(R.id.imageView1_icon_booxtown_intro);
//        Picasso.with(getApplicationContext()).load(String.valueOf(getResources().getDrawable(R.drawable.icon_booxtown_intro))).into(imageView1_icon_booxtown_intro);
//

        addBottomDots(0);

        // making notification bar transparent
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter(layouts);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
//        viewPager.setInterval(2000);
//        viewPager.startAutoScroll();
        btnsigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itent = new Intent(WelcomeActivity.this,SigUp_Activity.class);
                startActivity(itent);

            }
        });

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itent = new Intent(WelcomeActivity.this,SignIn_Activity.class);
                startActivity(itent);
                
            }
        });

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor  = pref.edit();
        String session_id = pref.getString("session_id", null);
        if (session_id != null){
            Intent intent = new Intent(WelcomeActivity.this, MainAllActivity.class);
            startActivity(intent);
        }


    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    //	viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;
        int [] layouts1;
        public MyViewPagerAdapter(int [] layouts) {
            this.layouts1 = layouts;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts1[position], container, false);
            if(position == 0) {
                ImageView imageView1_icon_booxtown_intro = (ImageView) view.findViewById(R.id.imageView1_icon_booxtown_intro);
                Picasso.with(getApplicationContext()).load(R.drawable.icon_booxtown_intro).into(imageView1_icon_booxtown_intro);
            }else if(position == 1) {
                ImageView imageView2_icon_booxtown_intro = (ImageView) view.findViewById(R.id.imageView2_icon_booxtown_intro);
                Picasso.with(getApplicationContext()).load(R.drawable.icon_booxtown_intro).into(imageView2_icon_booxtown_intro);
            }else if(position ==2) {
                ImageView imageView3_icon_booxtown_intro = (ImageView) view.findViewById(R.id.imageView3_icon_booxtown_intro);
                Picasso.with(getApplicationContext()).load(R.drawable.icon_booxtown_intro).into(imageView3_icon_booxtown_intro);
            }else if(position == 3) {
                ImageView imageView4_icon_booxtown_intro = (ImageView) view.findViewById(R.id.imageView4_icon_booxtown_intro);
                Picasso.with(getApplicationContext()).load(R.drawable.icon_booxtown_intro).into(imageView4_icon_booxtown_intro);
            }
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
