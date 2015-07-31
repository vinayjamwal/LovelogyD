package com.lovelogy.virtuoso.lovelogyd;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Virtuoso on 7/8/2015.
 */
public class FeedListRowHolder extends RecyclerView.ViewHolder {
    //  protected ImageView thumbnail;
    protected TextView title,thumbnail;

    public FeedListRowHolder(View view) {
        super(view);
        // this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        this.thumbnail = (TextView) view.findViewById(R.id.thumbnail);
        this.title = (TextView) view.findViewById(R.id.title);
    }

}