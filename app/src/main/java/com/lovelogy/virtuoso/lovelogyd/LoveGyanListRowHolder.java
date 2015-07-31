package com.lovelogy.virtuoso.lovelogyd;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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