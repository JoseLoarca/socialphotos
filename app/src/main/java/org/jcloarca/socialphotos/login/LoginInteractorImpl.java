package org.jcloarca.socialphotos.login;

/**
 * Created by JCLoarca on 7/21/2016 12:19 AM.
 */
public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRepository;

    public LoginInteractorImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void execute(String email, String password) {
        loginRepository.signIn(email, password);
    }
}
