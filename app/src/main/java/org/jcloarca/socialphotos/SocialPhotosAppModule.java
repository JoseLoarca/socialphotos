package org.jcloarca.socialphotos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by JCLoarca on 7/20/2016 10:53 PM.
 */
public class SocialPhotosAppModule {
    SocialPhotosApp app;

    public SocialPhotosAppModule(SocialPhotosApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application){
        return application.getSharedPreferences(app.getSharedPreferencesName(), Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    SocialPhotosApp providesApplication(){
        return this.app;
    }
}
