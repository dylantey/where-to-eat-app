package edu.umn.where_to_eat_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

public class ComponentFactory {
    public static LinearLayout makeRestaurantBox(Restaurant restaurant, Activity activity) {
        // Create LinearLayout
        LinearLayout ll = new LinearLayout(activity.getApplicationContext());
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(10, 10, 10, 10);

        // image
        ImageView image = new ImageView(activity.getApplicationContext());
        image.setImageResource(restaurant.getImgSrc());
        image.setLayoutParams(new LinearLayout.LayoutParams(300,300));

        Space spaceH = new Space(activity.getApplicationContext());
        spaceH.setLayoutParams(new LinearLayout.LayoutParams(50, 0));

        // inner layout
        LinearLayout ill = new LinearLayout(activity.getApplicationContext());
        ill.setOrientation(LinearLayout.VERTICAL);
        ill.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));

        // text
        TextView nm = new TextView(activity.getApplicationContext());
        nm.setTextSize(24);
        nm.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
        nm.setText(restaurant.getName());
        nm.setGravity(Gravity.CENTER_VERTICAL);
        if(Users.getCurrentUserObject().getFavoriteRestaurants().contains(restaurant)) {
            nm.setText("★ " + nm.getText());
        }

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
        for(int i = 0; i < restaurant.getDollars(); i++) {
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
        for(Restaurants.type t : restaurant.getCuisine()) {
            TextView cuisine = new TextView(activity.getApplicationContext());
            cuisine.setText(t.toString().replace('_', ' '));
            cuisine.setBackgroundColor(Color.DKGRAY);
            cuisine.setTextColor(activity.getResources().getColor(R.color.white));
            cuisine.setPadding(5, 2, 5, 2);

            Space spaceIIH = new Space(activity.getApplicationContext());
            spaceIIH.setLayoutParams(new LinearLayout.LayoutParams(50, 0));

            if(first) {
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
}
