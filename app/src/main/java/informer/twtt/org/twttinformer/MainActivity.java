package informer.twtt.org.twttinformer;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import informer.twtt.org.twttinformer.base.BaseActionBarActivity;
import informer.twtt.org.twttinformer.base.BaseFragment;
import informer.twtt.org.twttinformer.base.BaseListFragment;
import informer.twtt.org.twttinformer.fragment.PlaceholderFragment;
import informer.twtt.org.twttinformer.fragment.TimeTableFragment;


public class MainActivity extends BaseActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, BaseListFragment.OnFragmentInteractionListener {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    private void initiateApp() {

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
        Log.v("onNavigationDrawerItemSelected", "" + position);
        if (mNavigationDrawerFragment != null) {
            BaseFragment frag = null;
            switch (position) {
                case 0:
                    frag = new TimeTableFragment();
                    break;

            }
            if (frag == null) frag = new PlaceholderFragment();
            frag.setTitle(mNavigationDrawerFragment.getTitleAtPosition(position));
            if (frag != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, frag)
                        .commit();
            }
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onReact(String event, Object target, Object data) {
        if (event.equals("onAttach")) {
            restoreActionBar((String) data);
        }
    }

    public void onFragmentInteraction(String id) {

    }

}
