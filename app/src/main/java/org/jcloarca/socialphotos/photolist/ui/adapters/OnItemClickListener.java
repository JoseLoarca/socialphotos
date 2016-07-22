package org.jcloarca.socialphotos.photolist.ui.adapters;

import android.widget.ImageView;

import org.jcloarca.socialphotos.entities.Photo;

/**
 * Created by JCLoarca on 7/21/2016 10:45 PM.
 */
public interface OnItemClickListener {
    void onPlaceClick(Photo photo);
    void onShareClick(Photo photo, ImageView img);
    void onDeleteClick(Photo photo);
}
