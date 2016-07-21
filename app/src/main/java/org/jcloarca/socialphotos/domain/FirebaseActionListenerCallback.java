package org.jcloarca.socialphotos.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by JCLoarca on 7/20/2016 10:03 PM.
 */
public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
