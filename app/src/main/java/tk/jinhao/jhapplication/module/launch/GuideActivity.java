package tk.jinhao.jhapplication.module.launch;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;

import butterknife.ButterKnife;
import butterknife.InjectView;
import tk.jinhao.jhapplication.R;

/**
 * Created by shanks on 15/5/25.
 */
public class GuideActivity extends Activity {

    @InjectView(R.id.view_pager_guide)
    ViewPager mViewPagerGuide;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_guide);
        ButterKnife.inject(this);
        mViewPagerGuide.setAdapter(null);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
