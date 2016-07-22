package org.jcloarca.socialphotos.photolist;

import org.jcloarca.socialphotos.entities.Photo;
import org.jcloarca.socialphotos.photolist.events.PhotoListEvent;

/**
 * Created by JCLoarca on 7/21/2016 10:54 PM.
 */
public interface PhotoListPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void removePhoto(Photo photo);
    void onEventMainThread(PhotoListEvent event);
}
