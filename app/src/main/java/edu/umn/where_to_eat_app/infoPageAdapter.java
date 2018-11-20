package edu.umn.where_to_eat_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

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
        String name = new String(r.getName());
        System.out.println(name);
        holder.name.setText(name);
        holder.distance.setText(String.valueOf(r.getDistance()));
        holder.rating.setText(String.valueOf(r.getRating()));
        //holder.cuisine.setText("idk");//how to get string of cuisines???????????????????????????
        holder.img.setImageResource(r.getImgSrc());

        holder.setItemClickListener((view, position1) -> {
            CheckBox chk = (CheckBox) view;

            //checked or not
            if (chk.isChecked()) {
                checkedRestaurants.add(restaurants.get(position1));
            } else {
                if (!chk.isChecked()) {
                    checkedRestaurants.remove(restaurants.get(position1));
                }
            }
        });
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

