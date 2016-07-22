package org.jcloarca.socialphotos.photolist.ui;

import org.jcloarca.socialphotos.entities.Photo;

/**
 * Created by JCLoarca on 7/21/2016 10:56 PM.
 */
public interface PhotoListView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
