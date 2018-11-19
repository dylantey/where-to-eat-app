package edu.umn.where_to_eat_app;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

            // Create LinearLayout
            LinearLayout ll = new LinearLayout(getContext());
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ll.setBackgroundColor(Color.LTGRAY);

            // image
            ImageView image = new ImageView(getContext());
            image.setImageResource(r.getImgSrc());
            image.setLayoutParams(new LinearLayout.LayoutParams(300,300));

            Space spaceH = new Space(getContext());
            spaceH.setLayoutParams(new LinearLayout.LayoutParams(50, 0));

            // inner layout
            LinearLayout ill = new LinearLayout(getContext());
            ill.setOrientation(LinearLayout.VERTICAL);
            ill.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));

            // text
            TextView nm = new TextView(getContext());
            nm.setTextSize(24);
            nm.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
            nm.setText(r.getName());
            nm.setGravity(Gravity.CENTER_VERTICAL);

            // subtext
            LinearLayout iill = new LinearLayout(getContext());
            iill.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
            iill.setOrientation(LinearLayout.HORIZONTAL);

            // rating
            TextView rating = new TextView(getContext());
            rating.setText(Double.toString(r.getRating()) + "★");
            rating.setTextColor(getResources().getColor(R.color.white));
            rating.setBackgroundColor(getResources().getColor(R.color.darkRed));
            rating.setPadding(5, 2, 5, 2);

            iill.addView(rating);
            ill.addView(nm);
            ill.addView(iill);
            ll.addView(image);
            ll.addView(spaceH);
            ll.addView(ill);

            for(Restaurants.type t : r.getCuisine()) {
                TextView cuisine = new TextView(getContext());
                cuisine.setText(t.toString());
                cuisine.setBackgroundColor(Color.DKGRAY);
                cuisine.setTextColor(getResources().getColor(R.color.white));
                cuisine.setPadding(5, 2, 5, 2);

                Space spaceIH = new Space(getContext());
                spaceIH.setLayoutParams(new LinearLayout.LayoutParams(50, 0));

                iill.addView(spaceIH);
                iill.addView(cuisine);
            }

            Space space = new Space(getContext());
            space.setLayoutParams(new LinearLayout.LayoutParams(0, 50));

            ((LinearLayout) getActivity().findViewById(R.id.favoritesContainer)).addView(ll);
            ((LinearLayout) getActivity().findViewById(R.id.favoritesContainer)).addView(space);

        }

        getView().setOnKeyListener((v, keyCode, event) -> {
            if( keyCode == KeyEvent.KEYCODE_BACK )
            {
                for (Fragment f:getActivity().getSupportFragmentManager().getFragments()) {
                    if (f!=null) {
                        getActivity().getSupportFragmentManager().beginTransaction().remove(f).commit();
                    }
                }
                return true;
            }
            return false;
        });

    }
}