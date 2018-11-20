package edu.umn.where_to_eat_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

public class Explore extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.explore, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Explore Restaurants");

        // Populate restaurant list
        for(Restaurant r : Restaurants.getRestaurantArrayList()) {
            System.out.println(r.getName());
            LinearLayout ll = ComponentFactory.makeRestaurantBox(r, getActivity());

            Space space = new Space(getContext());
            space.setLayoutParams(new LinearLayout.LayoutParams(0, 50));

            ((LinearLayout) getView().findViewById(R.id.favoritesContainer)).addView(ll);
            ((LinearLayout) getView().findViewById(R.id.favoritesContainer)).addView(space);
        }
    }
}
