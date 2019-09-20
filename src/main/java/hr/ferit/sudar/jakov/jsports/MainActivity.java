package hr.ferit.sudar.jakov.jsports;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements ItemClickListener, ButtonClickListener{
    ActionBarDrawerToggle drawerToggle;

    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList <String> arrayList = new ArrayList<>();
    TextView title;
    FragmentManager fragmentManager;
    HomeFragment homeFragment;
    InfoFragment infoFragment;

    Random r ;

    private static final String RANDOM = "random";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        drawerLayout = findViewById(R.id.drawer_layout);
        recyclerView.setHasFixedSize(true);
        homeFragment = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        r = new Random();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.rlFragment,homeFragment);
        fragmentTransaction.commit();


        String[] items = getResources().getStringArray(R.array.options);
        for(String Item : items){
            arrayList.add(Item);
        }

        adapter = new RecyclerAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close){

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void OnItemClick(final int position) {
        Log.d("Sudo", "Pozicija je: " + position);
        setInfoFragment(position);
        drawerLayout.closeDrawers();
    }

    @Override
    public void OnButtonClick(String ID) {
        Log.d("ID"," "+ID);
        switch (ID){
            case "random" : setInfoFragment(getRandomSport());break;
            case "home" :   setHomeFragment();break;
            case "menu" :  openDrawer();break;
        }
    }

    void openDrawer(){
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.openDrawer(Gravity.START);
    }

    void setHomeFragment(){
        homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_in_left);
        fragmentTransaction.replace(R.id.rlFragment,homeFragment);
        fragmentTransaction.commit();
    }

    void setInfoFragment(int position){
        infoFragment = new InfoFragment();
        Bundle arg = new Bundle();
        arg.putInt("position", position);
        infoFragment.setArguments(arg);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_in_left);
        fragmentTransaction.replace(R.id.rlFragment,infoFragment);
        fragmentTransaction.commit();
    }


    int getRandomSport(){
        int sport= r.nextInt(21);
        return sport;
    }
}

