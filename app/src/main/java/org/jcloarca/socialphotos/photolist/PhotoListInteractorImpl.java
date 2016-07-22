package org.jcloarca.socialphotos.photolist;

import org.jcloarca.socialphotos.entities.Photo;

/**
 * Created by JCLoarca on 7/21/2016 10:58 PM.
 */
public class PhotoListInteractorImpl implements PhotoListInteractor {

    PhotoListRepository repository;

    public PhotoListInteractorImpl(PhotoListRepository repository) {
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

    @Override
    public void removePhoto(Photo photo) {
        repository.remove(photo);
    }
}
