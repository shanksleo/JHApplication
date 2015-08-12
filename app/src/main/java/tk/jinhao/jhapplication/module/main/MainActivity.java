package tk.jinhao.jhapplication.module.main;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import tk.jinhao.jhapplication.R;
import tk.jinhao.jhapplication.base.IEventHandler;
import tk.jinhao.jhapplication.base.JHActivity;
import tk.jinhao.jhapplication.config.JHApplication;
import tk.jinhao.jhapplication.fragment.Afragment;
import tk.jinhao.jhapplication.utils.click.ClickCommonTool;
import tk.jinhao.jhapplication.utils.click.ExitEvevtDispatch;


public class MainActivity extends JHActivity {
    @InjectView(R.id.tl_custom)
    Toolbar mTlCustom;
    @InjectView(R.id.frame_main)
    FrameLayout mFrameMain;
    @InjectView(R.id.lv_left_menu)
    ListView mLvLeftMenu;
    @InjectView(R.id.dl_left)
    DrawerLayout mDlLeft;

//
//    @InjectView(R.id.ivi_avatar)
//    SimpleDraweeView mIviAvatar;

    //声明相关变量
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView lvLeftMenu;
    private String[] lvs = {"List Item 01", "List Item 02", "List Item 03", "List Item 04"};
    private ArrayAdapter arrayAdapter;
    private ImageView ivRunningMan;
    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initToolBar();
        initDrawerLayout();
        Afragment afragment = new Afragment();
        getFragmentManager().beginTransaction().add(R.id.frame_main,afragment,"ab").commitAllowingStateLoss();
    }




    @Override
    public IEventHandler getInstace() {
        return new MainActivityHandler();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initToolBar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.tl_custom);
        // App Logo
        // toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        toolbar.setTitle(getResources().getStringArray(R.array.array_left_menu)[0]);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        // Sub Title
        // toolbar.setSubtitle("Sub title");

//        toolbar.setTitleTextAppearance();


        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Navigation Icon
//        toolbar.setNavigationIcon(R.drawable.ic_toc_white_24dp);
        /*
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });*/

    }

    private void initDrawerLayout() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        lvLeftMenu = (ListView) findViewById(R.id.lv_left_menu);

        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                mAnimationDrawable.stop();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                mAnimationDrawable.start();
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        lvLeftMenu.setAdapter(arrayAdapter);
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (ClickCommonTool.isFastDoubleClick()) {
            return true;
        }
        if (KeyEvent.KEYCODE_BACK == event.getKeyCode()) {
            ClickCommonTool.doubleClickExit(new ExitEvevtDispatch() {
                @Override
                public void exitApplication() {

                    Toast.makeText(JHApplication.getContext(), "退出", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
            return true;
        }

        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
