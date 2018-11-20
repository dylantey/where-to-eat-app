package edu.umn.where_to_eat_app;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class infoPageHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View container;
    LinearLayout component;

    ItemClickListener itemClickListener;
    boolean selected = false;

    public infoPageHolder(View itemView) {
        super(itemView);
        container = itemView.findViewById(R.id.cardContainer);

    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v, getLayoutPosition());
    }
}

