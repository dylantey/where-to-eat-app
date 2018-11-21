package edu.umn.where_to_eat_app.main_screen;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import edu.umn.where_to_eat_app.R;
import edu.umn.where_to_eat_app.data.Restaurant;
import edu.umn.where_to_eat_app.data.Users;
import edu.umn.where_to_eat_app.utils.ComponentFactory;

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

        ImageView profilePic = getView().findViewById(R.id.profilePicture);
        profilePic.setImageResource(Users.getCurrentUserObject().getImageSrc());

        // Populate restaurant list
        if(Users.getCurrentUserObject().getFavoriteRestaurants().size() == 0) {
            TextView sad = new TextView(getContext());
            sad.setText("\n\n\n\nFavorites list is empty.");
            sad.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            sad.setGravity(Gravity.CENTER);
            sad.setTextSize(26);
            ((LinearLayout) getView().findViewById(R.id.favoritesContainer)).addView(sad);
        } else {
            for (Restaurant r : Users.getCurrentUserObject().getFavoriteRestaurants()) {
                LinearLayout ll = ComponentFactory.makeRestaurantBox(r, getActivity());

                Space space = new Space(getContext());
                space.setLayoutParams(new LinearLayout.LayoutParams(0, 50));

                ((LinearLayout) getView().findViewById(R.id.favoritesContainer)).addView(ll);
                ((LinearLayout) getView().findViewById(R.id.favoritesContainer)).addView(space);
            }
        }
    }

}