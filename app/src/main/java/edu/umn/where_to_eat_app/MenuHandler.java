package edu.umn.where_to_eat_app;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

public class MenuHandler {

    public static Fragment getFragment(MenuItem item) {

        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.home) {
            fragment = null;
        } else if (id == R.id.profile) {
            fragment = new ProfilePage();
        } else if (id == R.id.friendsprofile) {
            fragment = new friends();
        } else if (id == R.id.explore) {
            fragment = new Explore();
        }

        return fragment;
    }
}
