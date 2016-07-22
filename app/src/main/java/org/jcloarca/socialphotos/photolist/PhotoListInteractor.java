package org.jcloarca.socialphotos.photolist;

import org.jcloarca.socialphotos.entities.Photo;

/**
 * Created by JCLoarca on 7/21/2016 10:53 PM.
 */
public interface PhotoListInteractor {
    void subscribe();
    void unsubscribe();
    void removePhoto(Photo photo);
}
