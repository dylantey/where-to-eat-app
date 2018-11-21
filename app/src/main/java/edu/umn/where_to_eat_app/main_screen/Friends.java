package edu.umn.where_to_eat_app.main_screen;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import edu.umn.where_to_eat_app.R;
import edu.umn.where_to_eat_app.data.Restaurant;
import edu.umn.where_to_eat_app.data.User;
import edu.umn.where_to_eat_app.data.Users;
import edu.umn.where_to_eat_app.utils.ComponentFactory;

public class Friends extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        return inflater.inflate(R.layout.friends, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Friends");

        // Populate friends list
        if(Users.getCurrentUserObject().getFriendsList().size() == 0) {
            TextView sad = new TextView(getContext());
            sad.setText("\n\n\n\nYou have no friends. 💔");
            sad.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            sad.setGravity(Gravity.CENTER);
            sad.setTextSize(26);
            ((LinearLayout) getView().findViewById(R.id.favoritesContainer)).addView(sad);
        } else {
            for (String s : Users.getCurrentUserObject().getFriendsList()) {
                User user = Users.getUserObject(s);
                LinearLayout ll = ComponentFactory.makeUserBox(user, getActivity());

                Space space = new Space(getContext());
                space.setLayoutParams(new LinearLayout.LayoutParams(0, 50));

                ((LinearLayout) getView().findViewById(R.id.friendsContainer)).addView(ll);
                ((LinearLayout) getView().findViewById(R.id.friendsContainer)).addView(space);
            }
        }
    }
}
