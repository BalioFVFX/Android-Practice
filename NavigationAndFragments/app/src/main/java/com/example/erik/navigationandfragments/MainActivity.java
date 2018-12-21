package com.example.erik.navigationandfragments;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout mDraweLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        this.getSupportFragmentManager().beginTransaction().add(R.id.content_frame, new HomeFragment()).commit();
        navigation();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24px);
    }

    private void navigation(){
        NavigationView navigationView = (NavigationView)this.findViewById(R.id.nav_view);
        this.mDraweLayout = this.findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch(menuItem.getItemId()){
                case R.id.home_item:
                    this.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new HomeFragment()).commit();
                    this.mDraweLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.detail_item:
                    this.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new ListFragment()).commit();
                    this.mDraweLayout.closeDrawer(GravityCompat.START);
                    default:
                        this.mDraweLayout.closeDrawer(GravityCompat.START);
                        break;
            }
            return true;
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home:
                mDraweLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
