package com.lovelogy.virtuoso.lovelogyd;

/**
 * Created by Virtuoso on 8/4/2015.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suleiman on 26-07-2015.
 */
public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView> {

    List<Items> list = new ArrayList<Items>();
    private Context context;
    private ClickListener clickListener;

    /*int[] imgList = {R.drawable.two, R.drawable.one, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten};
    String[] nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"};
*/
    public MasonryAdapter(Context context, List<Items> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        MasonryView masonryView = new MasonryView(layoutView);
        return masonryView;
    }

    @Override
    public void onBindViewHolder(MasonryView holder, final int position) {

        // holder.imageView.setImageResource(imgList[position]);
        // holder.textView.setText(nameList[position]);
        holder.imageView.setImageResource(list.get(position).getImages());
        holder.textView.setText(list.get(position).getNames());

        list.get(position).getImages();
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(context, "" + list.get(position).getNames(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //return nameList.length;

        return list.size();
    }

    /* Setter for listener. */
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    /* Interface for handling clicks - both normal and long ones. */
    public interface ClickListener {

        /**
         * Called when the view is clicked.
         *
         * @param v           view that is clicked
         * @param position    of the clicked item
         * @param isLongClick true if long click, false otherwise
         */
        void onClick(View v, int position, boolean isLongClick);

    }

    class MasonryView extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.img);
            textView = (TextView) itemView.findViewById(R.id.img_name);


            // itemView.setOnClickListener(this);
            //  itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            // If long clicked, passed last variable as true.
            clickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }


}