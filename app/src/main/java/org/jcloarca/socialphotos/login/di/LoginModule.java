package org.jcloarca.socialphotos.login.di;

import org.jcloarca.socialphotos.domain.FirebaseAPI;
import org.jcloarca.socialphotos.libs.base.EventBus;
import org.jcloarca.socialphotos.login.LoginInteractor;
import org.jcloarca.socialphotos.login.LoginInteractorImpl;
import org.jcloarca.socialphotos.login.LoginPresenter;
import org.jcloarca.socialphotos.login.LoginPresenterImpl;
import org.jcloarca.socialphotos.login.LoginRepository;
import org.jcloarca.socialphotos.login.LoginRepositoryImpl;
import org.jcloarca.socialphotos.login.SignupInteractor;
import org.jcloarca.socialphotos.login.SignupInteractorImpl;
import org.jcloarca.socialphotos.login.ui.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JCLoarca on 7/21/2016 12:18 AM.
 */
@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    LoginView providesLoginView() {
        return this.view;
    }

    @Provides
    @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor, SignupInteractor signupInteractor) {
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor, signupInteractor);
    }

    @Provides
    @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository) {
        return new LoginInteractorImpl(repository);
    }

    @Provides
    @Singleton
    SignupInteractor providesSignupInteractor(LoginRepository repository) {
        return new SignupInteractorImpl(repository);
    }

    @Provides
    @Singleton
    LoginRepository providesLoginRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new LoginRepositoryImpl(firebase, eventBus);
    }
}