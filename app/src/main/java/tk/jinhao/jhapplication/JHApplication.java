package tk.jinhao.jhapplication;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;

/**
 * Created by shanks on 15/5/21.
 */
public class JHApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Logger.init("JH");
//        CrashHandler.getInstance().init(this);
    }

    public static Context getContext() {
        return mContext;

    }


}
