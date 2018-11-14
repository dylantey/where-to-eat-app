package edu.umn.where_to_eat_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class JoinAFriendsRoom extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View rootView =  inflater.inflate(R.layout.join_a_friends_room, container, false);

        Button FriendsRoom1 = (Button) rootView.findViewById(R.id.FriendsRoom1);
        Button FriendsRoom2 = (Button) rootView.findViewById(R.id.FriendsRoom2);
        Button FriendsRoom3 = (Button) rootView.findViewById(R.id.FriendsRoom3);
        Button Back = (Button) rootView.findViewById(R.id.Back);

        Back.setOnClickListener(this);
        FriendsRoom1.setOnClickListener(this);
        FriendsRoom2.setOnClickListener(this);
        FriendsRoom3.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Join a Friend's Room");
    }

    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.Back:
                fragment = new JoinARoomLoggedIn();
                replaceFragment(fragment);
                break;
            case R.id.FriendsRoom1:
                fragment = new Lobby();
                replaceFragment(fragment);
                break;
            case R.id.FriendsRoom2:
                fragment = new Lobby();
                replaceFragment(fragment);
                break;
            case R.id.FriendsRoom3:
                fragment = new Lobby();
                replaceFragment(fragment);
                break;
        }
    }

    public void replaceFragment(Fragment someFragment) {
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}