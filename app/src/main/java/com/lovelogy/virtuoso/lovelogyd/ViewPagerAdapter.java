package com.lovelogy.virtuoso.lovelogyd;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
/**
 * Created by Virtuoso on 7/2/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[];
    int NumbOfTabs;


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            Romance tab1 = new Romance();
            return tab1;
        }
        else if(position == 1)           // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Friendship tab2 = new Friendship();
            return tab2;
        }
        else if(position == 2)
        {
            Inspiration tab3 = new Inspiration();
            return tab3;
        }else if(position == 3){

            Motivation tab4=new Motivation();
            return tab4;
        }

        else{

            Broken tab4=new Broken();
            return tab4;
        }
    }


    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}