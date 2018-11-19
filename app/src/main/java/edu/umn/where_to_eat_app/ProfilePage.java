package edu.umn.where_to_eat_app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;

public class ProfilePage extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_page, container, false);
    }
    
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Profile Page");

        TextView name = getView().findViewById(R.id.profileName);
        name.setText(Users.getCurrentName());

        // Populate restaurant list
        for(Restaurant r : Restaurants.getRestaurantArrayList()) {
            LinearLayout ll = ComponentFactory.makeRestaurantBox(r, getActivity());

            Space space = new Space(getContext());
            space.setLayoutParams(new LinearLayout.LayoutParams(0, 50));

            ((LinearLayout) getView().findViewById(R.id.favoritesContainer)).addView(ll);
            ((LinearLayout) getView().findViewById(R.id.favoritesContainer)).addView(space);

        }
    }

}