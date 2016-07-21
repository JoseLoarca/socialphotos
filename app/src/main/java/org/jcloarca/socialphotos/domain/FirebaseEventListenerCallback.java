package org.jcloarca.socialphotos.domain;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;

/**
 * Created by JCLoarca on 7/20/2016 10:04 PM.
 */
public interface FirebaseEventListenerCallback {
    void onChildAdded(DataSnapshot snapshot);
    void onChildRemoved(DataSnapshot snapshot);
    void onCancelled(FirebaseError error);
}
