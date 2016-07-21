package org.jcloarca.socialphotos.libs.base;

/**
 * Created by JCLoarca on 7/20/2016 11:24 PM.
 */
public interface ImageStorageFinishedListener {
    void onSuccess();
    void onError(String error);
}
