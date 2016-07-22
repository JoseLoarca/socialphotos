package org.jcloarca.socialphotos.photolist;

import org.jcloarca.socialphotos.entities.Photo;

/**
 * Created by JCLoarca on 7/21/2016 10:55 PM.
 */
public interface PhotoListRepository {
    void subscribe();
    void unsubscribe();
    void remove(Photo photo);
}