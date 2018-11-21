package edu.umn.where_to_eat_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toast;

import edu.umn.where_to_eat_app.data.Restaurant;
import edu.umn.where_to_eat_app.data.Restaurants;

public class InformationPage extends AppCompatActivity {

    private StringBuffer sb = null;
    private InfoPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_page);
        this.adapter = new InfoPageAdapter(this, Restaurants.getFilteredRestaurants());

        setTitle("Select Restaurants to Add");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab_info_page);
        fab.setOnClickListener(v -> {
            sb = new StringBuffer();

            for(Restaurant r : adapter.checkedRestaurants){
                Restaurants.selectRestaurant(r.getName());
                sb.append(r.getName());
                sb.append("\n");
            }
            if(adapter.checkedRestaurants.size()>0){
                Toast.makeText(InformationPage.this,sb.toString(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(InformationPage.this,"Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });

        //Recycler
        RecyclerView rv = findViewById(R.id.recyclerView);
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
        return false;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
