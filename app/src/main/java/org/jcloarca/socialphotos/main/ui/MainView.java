package org.jcloarca.socialphotos.main.ui;

/**
 * Created by JCLoarca on 7/21/2016 9:38 PM.
 */
public interface MainView {
    void onUploadInit();
    void onUploadComplete();
    void onUploadError(String error);
}
