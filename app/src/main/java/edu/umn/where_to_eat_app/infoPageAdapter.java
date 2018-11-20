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
    //ArrayList<Restaurant> restaurants;
    //ArrayList<Restaurant> checkedRestaurants = Restaurants.getSelectedRestaurants();

    public infoPageAdapter(Context c) {
        this.context = c;
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
        holder.name.setText(Restaurants.restaurantGet(position).getName());
        holder.distance.setText(Restaurants.restaurantGet(position).getName());
        holder.rating.setText(String.valueOf(Restaurants.restaurantGet(position).getRating()));
        holder.cuisine.setText("idk");//how to get string of cuisines???????????????????????????
        holder.img.setImageResource(Restaurants.restaurantGet(position).getImgSrc());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                CheckBox chk = (CheckBox) view;

                //checked or not
                if(chk.isChecked()){
                    Restaurants.selectedAdd(Restaurants.restaurantGet(position));
                }else { if(!chk.isChecked()) {
                    Restaurants.selectedRemove(Restaurants.restaurantGet(position));
                }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Restaurants.restaurantSize();
    }
}

