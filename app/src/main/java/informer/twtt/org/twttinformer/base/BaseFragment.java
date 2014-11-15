package informer.twtt.org.twttinformer.base;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by namheo on 11/13/14.
 */
public class BaseFragment extends Fragment {
    protected String mTitle = "";

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("onDestroy", mTitle);
    }

    public void notify(String event, Object target, Object data) {
        if (getActivity() == null) return;
        BaseActionBarActivity activity = (BaseActionBarActivity) getActivity();
        if (activity != null)
            activity.onReact(event, target, data);
    }
}
