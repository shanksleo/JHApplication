package tk.jinhao.jhapplication;

import android.app.Application;

import com.orhanobut.logger.Logger;

import tk.jinhao.jhapplication.utils.CrashHandler;

/**
 * Created by shanks on 15/5/21.
 */
public class JHApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("JH");
        CrashHandler.getInstance().init(this);
    }
}
