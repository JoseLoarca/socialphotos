package org.jcloarca.socialphotos.login;

/**
 * Created by JCLoarca on 7/21/2016 12:23 AM.
 */
public class SignupInteractorImpl implements SignupInteractor {
    private LoginRepository loginRepository;

    public SignupInteractorImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void execute(String email, String password) {
        loginRepository.signUp(email, password);
    }
}
