package tk.jinhao.jhapplication.utils.click;

import android.os.SystemClock;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import tk.jinhao.jhapplication.JHApplication;

/**
 * Created by shanks on 15/6/26.
 */
public class ClickCommonTool {

    /*防止暴力点击
    *  true 属于暴力点击
    *  false 正常操作
    * */
    public static boolean isFastDoubleClick() {
        long currentTime = SystemClock.currentThreadTimeMillis();
        long durationTime = SystemClock.currentThreadTimeMillis() - currentTime;
        if (0 < durationTime && durationTime < 500) {
            return true;
        }
        return false;
    }

    /*
    * 双击退出
    * */

    private static Boolean isExit = false;

    public static void doubleClickExit(ExitEvevtDispatch exitEvevtDispatch){
        Timer mExit = null;

        if (false == isExit){
            isExit = true;
            Toast.makeText(JHApplication.getContext(), "Click Again To Exit", Toast.LENGTH_SHORT).show();
            com.orhanobut.logger.Logger.d(JHApplication.getContext() + "JHApplication.getContext()");
//            创建定时器,检测接来时候点击了第二次
            mExit = new Timer();
            mExit.schedule(new TimerTask() {
                               @Override
                               public void run() {
                                   isExit = false;
                               }
                           }
                    , 2000
            );
        return;

    }else{
           exitEvevtDispatch.exitApplication();
        }
    }
}
