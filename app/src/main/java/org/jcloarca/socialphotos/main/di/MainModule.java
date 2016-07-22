package org.jcloarca.socialphotos.main.di;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.jcloarca.socialphotos.domain.FirebaseAPI;
import org.jcloarca.socialphotos.libs.base.EventBus;
import org.jcloarca.socialphotos.libs.base.ImageStorage;
import org.jcloarca.socialphotos.main.MainPresenter;
import org.jcloarca.socialphotos.main.MainPresenterImpl;
import org.jcloarca.socialphotos.main.MainRepository;
import org.jcloarca.socialphotos.main.MainRepositoryImpl;
import org.jcloarca.socialphotos.main.SessionInteractor;
import org.jcloarca.socialphotos.main.SessionInteractorImpl;
import org.jcloarca.socialphotos.main.UploadInteractor;
import org.jcloarca.socialphotos.main.UploadInteractorImpl;
import org.jcloarca.socialphotos.main.ui.MainView;
import org.jcloarca.socialphotos.main.ui.adapters.MainSectionsPagerAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JCLoarca on 7/21/2016 10:27 PM.
 */
@Module
public class MainModule {
    private MainView view;
    private String[] titles;
    private Fragment[] fragments;
    private FragmentManager fragmentManager;

    public MainModule(MainView view, FragmentManager fragmentManager, Fragment[] fragments, String[] titles) {
        this.view = view;
        this.titles = titles;
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
    }

    @Provides
    @Singleton
    MainView providesMainView() {
        return this.view;
    }

    @Provides
    @Singleton
    MainPresenter providesMainPresenter(MainView view, EventBus eventBus, UploadInteractor uploadInteractor, SessionInteractor sessionInteractor) {
        return new MainPresenterImpl(view, eventBus, uploadInteractor, sessionInteractor);
    }

    @Provides
    @Singleton
    UploadInteractor providesUploadInteractor(MainRepository repository) {
        return new UploadInteractorImpl(repository);
    }

    @Provides
    @Singleton
    SessionInteractor providesSessionInteractor(MainRepository repository) {
        return new SessionInteractorImpl(repository);
    }

    @Provides
    @Singleton
    MainRepository providesMainRepository(EventBus eventBus, FirebaseAPI firebase, ImageStorage imageStorage) {
        return new MainRepositoryImpl(eventBus, firebase, imageStorage);
    }

    @Provides
    @Singleton
    MainSectionsPagerAdapter providesAdapter(FragmentManager fm, Fragment[] fragments, String[] titles) {
        return new MainSectionsPagerAdapter(fm, fragments, titles);
    }

    @Provides
    @Singleton
    FragmentManager providesAdapterFragmentManager() {
        return this.fragmentManager;
    }

    @Provides
    @Singleton
    Fragment[] providesFragmentArrayForAdapter() {
        return this.fragments;
    }

    @Provides
    @Singleton
    String[] providesStringArrayForAdapter() {
        return this.titles;
    }

}
