package informer.twtt.org.twttinformer.data;

import java.util.Observable;

/**
 * Created by neotran on 11/19/14.
 */
public class ObservableString extends Observable {
    private String value = "Observable String";

    public String getValue() {
        return value;
    }

    public void setValue(String name, boolean isNotifying) {
        this.value = name;
        if (isNotifying) {
            setChanged();
            notifyObservers(name);
        }
    }
    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }
}
