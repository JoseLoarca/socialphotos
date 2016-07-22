package org.jcloarca.socialphotos.photomap;

import org.jcloarca.socialphotos.photomap.events.PhotoMapEvent;

/**
 * Created by JCLoarca on 7/21/2016 11:37 PM.
 */
public interface PhotoMapPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void onEventMainThread(PhotoMapEvent event);
}
