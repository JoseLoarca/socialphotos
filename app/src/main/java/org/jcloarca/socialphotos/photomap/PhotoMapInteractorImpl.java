package org.jcloarca.socialphotos.photomap;

/**
 * Created by JCLoarca on 7/22/2016 12:49 AM.
 */
public class PhotoMapInteractorImpl implements PhotoMapInteractor {

    PhotoMapRepository repository;

    public PhotoMapInteractorImpl(PhotoMapRepository repository) {
        this.repository = repository;
    }

    @Override
    public void subscribe() {
        repository.subscribe();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribe();
    }
}