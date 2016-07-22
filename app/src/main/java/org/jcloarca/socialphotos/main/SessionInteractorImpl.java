package org.jcloarca.socialphotos.main;

/**
 * Created by JCLoarca on 7/21/2016 10:30 PM.
 */
public class SessionInteractorImpl implements SessionInteractor {
    MainRepository repository;

    public SessionInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logout() {
        repository.logout();
    }
}