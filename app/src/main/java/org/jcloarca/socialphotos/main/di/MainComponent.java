package org.jcloarca.socialphotos.main.di;

import org.jcloarca.socialphotos.SocialPhotosAppModule;
import org.jcloarca.socialphotos.domain.di.DomainModule;
import org.jcloarca.socialphotos.libs.di.LibsModule;
import org.jcloarca.socialphotos.main.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JCLoarca on 7/21/2016 10:27 PM.
 */
@Singleton
@Component(modules = {MainModule.class, DomainModule.class, LibsModule.class, SocialPhotosAppModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
