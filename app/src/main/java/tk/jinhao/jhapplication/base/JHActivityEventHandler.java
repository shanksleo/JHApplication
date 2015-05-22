package tk.jinhao.jhapplication.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by shanks on 15/5/22.
 */
public class JHActivityEventHandler implements IEventHandler{
    private Activity mActivity;

    public void setContext(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void handleFragmentEvent(int eventType, int eventId, Bundle data) {

    }

    @Override
    public void switchFragment(int eventId, Bundle data) {

    }
}
