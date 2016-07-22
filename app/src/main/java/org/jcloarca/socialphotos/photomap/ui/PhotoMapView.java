package org.jcloarca.socialphotos.photomap.ui;

import org.jcloarca.socialphotos.entities.Photo;

/**
 * Created by JCLoarca on 7/22/2016 12:48 AM.
 */
public interface PhotoMapView {
    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
