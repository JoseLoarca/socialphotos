package org.jcloarca.socialphotos.photolist.di;

import org.jcloarca.socialphotos.domain.FirebaseAPI;
import org.jcloarca.socialphotos.domain.Util;
import org.jcloarca.socialphotos.entities.Photo;
import org.jcloarca.socialphotos.libs.base.EventBus;
import org.jcloarca.socialphotos.libs.base.ImageLoader;
import org.jcloarca.socialphotos.photolist.PhotoListInteractor;
import org.jcloarca.socialphotos.photolist.PhotoListInteractorImpl;
import org.jcloarca.socialphotos.photolist.PhotoListPresenter;
import org.jcloarca.socialphotos.photolist.PhotoListPresenterImpl;
import org.jcloarca.socialphotos.photolist.PhotoListRepository;
import org.jcloarca.socialphotos.photolist.PhotoListRepositoryImpl;
import org.jcloarca.socialphotos.photolist.ui.PhotoListView;
import org.jcloarca.socialphotos.photolist.ui.adapters.OnItemClickListener;
import org.jcloarca.socialphotos.photolist.ui.adapters.PhotoListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JCLoarca on 7/21/2016 10:57 PM.
 */
@Module
public class PhotoListModule {
    PhotoListView view;
    OnItemClickListener onItemClickListener;

    public PhotoListModule(PhotoListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides
    @Singleton
    PhotoListView providesPhotoContentView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoListPresenter providesPhotoListPresenter(EventBus eventBus, PhotoListView view, PhotoListInteractor listInteractor) {
        return new PhotoListPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoListInteractor providesPhotoListInteractor(PhotoListRepository repository) {
        return new PhotoListInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoListRepository providesPhotoListRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoListRepositoryImpl(firebase, eventBus);
    }

    @Provides @Singleton
    PhotoListAdapter providesPhotosAdapter(Util utils, List<Photo> photoList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new PhotoListAdapter(utils, photoList, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides @Singleton
    List<Photo> providesPhotosList() {
        return new ArrayList<Photo>();
    }

}
