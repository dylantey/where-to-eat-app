package edu.umn.where_to_eat_app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class infoPageHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    ImageView img;
    TextView name, distance, rating, cuisine;
    CheckBox chk;

    ItemClickListener itemClickListener;

    public infoPageHolder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.textViewTitle);
        distance = (TextView) itemView.findViewById(R.id.textViewShortDesc);
        rating = (TextView) itemView.findViewById(R.id.textViewRating);
        cuisine = (TextView) itemView.findViewById(R.id.textViewPrice);
        img = (ImageView) itemView.findViewById(R.id.imageView);
        chk = (CheckBox) itemView.findViewById(R.id.chk);

        chk.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v, getLayoutPosition());
    }
}

