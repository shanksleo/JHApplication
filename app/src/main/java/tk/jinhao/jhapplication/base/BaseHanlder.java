package tk.jinhao.jhapplication.base;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by shanks on 15/5/22.
 */
public class BaseHanlder extends Handler{
    WeakReference<IMessageHandler> mIEventHandlerWeakReference;

    public BaseHanlder(IMessageHandler iMessageHandler) {
        mIEventHandlerWeakReference = new WeakReference<IMessageHandler>(iMessageHandler);
    }

    @Override
    public void handleMessage(Message msg) {
        if (mIEventHandlerWeakReference != null&& mIEventHandlerWeakReference.get() != null){
            mIEventHandlerWeakReference.get().handleMessage(msg);
        }
    }
}
