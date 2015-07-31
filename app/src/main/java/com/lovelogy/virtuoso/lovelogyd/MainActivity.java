package com.lovelogy.virtuoso.lovelogyd;


import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Virtuoso on 7/8/2015.
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

private Toolbar mToolbar;
private DrawerLayout mDrawerLayout;
private ActionBarDrawerToggle mDrawerToggle;
private ListView mLvDrawerMenu;
private TextView mTitle;
ViewPagerAdapter adapter;
private DrawerMenuItemAdapter mDrawerMenuAdapter;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    mTitle = (TextView) mToolbar.findViewById(R.id.toolbar_title);

        /*mTitle.setText("Love Quote");
        mTitle.setText("Love Gyan");
        mTitle.setText("Horoscope");
        mTitle.setText("Love Meter");*/


//        mDrawerMenuItem =new DrawerMenuItem[4];
//
//        mDrawerMenuItem[0]=new DrawerMenuItem("LoveQuotes");
//        mDrawerMenuItem[1]=new DrawerMenuItem("LoveGyan");
//        mDrawerMenuItem[2]=new DrawerMenuItem("Horoscope");
//        mDrawerMenuItem[3]=new DrawerMenuItem("LoveMeter");

    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    mLvDrawerMenu = (ListView) findViewById(R.id.lv_drawer_menu);

        /*List<String> arrayOfUsers = new ArrayList<String>();
        arrayOfUsers.add("LoveQuotes");
        arrayOfUsers.add("LoveGyan");
        arrayOfUsers.add("Horoscope");
        arrayOfUsers.add("LoveMeter");

        DrawerMenuItemAdapter adapter = new DrawerMenuItemAdapter(this,arrayOfUsers);

        mLvDrawerMenu.setAdapter(adapter);*/

    List<DrawerMenuItem> menuItems = generateDrawerMenuItems();
    mDrawerMenuAdapter = new DrawerMenuItemAdapter(getApplicationContext(), menuItems);
    mLvDrawerMenu.setAdapter(mDrawerMenuAdapter);

    mLvDrawerMenu.setOnItemClickListener(this);

    mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name) {
        public void onDrawerClosed(View view) {
            invalidateOptionsMenu();
        }

        public void onDrawerOpened(View drawerView) {
            invalidateOptionsMenu();
        }
    };
    mDrawerLayout.setDrawerListener(mDrawerToggle);

    if(savedInstanceState == null){
        setFragment(0, MainLoveClass.class);
        mTitle.setText("Love Quote");
    }
}

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:

                setFragment(0, MainLoveClass.class);
                mTitle.setText("Love Quote");

                break;
            case 1:
                setFragment(1, LoveGyan.class);
                mTitle.setText("Love Gyan");
                break;
            case 2:
                setFragment(2, Horoscope.class);
                mTitle.setText("Horoscope");

                break;
            case 3:
                setFragment(3, LoveMeter.class);
                mTitle.setText("LoveMeter");
                break;
            case 4:
                mDrawerLayout.closeDrawer(mLvDrawerMenu);
                mLvDrawerMenu.invalidateViews();
                break;
            case 5:
                mDrawerLayout.closeDrawer(mLvDrawerMenu);
                mLvDrawerMenu.invalidateViews();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(mLvDrawerMenu)) {
            mDrawerLayout.closeDrawer(mLvDrawerMenu);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public void setFragment(int position, Class<? extends Fragment> fragmentClass) {
        try {
            Fragment fragment = fragmentClass.newInstance();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_container, fragment, fragmentClass.getSimpleName());
            fragmentTransaction.commit();

            mLvDrawerMenu.setItemChecked(position, true);
            mDrawerLayout.closeDrawer(mLvDrawerMenu);
            mLvDrawerMenu.invalidateViews();
        }
        catch (Exception ex){
            Log.e("setFragment", ex.getMessage());
        }
    }

    private List<DrawerMenuItem> generateDrawerMenuItems() {
        String[] itemsText = getResources().getStringArray(R.array.nav_drawer_items);
        List<DrawerMenuItem> result = new ArrayList<DrawerMenuItem>();
        for (int i = 0; i < itemsText.length; i++) {
            DrawerMenuItem item = new DrawerMenuItem();
            item.setText(itemsText[i]);
            result.add(item);
        }
        return result;
    }

}
