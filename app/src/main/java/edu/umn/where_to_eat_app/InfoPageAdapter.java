package edu.umn.where_to_eat_app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import edu.umn.where_to_eat_app.data.Restaurant;
import edu.umn.where_to_eat_app.data.Restaurants;
import edu.umn.where_to_eat_app.utils.ComponentFactory;

public class InfoPageAdapter extends RecyclerView.Adapter<InfoPageHolder>{

    Context context;
    ArrayList<Restaurant> restaurants;

    public InfoPageAdapter(Context c, ArrayList<Restaurant> restaurants) {
        this.context = c;
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public InfoPageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_selection_restaurant,null);
        InfoPageHolder holder = new InfoPageHolder(view);
        return holder;
    }

    //DATA is bound to views
    @Override
    public void onBindViewHolder(@NonNull InfoPageHolder holder, int position) {

        ((LinearLayout) holder.getContainer()).removeAllViews();

        holder.setComponent(ComponentFactory.makeRestaurantBox(restaurants.get(position), (Activity) context));
        if(holder.getSelected()) {
            holder.getComponent().setBackgroundColor(Color.rgb(0, 204, 0));
        }
        holder.getComponent().setOnClickListener((e) -> {
            if(holder.getSelected()) {
                holder.getComponent().setBackgroundColor(Color.rgb(250, 250, 250));
                Restaurants.selectedRemove(restaurants.get(position));
                holder.setSelected(false);

            } else {
                holder.getComponent().setBackgroundColor(Color.rgb(0, 204, 0));
                Restaurants.selectedAdd(restaurants.get(position));
                holder.setSelected(true);
            }


        });

        ((LinearLayout) holder.getContainer()).addView(holder.getComponent());
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

