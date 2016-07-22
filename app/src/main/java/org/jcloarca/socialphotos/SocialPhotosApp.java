package org.jcloarca.socialphotos;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.firebase.client.Firebase;

import org.jcloarca.socialphotos.domain.di.DomainModule;
import org.jcloarca.socialphotos.libs.di.LibsModule;
import org.jcloarca.socialphotos.login.di.DaggerLoginComponent;
import org.jcloarca.socialphotos.login.di.LoginComponent;
import org.jcloarca.socialphotos.login.di.LoginModule;
import org.jcloarca.socialphotos.login.ui.LoginView;
import org.jcloarca.socialphotos.main.di.DaggerMainComponent;
import org.jcloarca.socialphotos.main.di.MainComponent;
import org.jcloarca.socialphotos.main.di.MainModule;
import org.jcloarca.socialphotos.main.ui.MainView;
import org.jcloarca.socialphotos.photolist.di.DaggerPhotoListComponent;
import org.jcloarca.socialphotos.photolist.di.PhotoListComponent;
import org.jcloarca.socialphotos.photolist.di.PhotoListModule;
import org.jcloarca.socialphotos.photolist.ui.PhotoListView;
import org.jcloarca.socialphotos.photolist.ui.adapters.OnItemClickListener;
import org.jcloarca.socialphotos.photomap.di.DaggerPhotoMapComponent;
import org.jcloarca.socialphotos.photomap.di.PhotoMapComponent;
import org.jcloarca.socialphotos.photomap.di.PhotoMapModule;
import org.jcloarca.socialphotos.photomap.ui.PhotoMapView;

/**
 * Created by JCLoarca on 7/20/2016 10:44 PM.
 */
public class SocialPhotosApp extends Application {
    private final static String EMAIL_KEY = "email";
    private LibsModule libsModule;
    private DomainModule domainModule;
    private SocialPhotosAppModule socialPhotosAppModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        libsModule = new LibsModule();
        domainModule = new DomainModule();
        socialPhotosAppModule = new SocialPhotosAppModule(this);
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }

    public static String getEmailKey() {
        return EMAIL_KEY;
    }

    public PhotoListComponent getPhotoListComponent(Fragment fragment, PhotoListView view, OnItemClickListener onItemClickListener) {
        libsModule.setFragment(fragment);

        return DaggerPhotoListComponent
                .builder()
                .socialPhotosAppModule(socialPhotosAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .photoListModule(new PhotoListModule(view, onItemClickListener))
                .build();

    }

    public PhotoMapComponent getPhotoMapComponent(Fragment fragment, PhotoMapView view) {
        libsModule.setFragment(fragment);

        return DaggerPhotoMapComponent
                .builder()
                .socialPhotosAppModule(socialPhotosAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .photoMapModule(new PhotoMapModule(view))
                .build();

    }

    public MainComponent getMainComponent(MainView view, FragmentManager manager, Fragment[]fragments, String[] titles) {
        return DaggerMainComponent
                .builder()
                .socialPhotosAppModule(socialPhotosAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .mainModule(new MainModule(view, manager, fragments, titles))
                .build();
    }

    public LoginComponent getLoginComponent(LoginView view) {
        return DaggerLoginComponent
                .builder()
                .socialPhotosAppModule(socialPhotosAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .loginModule(new LoginModule(view))
                .build();

    }


}
