package edu.umn.where_to_eat_app.voting_screens;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.umn.where_to_eat_app.R;

public class InfoPageHolder extends RecyclerView.ViewHolder
{
    private View container;
    private LinearLayout component;

    private boolean selected = false;

    public InfoPageHolder(View itemView) {
        super(itemView);
        container = itemView.findViewById(R.id.cardContainer);
    }

    public View getContainer() { return container; }
    public LinearLayout getComponent() { return component; }
    public void setComponent(LinearLayout ll) { component = ll; }

    public boolean getSelected() { return selected; }
    public void setSelected(boolean b) { selected = b; }

}

