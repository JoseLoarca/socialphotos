package org.jcloarca.socialphotos.login.ui;

/**
 * Created by JCLoarca on 7/21/2016 12:04 AM.
 */
public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignUp();
    void handleSignIn();

    void newUserSuccess();
    void navigateToMainScreen();
    void setUserEmail(String email);

    void loginError(String error);
    void newUserError(String error);
}
