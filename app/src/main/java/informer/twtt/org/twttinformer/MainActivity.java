package informer.twtt.org.twttinformer;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Observable;
import java.util.Observer;

import informer.twtt.org.twttinformer.base.BaseActionBarActivity;
import informer.twtt.org.twttinformer.base.BaseFragment;
import informer.twtt.org.twttinformer.data.ObservableString;
import informer.twtt.org.twttinformer.fragment.PlaceholderFragment;
import informer.twtt.org.twttinformer.fragment.TimeTableFragment;
import informer.twtt.org.twttinformer.supporter.Reporter;


public class MainActivity extends BaseActionBarActivity
        implements Observer, NavigationDrawerFragment.NavigationDrawerCallbacks {
    private NavigationDrawerFragment mNavigationDrawerFragment;
    ObservableString titleData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleData = new ObservableString();
        titleData.addObserver(this);
        Reporter.initiateTags("fragment", "");
        Reporter.setEnable(true);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (titleData != null)
            titleData.deleteObservers();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mNavigationDrawerFragment != null) {
            mNavigationDrawerFragment.selectItem(0);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mIsFirstTimeLoaded) {
            mIsFirstTimeLoaded = false;
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        if (mNavigationDrawerFragment != null) {
            BaseFragment frag = null;
            switch (position) {
                case 0:
                    frag = new TimeTableFragment();
                    break;
            }
            if (frag == null) frag = new PlaceholderFragment();
            titleData.setValue(mNavigationDrawerFragment.getTitleAtPosition(position), false);
            frag.setTitle(titleData);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, frag)
                    .commit();

        }
    }

    public void restoreActionBar(String title) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (mNavigationDrawerFragment != null && !mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return (id == R.id.action_settings) || super.onOptionsItemSelected(item);
    }

    @Override
    public void update(Observable observable, Object data) {
        if (observable == null) return;
        if (observable instanceof ObservableString) {
            ObservableString titleData = (ObservableString) observable;
            restoreActionBar(titleData.getValue());
        }
    }
}
