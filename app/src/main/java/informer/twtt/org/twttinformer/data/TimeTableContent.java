package informer.twtt.org.twttinformer.data;

import java.util.ArrayList;
import java.util.List;

import informer.twtt.org.twttinformer.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TimeTableContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<TTRowItem> ITEMS = new ArrayList<TTRowItem>();
    static {
        // Add 3 sample items.
        addItem(new TTRowItem(0, R.string.title_section_timetable_offline, R.drawable.offline));
        addItem(new TTRowItem(1, R.string.title_section_timetable_kooltalk, R.drawable.offline));
        addItem(new TTRowItem(2, R.string.title_section_timetable_koolaccent, R.drawable.offline));
        addItem(new TTRowItem(3, R.string.title_section_timetable_grammar, R.drawable.offline));
    }

    private static void addItem(TTRowItem item) {
        ITEMS.add(item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class TTRowItem {
        public int id;
        public int idContent;
        public int idResourceIcon;
        public TTRowItem(int id, int content, int idIcon) {
            this.id = id;
            this.idContent = content;
            idResourceIcon = idIcon;
        }
    }
}
