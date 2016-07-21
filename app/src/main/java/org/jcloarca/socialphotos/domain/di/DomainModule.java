package org.jcloarca.socialphotos.domain.di;

import android.content.Context;
import android.location.Geocoder;

import com.firebase.client.Firebase;

import org.jcloarca.socialphotos.domain.FirebaseAPI;
import org.jcloarca.socialphotos.domain.Util;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JCLoarca on 7/20/2016 11:05 PM.
 */

@Module
public class DomainModule {
    private final static String FIREBASE_URL = "https://androidphotofeed.firebaseio.com/";

    @Provides
    @Singleton
    FirebaseAPI providesFirebaseAPI(Firebase firebase) {
        return new FirebaseAPI(firebase);
    }

    @Provides
    @Singleton
    Firebase providesFirebase() {
        return new Firebase(FIREBASE_URL);
    }

    @Provides
    @Singleton
    Util providesUtil(Geocoder geocoder) {
        return new Util(geocoder);
    }

    @Provides
    @Singleton
    Geocoder providesGeocoder(Context context) {
        return new Geocoder(context);
    }
}
