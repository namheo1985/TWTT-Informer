package informer.twtt.org.twttinformer.data;

import java.util.Observable;

/**
 * Created by neotran on 11/19/14.
 */
public class ObservableBoolean extends Observable {
    private boolean value = false;

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean name) {
        this.value = name;
            setChanged();
            notifyObservers(name);
    }
}
