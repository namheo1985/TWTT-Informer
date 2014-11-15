package informer.twtt.org.twttinformer.data.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import informer.twtt.org.twttinformer.R;
import informer.twtt.org.twttinformer.data.TimeTableContent;

/**
 * Created by namheo on 11/14/14.
 */
public class TimeTableAdapter extends ArrayAdapter<TimeTableContent.TTRowItem> {
    private int mIdRowLayout;

    public TimeTableAdapter(Context context, int idLayout, List<TimeTableContent.TTRowItem> data) {
        super(context, 0, data);
        mIdRowLayout = idLayout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TimeTableContent.TTRowItem dataRow = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mIdRowLayout, parent, false);
        }
        TextView tvTitle = (TextView) convertView.findViewById(R.id.titleText);
        tvTitle.setText(getContext().getString(dataRow.idContent));
        return convertView;
    }
}
