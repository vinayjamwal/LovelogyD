package com.lovelogy.virtuoso.lovelogyd;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Virtuoso on 7/8/2015.
 */
public class LoveGyan extends Fragment {

    private static final String TAG = "Lovelogy";
    private List<FeedItem> feedItemList = new ArrayList<FeedItem>();
    private RecyclerView mRecyclerView;
    //private MyRecyclerAdapter adapter;
    private LoveGyanRecylerAdapter adapter;
    private ProgressDialog pd;
    //private SwipeRefreshLayout swipe;
    private int offSet = 0;
    int foo;
    private NetworkUtil networkUtil;
    private boolean conn;
    String url;


    public LoveGyan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.activity_feeds_list,container,false);

        /* Initialize recyclerview */
        mRecyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //swipe=(SwipeRefreshLayout)v.findViewById(R.id.swipe_refresh_layout);

        networkUtil=new NetworkUtil();
        conn=networkUtil.checkNow(getActivity());

       url = "http://122.176.20.125/Loveology/lovology_Images.jsp";

       /* swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);

                           new AsyncHttpTask().execute(url);

                       }
                   }
        );*/


        if(conn==true) {

            new AsyncHttpTask().execute(url);
        }else{

            new MaterialDialog.Builder(getActivity())
                    .title("Alert")
                    .content("Please check yout interney connectivity")
                    .positiveText("Done")
                    .show();
        }

        return v;
    }


    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            // setProgressBarIndeterminateVisibility(true);
            pd= ProgressDialog.show(getActivity(),"Please Wait","");
        }

        @Override
        protected Integer doInBackground(String... params) {
            InputStream inputStream = null;
            Integer result = 0;
            HttpURLConnection urlConnection = null;

            try {
                /* forming th java.net.URL object */
                URL url = new URL(params[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                /* for Get request */
                urlConnection.setRequestMethod("GET");

                int statusCode = urlConnection.getResponseCode();

                /* 200 represents HTTP OK */
                if (statusCode ==  200) {

                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }

                    parseResult(response.toString());



                    result = 1; // Successful
                }else{
                    result = 0; //"Failed to fetch data!";
                }

            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }

            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {

            //setProgressBarIndeterminateVisibility(false);

            pd.dismiss();

            /* Download complete. Lets update UI */
            if (result == 1) {

                //adapter = new MyRecyclerAdapter(getActivity(), feedItemList);
                adapter = new LoveGyanRecylerAdapter(getActivity(), feedItemList);
                mRecyclerView.setAdapter(adapter);


               // swipe.setRefreshing(false);

            } else {
                Log.e(TAG, "Failed to fetch data!");
            }
        }
    }

    private void parseResult(String result) {
        try {
            JSONObject response = new JSONObject(result);
            JSONArray posts = response.optJSONArray("Images");

            /*Initialize array if null*/
            if (null == feedItemList) {
                feedItemList = new ArrayList<FeedItem>();
            }

            for (int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.optJSONObject(i);

                FeedItem item = new FeedItem();
                item.setTitle(post.optString("SrNo"));
                item.setThumbnail(post.optString("Link"));

                 foo = Integer.parseInt(item.getTitle());
                if (foo >= offSet)
                    offSet = foo;

                feedItemList.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
