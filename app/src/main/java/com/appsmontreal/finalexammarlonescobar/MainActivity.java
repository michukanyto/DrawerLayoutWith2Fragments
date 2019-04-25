package com.appsmontreal.finalexammarlonescobar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import model.Bike;
import model.BikeFragment;
import model.CarFragment;
import model.Vehicule;
import model.VehiculeFileManagement;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final String KEY = "keyOk";
    public static final String FILENAME = "vehicule";


    ArrayList<Vehicule> listVehicles;
    ArrayAdapter<Vehicule> vehiclesArrayAdapter;
    ListView listViewVehicles;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        initialize();
    }

    private void initialize() {
        listVehicles = new ArrayList<>();
        listViewVehicles = findViewById(R.id.listView);
        listViewVehicles.setOnItemClickListener(this);
        drawerLayout = findViewById(R.id.drawerLayout);
        listVehicles = VehiculeFileManagement.readFile(this,FILENAME);
        vehiclesArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listVehicles);
        listViewVehicles.setAdapter(vehiclesArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY,listVehicles.get(position));

        //REPLACE THE LINEAR LAYOUT WITH FRAGMENT
        if (listVehicles.get(position) instanceof Bike){
            BikeFragment bikeFragment = new BikeFragment();
            bikeFragment.setArguments(bundle);
            buildFragment(bikeFragment);

        }else{
            CarFragment carFragment = new CarFragment();
            carFragment.setArguments(bundle);
            buildFragment(carFragment);
        }
        setTitle(listVehicles.get(position).getBrand());
        drawerLayout.closeDrawer(listViewVehicles);
    }


    private void buildFragment(android.app.Fragment fragment){
        //REFERENCE THE FRAGMENT MANAGER
        android.app.FragmentManager fragmentManager = getFragmentManager();
        //BEGIN THE TRANSACTION
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //REPLACE LINEAR LAYOUT MAIN_UI WITH THE FRAGMENT
//        fragmentTransaction.detach(fragment).attach(fragment);
        fragmentTransaction.replace(R.id.one_item,fragment);
        fragmentTransaction.commit();

    }


}
