package org.jcloarca.socialphotos.main;

import android.location.Location;

import org.greenrobot.eventbus.Subscribe;
import org.jcloarca.socialphotos.domain.FirebaseAPI;
import org.jcloarca.socialphotos.entities.Photo;
import org.jcloarca.socialphotos.libs.base.EventBus;
import org.jcloarca.socialphotos.libs.base.ImageStorage;
import org.jcloarca.socialphotos.libs.base.ImageStorageFinishedListener;
import org.jcloarca.socialphotos.main.events.MainEvent;
import org.jcloarca.socialphotos.main.ui.MainView;

import java.io.File;

/**
 * Created by JCLoarca on 7/21/2016 10:30 PM.
 */
public class MainRepositoryImpl implements MainRepository {
    private EventBus eventBus;
    private FirebaseAPI firebase;
    private ImageStorage imageStorage;

    public MainRepositoryImpl(EventBus eventBus, FirebaseAPI firebase, ImageStorage imageStorage) {
        this.eventBus = eventBus;
        this.firebase = firebase;
        this.imageStorage = imageStorage;
    }

    @Override
    public void logout() {
        firebase.logout();
    }

    @Override
    public void uploadPhoto(Location location, String path) {
        final String newPhotoId = firebase.create();
        final Photo photo = new Photo();
        photo.setId(newPhotoId);
        photo.setEmail(firebase.getAuthEmail());
        if (location != null) {
            photo.setLatitutde(location.getLatitude());
            photo.setLongitude(location.getLongitude());
        }

        post(MainEvent.UPLOAD_INIT);
        imageStorage.upload(new File(path), photo.getId(), new ImageStorageFinishedListener(){

            @Override
            public void onSuccess() {
                String url = imageStorage.getImageUrl(photo.getId());
                photo.setUrl(url);
                firebase.update(photo);

                post(MainEvent.UPLOAD_COMPLETE);
            }

            @Override
            public void onError(String error) {
                post(MainEvent.UPLOAD_ERROR, error);
            }
        });
    }

    private void post(int type){
        post(type, null);
    }

    private void post(int type, String error){
        MainEvent event = new MainEvent();
        event.setType(type);
        event.setError(error);
        eventBus.post(event);
    }
}