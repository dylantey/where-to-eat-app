package edu.umn.where_to_eat_app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import edu.umn.where_to_eat_app.data.Restaurants;
import edu.umn.where_to_eat_app.utils.ComponentFactory;

class VotingAdapter extends RecyclerView.Adapter<VotingHolder>{

    private Context context;
    private int[] weights = new int[Restaurants.getSelectedRestaurants().size()];

    public VotingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public VotingHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_voting_restaurant,null);
        VotingHolder holder = new VotingHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VotingHolder holder, int position) {
        ((LinearLayout) holder.getContainer()).removeAllViews();

        View[] newComponents = ComponentFactory.makeVotingBox(Restaurants.getSelectedRestaurants().get(position), (Activity) context);

        holder.setComponent((LinearLayout) newComponents[0]);


        Button[] buttons = new Button[] {(Button) newComponents[2],(Button)  newComponents[3],(Button)  newComponents[4]};
        for(int i = 0; i < buttons.length; i++) {
            final int idx = i;
            if(i != 1) {
                buttons[i].setBackgroundColor(context.getResources().getColor(R.color.white));
                buttons[i].setTextColor(context.getResources().getColor(R.color.black));
            } else {
                buttons[i].setBackgroundColor(context.getResources().getColor(R.color.darkRed));
                buttons[i].setTextColor(context.getResources().getColor(R.color.white));
            }
            buttons[i].setOnClickListener((e) -> {
                for(Button b : buttons) {
                    b.setBackgroundColor(context.getResources().getColor(R.color.white));
                    b.setTextColor(context.getResources().getColor(R.color.black));
                }
                buttons[idx].setBackgroundColor(context.getResources().getColor(R.color.darkRed));
                buttons[idx].setTextColor(context.getResources().getColor(R.color.white));
                weights[position] = idx - 1;
            });
        }

        ((LinearLayout) holder.getContainer()).addView(holder.getComponent());
        ((LinearLayout) holder.getContainer()).addView(newComponents[1]);
    }

    @Override
    public int getItemCount() {
        return Restaurants.getSelectedRestaurants().size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public int[] getWeights() {
        return weights;
    }

}
