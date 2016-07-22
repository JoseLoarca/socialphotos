package org.jcloarca.socialphotos.photomap.di;

import org.jcloarca.socialphotos.SocialPhotosAppModule;
import org.jcloarca.socialphotos.domain.di.DomainModule;
import org.jcloarca.socialphotos.libs.di.LibsModule;
import org.jcloarca.socialphotos.photomap.ui.PhotoMapFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JCLoarca on 7/22/2016 12:46 AM.
 */
@Singleton
@Component(modules = {PhotoMapModule.class, DomainModule.class, LibsModule.class, SocialPhotosAppModule.class})
public interface PhotoMapComponent {
    void inject(PhotoMapFragment fragment);
}