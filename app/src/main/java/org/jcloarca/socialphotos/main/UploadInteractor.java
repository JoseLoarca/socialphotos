package org.jcloarca.socialphotos.main;

import android.location.Location;

/**
 * Created by JCLoarca on 7/21/2016 9:40 PM.
 */
public interface UploadInteractor {
    void execute(Location location, String path);
}
