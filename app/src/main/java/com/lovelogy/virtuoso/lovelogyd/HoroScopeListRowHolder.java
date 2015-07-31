package com.lovelogy.virtuoso.lovelogyd;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Virtuoso on 7/14/2015.
 */
public class HoroScopeListRowHolder extends RecyclerView.ViewHolder {
    protected ImageView thumbnail;
    protected TextView horoscopetitle,horoscopetext;

    public HoroScopeListRowHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.horoscope_sign);
        this.horoscopetitle = (TextView) view.findViewById(R.id.horoscope_text);
        this.horoscopetext = (TextView) view.findViewById(R.id.hoscope_predication_text);
    }

}