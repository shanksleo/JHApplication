package tk.jinhao.jhapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import tk.jinhao.jhapplication.utils.DB.SharedPreferencesUtils;

/**
 * Created by shanks on 15/5/25.
 */
public class SplashActivity extends Activity {
    public static final String FIRST_ENTRY = "first_entry";
    public static  boolean B_INIT_NETWORK_OK = false;
    public static  boolean B_INIT_DATA_OK = false;
    public static final int SWITH_TO_GUIDE_ACTIVITY = 0X01;
    public static final int SWITH_TO_MAIN_ACTIVITY = 0X02;
    public static final int INIT_NETWORK_OK = 0X03;
    public static final int INIT_DATA_OK = 0X04;

    boolean firstEntry = false;
    @InjectView(R.id.ivi_splash)
    ImageView mIviSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //定义全屏参数
//        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
//        Window window=SplashActivity.this.getWindow();
        //设置当前窗体为全屏显示
//        window.setFlags(flag, flag);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);
        setAnimation();
        firstEntry = (boolean) SharedPreferencesUtils.get(this,FIRST_ENTRY,false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_splash);

//
//
//        firstEntry = (boolean) SharedPreferencesUtils.get(this, FIRST_ENTRY, false);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        if (firstEntry) {
//            Message message = mHandler.obtainMessage();
//            message.what = SWITH_TO_GUIDE_ACTIVITY;
////            message.sendToTarget();
//        } else {
//            SharedPreferencesUtils.put(this, FIRST_ENTRY, true);
//            Logger.d("" + (boolean) SharedPreferencesUtils.get(this, FIRST_ENTRY, false));
//            Message message = mHandler.obtainMessage();
//            message.what = SWITH_TO_MAIN_ACTIVITY;
////            message.sendToTarget();
//        }

    }

    private void setAnimation() {
//        渐变动画
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);//透明度渐变动画
        animation.setDuration(2000);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Message message = mHandler.obtainMessage();
                message.what = SWITH_TO_MAIN_ACTIVITY;
                message.sendToTarget();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mIviSplash.setAnimation(animation);
    }

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {


                case SWITH_TO_GUIDE_ACTIVITY:
                    Intent mGuideIntent = new Intent(SplashActivity.this, GuideActivity.class);
                    startActivity(mGuideIntent);
                    break;
                case SWITH_TO_MAIN_ACTIVITY:
                    Intent mMainIntent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(mMainIntent);
                    break;
                default:
                    break;
            }


            return false;
        }
    });

    private boolean getNetworkStatus(){
        B_INIT_NETWORK_OK = true;
        return true;
    }

    private boolean getDataStatus(){
        B_INIT_DATA_OK = true;
        return true;
    }

}
