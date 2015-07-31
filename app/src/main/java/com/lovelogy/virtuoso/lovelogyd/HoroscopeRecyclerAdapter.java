package com.lovelogy.virtuoso.lovelogyd;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Virtuoso on 7/14/2015.
 */
public class HoroscopeRecyclerAdapter extends RecyclerView.Adapter<HoroScopeListRowHolder> {


    private List<FeedItem> feedItemList;

    private Context mContext;

    public HoroscopeRecyclerAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public HoroScopeListRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horoscope_list_row, null);
        HoroScopeListRowHolder horoScopeListRowHolder = new HoroScopeListRowHolder(v);

        return horoScopeListRowHolder;
    }

    @Override
    public void onBindViewHolder(HoroScopeListRowHolder feedListRowHolder, int i) {
        FeedItem feedItem = feedItemList.get(i);

        /*Picasso.with(mContext).load(feedItem.getThumbnail())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(feedListRowHolder.thumbnail);*/
        String value = feedItem.getThumbnail();

        String[] data = value.split(":");

        String sunsign = data[0];
        String info = data[1];


        if(sunsign.equalsIgnoreCase("Aquarius")){

            feedListRowHolder.thumbnail.setImageResource(R.drawable.aquarius);
        }else  if(sunsign.equalsIgnoreCase("Aries")){

            feedListRowHolder.thumbnail.setImageResource(R.drawable.aries);
        }else  if(sunsign.equalsIgnoreCase("Taurus")){
            feedListRowHolder.thumbnail.setImageResource(R.drawable.taurus);

        }else  if(sunsign.equalsIgnoreCase("Gemini")){
            feedListRowHolder.thumbnail.setImageResource(R.drawable.gemini);

        }else  if(sunsign.equalsIgnoreCase("Cancer")){
            feedListRowHolder.thumbnail.setImageResource(R.drawable.cancer);

        }else  if(sunsign.equalsIgnoreCase("Leo")){
            feedListRowHolder.thumbnail.setImageResource(R.drawable.leo);

        }else  if(sunsign.equalsIgnoreCase("Virgo")){
            feedListRowHolder.thumbnail.setImageResource(R.drawable.virgo);

        }else  if(sunsign.equalsIgnoreCase("Libra")){
            feedListRowHolder.thumbnail.setImageResource(R.drawable.libra);

        }else  if(sunsign.equalsIgnoreCase("Scorpio")){

            feedListRowHolder.thumbnail.setImageResource(R.drawable.scorpion);
        }else  if(sunsign.equalsIgnoreCase("Sagittarius")){
            feedListRowHolder.thumbnail.setImageResource(R.drawable.sagittarius);

        }else  if(sunsign.equalsIgnoreCase("Capricorn")){

            feedListRowHolder.thumbnail.setImageResource(R.drawable.capricorn);
        }else{
            feedListRowHolder.thumbnail.setImageResource(R.drawable.pisces);
        }
            //  feedListRowHolder.thumbnail.setText(Html.fromHtml(feedItem.getThumbnail()));
        feedListRowHolder.horoscopetitle.setText(Html.fromHtml(data[0]));
        feedListRowHolder.horoscopetext.setText(Html.fromHtml(data[1]));
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }
}