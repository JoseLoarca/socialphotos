package org.jcloarca.socialphotos.login.di;

import org.jcloarca.socialphotos.SocialPhotosApp;
import org.jcloarca.socialphotos.SocialPhotosAppModule;
import org.jcloarca.socialphotos.domain.di.DomainModule;
import org.jcloarca.socialphotos.libs.di.LibsModule;
import org.jcloarca.socialphotos.login.ui.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JCLoarca on 7/21/2016 12:17 AM.
 */
@Singleton
@Component(modules = {LoginModule.class, DomainModule.class, LibsModule.class, SocialPhotosAppModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}