package org.jcloarca.socialphotos.login;

/**
 * Created by JCLoarca on 7/21/2016 12:05 AM.
 */
public interface LoginRepository {
    void signUp(final String email, final String password);
    void signIn(String email, String password);
}
