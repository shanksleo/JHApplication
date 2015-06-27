package tk.jinhao.jhlibrary.logic;

import android.content.Context;

import tk.jinhao.jhlibrary.util.CallBack;

/**
 * Created by shanks on 15/6/8.
 */
public class LogicManager implements LogicInterface{
    private LogicInterface mLogicInterface;

    public static LogicManager getInstace(){
       return (LogicManager) Instance.logicInterface;
    }

    static class Instance{
        static LogicInterface logicInterface = new LogicManager();
    }

    private LogicManager() {
        this.mLogicInterface = new LogicImpl();
    }

    @Override
    public void login(Context context, CallBack callBack) {
        mLogicInterface.login(context,callBack);
    }

    @Override
    public void loginOut(Context context, CallBack callBack) {
        mLogicInterface.loginOut(context,callBack);
    }
}
