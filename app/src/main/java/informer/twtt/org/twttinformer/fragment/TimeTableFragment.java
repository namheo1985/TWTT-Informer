package informer.twtt.org.twttinformer.fragment;

import android.widget.ArrayAdapter;

import informer.twtt.org.twttinformer.R;
import informer.twtt.org.twttinformer.base.BaseListFragment;
import informer.twtt.org.twttinformer.data.TimeTableContent;
import informer.twtt.org.twttinformer.data.adapter.TimeTableAdapter;

/**
 * Created by namheo on 11/13/14.
 */
public class TimeTableFragment extends BaseListFragment {
    @Override
    public ArrayAdapter createAdapter() {
        return new TimeTableAdapter(getActivity(),
                R.layout.simple_list_item, TimeTableContent.ITEMS);
    }
}
