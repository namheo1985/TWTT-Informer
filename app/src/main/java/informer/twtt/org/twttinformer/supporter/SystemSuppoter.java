package informer.twtt.org.twttinformer.supporter;

import android.content.Context;

import informer.twtt.org.twttinformer.R;

/**
 * Created by namheo on 11/15/14.
 */
public class SystemSuppoter {
    public static boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }
}
