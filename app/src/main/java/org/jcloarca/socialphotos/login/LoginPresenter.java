package org.jcloarca.socialphotos.login;

import org.jcloarca.socialphotos.login.events.LoginEvent;

/**
 * Created by JCLoarca on 7/21/2016 12:04 AM.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);
    void login(String email, String password);
    void registerNewUser(String email, String password);
}
