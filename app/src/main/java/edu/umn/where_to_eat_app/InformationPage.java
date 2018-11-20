package edu.umn.where_to_eat_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class InformationPage extends AppCompatActivity {

    StringBuffer sb = null;
    infoPageAdapter adapter;
    Restaurants restaurants = new Restaurants();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_info_page);
        //setSupportActionBar(toolbar);

        this.adapter = new infoPageAdapter(this, restaurants.getRestaurantArrayList());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_info_page);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sb = new StringBuffer();

                for(Restaurant r : adapter.checkedRestaurants){
                    restaurants.selectRestaurant(r.getName());
                    sb.append(r.getName());
                    sb.append("\n");
                }
                if(adapter.checkedRestaurants.size()>0){
                    Toast.makeText(InformationPage.this,sb.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(InformationPage.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Recycler
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        //rv.setItemViewCacheSize(restaurants.restaurantSize());

        //set adapter
        rv.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu); //maybe R.menu.main is wrong
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
