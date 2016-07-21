package org.jcloarca.socialphotos.libs.di;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.bumptech.glide.RequestManager;

import org.jcloarca.socialphotos.libs.CloudinaryImageStorage;
import org.jcloarca.socialphotos.libs.GlideImageLoader;
import org.jcloarca.socialphotos.libs.GreenRobotEventBus;
import org.jcloarca.socialphotos.libs.base.EventBus;
import org.jcloarca.socialphotos.libs.base.ImageLoader;
import org.jcloarca.socialphotos.libs.base.ImageStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JCLoarca on 7/20/2016 11:25 PM.
 */
@Module
public class LibsModule {
    private Fragment fragment;

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    EventBus providesEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader(Fragment fragment) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (fragment != null) {
            imageLoader.setLoaderContext(fragment);
        }
        return imageLoader;
    }

    @Provides
    @Singleton
    ImageStorage providesImageStorage(Context context, EventBus eventBus) {
        ImageStorage imageStorage = new CloudinaryImageStorage(context, eventBus);
        return imageStorage;
    }

    @Provides
    @Singleton
    Fragment providesFragment(){
        return this.fragment;
    }

}
