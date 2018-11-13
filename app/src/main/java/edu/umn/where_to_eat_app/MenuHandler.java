package edu.umn.where_to_eat_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

public class MenuHandler {

    public static Fragment getFragment(MenuItem item) {

        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.home) {
            fragment = new JoinARoom();
        } else if (id == R.id.profile) {
            fragment = new ProfilePage();
        }

        return fragment;
    }
}
