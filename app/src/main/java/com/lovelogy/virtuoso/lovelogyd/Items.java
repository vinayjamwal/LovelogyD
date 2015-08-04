package com.lovelogy.virtuoso.lovelogyd;

/**
 * Created by Virtuoso on 8/4/2015.
 */
public class Items {

    int images;
    String names;

    public Items(int images, String names) {
        this.images = images;
        this.names = names;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}