package tk.jinhao.jhapplication.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by shanks on 15/5/22.
 */
public abstract class JHActivityEventHandler implements IEventHandler {
    protected Activity mActivity;

    public void setContext(Activity activity) {
        mActivity = activity;
    }

    @Override
    public abstract void handleFragmentEvent(int eventType, int eventId, Bundle data);

    @Override
    public abstract void switchFragment(int eventId, Bundle data);


}
