package org.jcloarca.socialphotos.libs.base;

import java.io.File;

/**
 * Created by JCLoarca on 7/20/2016 11:23 PM.
 */
public interface ImageStorage {
    String getImageUrl(String id);
    void upload(File file, String id, ImageStorageFinishedListener listener);
}
