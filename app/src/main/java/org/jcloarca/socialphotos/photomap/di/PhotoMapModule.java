package org.jcloarca.socialphotos.photomap.di;

import org.jcloarca.socialphotos.domain.FirebaseAPI;
import org.jcloarca.socialphotos.libs.base.EventBus;
import org.jcloarca.socialphotos.photomap.PhotoMapInteractor;
import org.jcloarca.socialphotos.photomap.PhotoMapInteractorImpl;
import org.jcloarca.socialphotos.photomap.PhotoMapPresenter;
import org.jcloarca.socialphotos.photomap.PhotoMapPresenterImpl;
import org.jcloarca.socialphotos.photomap.PhotoMapRepository;
import org.jcloarca.socialphotos.photomap.PhotoMapRepositoryImpl;
import org.jcloarca.socialphotos.photomap.ui.PhotoMapView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JCLoarca on 7/22/2016 12:47 AM.
 */
@Module
public class PhotoMapModule {
    PhotoMapView view;

    public PhotoMapModule(PhotoMapView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    PhotoMapView providesPhotoContentView() {
        return this.view;
    }

    @Provides
    @Singleton
    PhotoMapPresenter providesPhotoContentPresenter(EventBus eventBus, PhotoMapView view, PhotoMapInteractor listInteractor) {
        return new PhotoMapPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides
    @Singleton
    PhotoMapInteractor providesPhotoContentInteractor(PhotoMapRepository repository) {
        return new PhotoMapInteractorImpl(repository);
    }

    @Provides
    @Singleton
    PhotoMapRepository providesPhotoContentRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoMapRepositoryImpl(firebase, eventBus);
    }
}
