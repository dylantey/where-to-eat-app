package edu.umn.where_to_eat_app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class infoPageAdapter extends RecyclerView.Adapter<infoPageHolder>{

    //MyHolder holder;

    Context context;
    ArrayList<Restaurant> restaurants;
    ArrayList<Restaurant> checkedRestaurants;
    //Restaurants restaurants = new Restaurants();

    public infoPageAdapter(Context c, ArrayList<Restaurant> restaurants) {
        this.context = c;
        this.restaurants = restaurants;
        this.checkedRestaurants = new ArrayList<>();
    }

    //VIEWHOLDER is intitialized
    @NonNull
    @Override
    public infoPageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_selection_restaurant,null);
        infoPageHolder holder = new infoPageHolder(view);
        return holder;
    }

    //DATA is bound to views
    @Override
    public void onBindViewHolder(@NonNull infoPageHolder holder, int position) {

        //binds a restaurant to a view?
        Restaurant r = restaurants.get(position);




        ((LinearLayout) holder.container).removeAllViews();

        holder.component = ComponentFactory.makeRestaurantBox(r, (Activity) context);
        holder.component.setOnClickListener((e) -> {
            if(holder.selected) {
                holder.component.setBackgroundColor(Color.rgb(250, 250, 250));
                checkedRestaurants.remove(restaurants.get(position));
                holder.selected = false;

            } else {
                holder.component.setBackgroundColor(Color.rgb(0, 204, 0));
                checkedRestaurants.add(restaurants.get(position));
                holder.selected = true;
            }


        });

        ((LinearLayout) holder.container).addView(holder.component);
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}

