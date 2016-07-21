package org.jcloarca.socialphotos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JCLoarca on 7/20/2016 10:53 PM.
 */
@Module
public class SocialPhotosAppModule {
    Application application;
    private final static String SHARED_PREFERENCES_NAME = "UserPrefs";

    public SocialPhotosAppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return application.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Context providesContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }
}
