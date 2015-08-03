package com.lovelogy.virtuoso.lovegyan;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lovelogy.virtuoso.lovelogyd.R;

/**
 * Created by Virtuoso on 7/16/2015.
 */
public class LoveGyanListRowHolder extends RecyclerView.ViewHolder {
    protected ImageView thumbnail;


    public LoveGyanListRowHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.image_quote);

    }

}