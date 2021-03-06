package org.jcloarca.socialphotos.main;

import android.location.Location;

/**
 * Created by JCLoarca on 7/21/2016 10:29 PM.
 */
public class UploadInteractorImpl implements UploadInteractor {
    private MainRepository repository;

    public UploadInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Location location, String path) {
        repository.uploadPhoto(location, path);
    }

}
