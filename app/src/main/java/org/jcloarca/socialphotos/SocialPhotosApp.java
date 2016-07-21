package org.jcloarca.socialphotos;

import android.app.Application;

import com.firebase.client.Firebase;

import org.jcloarca.socialphotos.domain.di.DomainModule;

/**
 * Created by JCLoarca on 7/20/2016 10:44 PM.
 */
public class SocialPhotosApp extends Application {
    private final static String EMAIL_KEY = "email";
    private final static String SHARED_PREFERENCES_NAME = "UserPrefs";
    private final static String FIREBASE_URL = "https://androidphotofeed.firebaseio.com/";

    private DomainModule domainModule;
    private SocialPhotosAppModule socialPhotosAppModule;
    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        socialPhotosAppModule = new SocialPhotosAppModule(this);
        domainModule = new DomainModule(FIREBASE_URL);
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }

    public String getEmailKey() {
        return EMAIL_KEY;
    }

    public String getSharedPreferencesName() {
        return SHARED_PREFERENCES_NAME;
    }

    public String getFirebaseUrl() {
        return FIREBASE_URL;
    }
}
