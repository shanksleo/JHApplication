package tk.jinhao.jhapplication.config;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.orhanobut.logger.Logger;

import tk.jinhao.volleyutils.util.VolleyUtil;

/**
 * Created by shanks on 15/5/21.
 */
public class JHApplication extends Application {

    private static Context mContext;
    public static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Logger.init("JH");
//        CrashHandler.getInstance().init(this);
        requestQueue = VolleyUtil.getVolleyRequestQueueInstance(getApplicationContext());
    }

    public static Context getContext() {
        return mContext;

    }





}
