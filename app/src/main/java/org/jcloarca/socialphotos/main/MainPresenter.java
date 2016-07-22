package org.jcloarca.socialphotos.main;

import android.location.Location;

import org.jcloarca.socialphotos.main.events.MainEvent;

/**
 * Created by JCLoarca on 7/21/2016 9:39 PM.
 */
public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void logout();
    void uploadPhoto(Location location, String path);
    void onEventMainThread(MainEvent event);
}
