package edu.umn.where_to_eat_app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

class VotingHolder  extends RecyclerView.ViewHolder
{
    private View container;
    private LinearLayout component;

    private int selected = 0;

    public VotingHolder(View itemView) {
        super(itemView);
        container = itemView.findViewById(R.id.cardContainer);
    }

    public View getContainer() { return container; }
    public LinearLayout getComponent() { return component; }
    public void setComponent(LinearLayout ll) { component = ll; }

    public int getSelected() { return selected; }
    public void setSelected(int i) { selected = i; }

}
