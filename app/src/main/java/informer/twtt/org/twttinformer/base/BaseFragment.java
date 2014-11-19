package informer.twtt.org.twttinformer.base;

import android.support.v4.app.Fragment;

import java.util.Observer;

import informer.twtt.org.twttinformer.data.ObservableString;
import informer.twtt.org.twttinformer.supporter.Reporter;

/**
 * Created by namheo on 11/13/14.
 */
public abstract class BaseFragment extends Fragment implements Observer{
    protected ObservableString mTitle;

    public void setTitle(ObservableString title) {
        mTitle = title;
    }

    public ObservableString getTitle() {
        return mTitle;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
