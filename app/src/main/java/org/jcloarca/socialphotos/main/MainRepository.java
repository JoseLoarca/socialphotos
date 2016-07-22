package org.jcloarca.socialphotos.main;

import android.location.Location;

/**
 * Created by JCLoarca on 7/21/2016 9:50 PM.
 */
public interface MainRepository {
    void logout();
    void uploadPhoto(Location location, String path);
}
