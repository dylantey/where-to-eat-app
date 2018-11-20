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

public class newInformationPage extends AppCompatActivity {

    StringBuffer sb = null;
    infoPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_information_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_info_page);
        //setSupportActionBar(toolbar);

        this.adapter = new infoPageAdapter(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_info_page);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sb = new StringBuffer();
                int selectedSize = Restaurants.selectedSize();
                for(int i=0;i<selectedSize;i++){
                    Restaurant p = Restaurants.selectedGet(i);
                    sb.append(p.getName());
                    sb.append("\n");
                }
                if(selectedSize>0){
                    Toast.makeText(newInformationPage.this,sb.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(newInformationPage.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Recycler
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //set adapter
        rv.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
