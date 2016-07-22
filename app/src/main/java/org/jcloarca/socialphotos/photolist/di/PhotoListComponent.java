package org.jcloarca.socialphotos.photolist.di;

import org.jcloarca.socialphotos.SocialPhotosAppModule;
import org.jcloarca.socialphotos.domain.di.DomainModule;
import org.jcloarca.socialphotos.libs.di.LibsModule;
import org.jcloarca.socialphotos.photolist.ui.PhotoListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JCLoarca on 7/21/2016 10:56 PM.
 */
@Singleton
@Component(modules = {PhotoListModule.class, DomainModule.class, LibsModule.class, SocialPhotosAppModule.class})
public interface PhotoListComponent {
    void inject(PhotoListFragment fragment);
}
