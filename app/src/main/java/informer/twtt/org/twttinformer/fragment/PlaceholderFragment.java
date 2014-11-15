package informer.twtt.org.twttinformer.fragment;

/**
 * Created by namheo on 11/13/14.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import informer.twtt.org.twttinformer.R;
import informer.twtt.org.twttinformer.base.BaseFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends BaseFragment {
    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        notify("onAttach", this, mTitle);
    }
}
