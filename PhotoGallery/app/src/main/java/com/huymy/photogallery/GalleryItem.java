package com.huymy.photogallery;

import androidx.annotation.NonNull;

public class GalleryItem {
    private String mCaption;
    private String mId;
    private String mUrl;

    @NonNull
    @Override
    public String toString() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public void setId(String id) {
        mId = id;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
