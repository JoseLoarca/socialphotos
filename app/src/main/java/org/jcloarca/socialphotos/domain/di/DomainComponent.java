package org.jcloarca.socialphotos.domain.di;

import org.jcloarca.socialphotos.SocialPhotosAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JCLoarca on 7/20/2016 11:03 PM.
 */

@Singleton
@Component(modules = {DomainModule.class, SocialPhotosAppModule.class})
public interface DomainComponent {
}
