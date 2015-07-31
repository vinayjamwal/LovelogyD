package com.lovelogy.virtuoso.lovelogyd;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Virtuoso on 7/16/2015.
 */

public class LoveGyanRecylerAdapter extends RecyclerView.Adapter<LoveGyanListRowHolder> {


        private List<FeedItem> feedItemList;

        private Context mContext;

        public LoveGyanRecylerAdapter(Context context, List<FeedItem> feedItemList) {
            this.feedItemList = feedItemList;
            this.mContext = context;
        }

        @Override
        public LoveGyanListRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.love_gyan_list_row, null);

            LoveGyanListRowHolder mh = new LoveGyanListRowHolder(v);

            return mh;
        }

        @Override
        public void onBindViewHolder(LoveGyanListRowHolder loveGyanListRowHolder, int i) {
            FeedItem feedItem = feedItemList.get(i);

       /* Picasso.with(mContext).load(feedItem.getThumbnail()).error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(loveGyanListRowHolder.thumbnail);*/

            DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
            int width = metrics.widthPixels;
            int height = metrics.heightPixels / 2;

            Picasso.with(mContext)
                    .load(feedItem.getThumbnail()).error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .resize(width, height)
                    .centerInside()
                    .into(loveGyanListRowHolder.thumbnail);

           /* Picasso.with(mContext).load(feedItem.getThumbnail()).error(R.drawable.placeholder)
                    .resize(250,300)
                    .centerCrop()
                    .into(loveGyanListRowHolder.thumbnail);*/


        }

        @Override
        public int getItemCount() {
            return (null != feedItemList ? feedItemList.size() : 0);
        }
    }