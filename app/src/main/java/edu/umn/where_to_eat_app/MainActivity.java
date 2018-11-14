package edu.umn.where_to_eat_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // User stuff
        new Users();
        Users.setCurrentUser("???");

        // Initial stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get saved data
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String user = prefs.getString("User", "");

        if(!user.equals("")) {
            Users.setCurrentUser(user);
            TextView welcome = findViewById(R.id.welcomeText);
            welcome.setText("Welcome, " + Users.getCurrentName() + "!");
        } else {
            startActivityForResult(new Intent(MainActivity.this, Login.class), 1);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resultIntent) {
        if(requestCode == 1) {
            if(resultCode == 1) {
                // Set welcome text
                TextView welcome = findViewById(R.id.welcomeText);
                welcome.setText("Welcome, " + Users.getCurrentName() + "!");

                // Set prefs to user
                SharedPreferences.Editor edit = prefs.edit();
                edit.putString("User", Users.getCurrentUser());
                edit.apply();
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.logout) {
            // Resets prefs
            SharedPreferences.Editor edit = prefs.edit();
            edit.putString("User", "");
            edit.apply();

            // Closes drawer
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);

            // Recreates the activity
            recreate();
            return true;
        }

        Fragment fragment = MenuHandler.getFragment(item);

        if(fragment != null) {
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        } else {
            for (Fragment f:getSupportFragmentManager().getFragments()) {
                if (f!=null) {
                    getSupportFragmentManager().beginTransaction().remove(f).commit();
                }
            }
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
