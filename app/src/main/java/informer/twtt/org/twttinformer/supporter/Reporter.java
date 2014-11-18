package informer.twtt.org.twttinformer.supporter;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by namheo on 11/15/14.
 */
public class Reporter {
    public static String INNER_APP = "twtt_informer";
    private static boolean IS_ENABLED = false;

    private static ArrayList<String> tags = new ArrayList<String>();

    public static void setEnable(boolean value) {
        IS_ENABLED = value;
    }

    public static void initiateTags(String... tagString) {
        tags = new ArrayList<String>();
        for (int i = 0; i < tagString.length; i++) {
            tags.add(tagString[i]);
        }
    }

    public static void log(String tag, String message) {
        if (IS_ENABLED && contains(tag)) {
            Log.v(INNER_APP + " : " + tag,  message);
            Log.v(INNER_APP + " : " + tag,  "From " + getClassAndMethodName(4));
        }
    }

    private static boolean contains(String tag) {
        for (String item : tags) {
            if (item.equals(tag)) {
                return true;
            }
        }
        return false;
    }

    public static String getClassAndMethodName(final int depth) {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        if (ste != null && ste.length > depth) {
            return ste[depth].getClassName() + "." + ste[depth].getMethodName();
        }
        return "";
    }
}
