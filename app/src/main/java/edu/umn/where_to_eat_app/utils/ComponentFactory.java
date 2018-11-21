package edu.umn.where_to_eat_app.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import edu.umn.where_to_eat_app.R;
import edu.umn.where_to_eat_app.variable_pages.RestaurantActivity;
import edu.umn.where_to_eat_app.variable_pages.UserActivity;
import edu.umn.where_to_eat_app.data.Restaurant;
import edu.umn.where_to_eat_app.data.Restaurants;
import edu.umn.where_to_eat_app.data.User;
import edu.umn.where_to_eat_app.data.Users;

public class ComponentFactory {
    public static LinearLayout makeRestaurantBox(Restaurant restaurant, Activity activity) {
        // Create LinearLayout
        LinearLayout ll = new LinearLayout(activity.getApplicationContext());
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(10, 10, 10, 10);

        // image
        ImageView image = new ImageView(activity.getApplicationContext());
        image.setImageResource(restaurant.getImgSrc());
        image.setLayoutParams(new LinearLayout.LayoutParams(300, 350));

        Space spaceH = new Space(activity.getApplicationContext());
        spaceH.setLayoutParams(new LinearLayout.LayoutParams(50, 0));

        // inner layout
        LinearLayout ill = new LinearLayout(activity.getApplicationContext());
        ill.setOrientation(LinearLayout.VERTICAL);
        ill.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 350));

        // text
        TextView nm = new TextView(activity.getApplicationContext());
        nm.setTextSize(24);
        nm.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
        nm.setText(restaurant.getName());
        nm.setGravity(Gravity.CENTER_VERTICAL);
        if (Users.getCurrentUserObject().getFavoriteRestaurants().contains(restaurant)) {
            nm.setText("★ " + nm.getText());
        }

        // distance
        TextView distance = new TextView(activity.getApplicationContext());
        distance.setText(String.valueOf(restaurant.getDistance()) + " mi.");
        distance.setTextColor(activity.getResources().getColor(R.color.white));
        distance.setBackgroundColor(activity.getResources().getColor(R.color.lightBlue));
        distance.setPadding(5, 2, 5, 2);
        distance.setLayoutParams(new LinearLayout.LayoutParams(200, ViewGroup.LayoutParams.WRAP_CONTENT));
        distance.setGravity(Gravity.CENTER);


        // subtext
        LinearLayout iill = new LinearLayout(activity.getApplicationContext());
        iill.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
        iill.setOrientation(LinearLayout.HORIZONTAL);

        // rating
        TextView rating = new TextView(activity.getApplicationContext());
        rating.setText(Double.toString(restaurant.getRating()) + "★");
        rating.setTextColor(activity.getResources().getColor(R.color.white));
        rating.setBackgroundColor(activity.getResources().getColor(R.color.darkRed));
        rating.setPadding(5, 2, 5, 2);

        // dollars
        TextView dollars = new TextView(activity.getApplicationContext());
        String dollarString = "";
        for (int i = 0; i < restaurant.getDollars(); i++) {
            dollarString += "$";
        }
        dollars.setText(dollarString);
        dollars.setTextColor(activity.getResources().getColor(R.color.white));
        dollars.setBackgroundColor(activity.getResources().getColor(R.color.colorAccent));
        dollars.setPadding(5, 2, 5, 2);
        dollars.setLayoutParams(new LinearLayout.LayoutParams(150, ViewGroup.LayoutParams.WRAP_CONTENT));
        dollars.setGravity(Gravity.CENTER);

        // cuisine
        HorizontalScrollView cuisineScroll = new HorizontalScrollView(activity.getApplicationContext());

        LinearLayout iiill = new LinearLayout(activity.getApplicationContext());
        iiill.setOrientation(LinearLayout.HORIZONTAL);

        Space spaceIH = new Space(activity.getApplicationContext());
        spaceIH.setLayoutParams(new LinearLayout.LayoutParams(50, 0));

        boolean first = true;
        for (Restaurants.type t : restaurant.getCuisine()) {
            TextView cuisine = new TextView(activity.getApplicationContext());
            cuisine.setText(t.toString().replace('_', ' '));
            cuisine.setBackgroundColor(Color.DKGRAY);
            cuisine.setTextColor(activity.getResources().getColor(R.color.white));
            cuisine.setPadding(5, 2, 5, 2);

            Space spaceIIH = new Space(activity.getApplicationContext());
            spaceIIH.setLayoutParams(new LinearLayout.LayoutParams(50, 0));

            if (first) {
                first = false;
            } else {
                iiill.addView(spaceIIH);
            }
            iiill.addView(cuisine);
        }

        cuisineScroll.addView(iiill);
        iill.addView(rating);
        iill.addView(dollars);
        iill.addView(spaceIH);
        iill.addView(cuisineScroll);
        ill.addView(nm);
        ill.addView(distance);
        ill.addView(iill);
        ll.addView(image);
        ll.addView(spaceH);
        ll.addView(ill);

        ll.setOnClickListener((e) -> {
            int idx = Restaurants.getRestaurantArrayList().indexOf(restaurant);

            Intent i = new Intent(activity, RestaurantActivity.class);
            i.putExtra("Index", idx);
            activity.startActivity(i);
        });

        return ll;
    }

    public static LinearLayout makeUserBox(User user, Activity activity) {
        // Create LinearLayout
        LinearLayout ll = new LinearLayout(activity.getApplicationContext());
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(10, 10, 10, 10);

        // image
        ImageView image = new ImageView(activity.getApplicationContext());
        image.setImageResource(user.getImageSrc());
        image.setLayoutParams(new LinearLayout.LayoutParams(300, 350));

        Space spaceH = new Space(activity.getApplicationContext());
        spaceH.setLayoutParams(new LinearLayout.LayoutParams(50, 0));

        LinearLayout ill = new LinearLayout(activity.getApplicationContext());
        ill.setOrientation(LinearLayout.VERTICAL);

        TextView nickname = new TextView(activity.getApplicationContext());
        nickname.setText(user.getNickname());
        nickname.setTextSize(24);
        nickname.setGravity(Gravity.BOTTOM);
        nickname.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));

        TextView username = new TextView(activity.getApplicationContext());
        username.setText("@" + user.getUsername());
        username.setGravity(Gravity.TOP);
        username.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));

        ill.addView(nickname);
        ill.addView(username);
        ll.addView(image);
        ll.addView(spaceH);
        ll.addView(ill);

        ll.setOnClickListener((e) -> {
            int idx = Users.indexOf(user);

            Intent i = new Intent(activity, UserActivity.class);
            i.putExtra("Index", idx);
            activity.startActivity(i);
        });

        return ll;
    }

    public static View[] makeVotingBox(Restaurant restaurant, Activity context) {
        // 0 is restaurant info
        // 1 is button container
        // 2 3 4 are buttons
        View[] ret = new View[5];
        ret[0] = makeRestaurantBox(restaurant, context);
        ret[0].setOnClickListener(null);

        Button buttonNo = new Button(context);
        buttonNo.setText("No");
        Button buttonMaybe = new Button(context);
        buttonMaybe.setText("Maybe");
        Button buttonYes = new Button(context);
        buttonYes.setText("Yes");

        LinearLayout buttonContainer = new LinearLayout(context);
        buttonContainer.setOrientation(LinearLayout.HORIZONTAL);
        buttonContainer.addView(buttonNo);
        buttonContainer.addView(buttonMaybe);
        buttonContainer.addView(buttonYes);
        buttonContainer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        buttonContainer.setGravity(Gravity.CENTER_HORIZONTAL);

        ret[1] = buttonContainer;
        ret[2] = buttonNo;
        ret[3] = buttonMaybe;
        ret[4] = buttonYes;

        return ret;
    }
}