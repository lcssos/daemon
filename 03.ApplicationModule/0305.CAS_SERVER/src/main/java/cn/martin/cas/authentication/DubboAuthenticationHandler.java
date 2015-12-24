package cn.martin.cas.authentication;

import cn.martin.dubbo.authc.AuthenticationService;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;

import javax.security.auth.login.AccountNotFoundException;
import java.security.GeneralSecurityException;

/**
 * Created by lcssos on 15/12/24.
 */
public class DubboAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

    private AuthenticationService authcService;

    public AuthenticationService getAuthcService() {
        return authcService;
    }

    public void setAuthcService(AuthenticationService authcService) {
        this.authcService = authcService;
    }


    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential) throws GeneralSecurityException, PreventedException {
//        getJdbcTemplate().queryForObject("",String.class,usernamePasswordCredential.getUsername());

        boolean c = authcService.check(credential.getUsername(),credential.getPassword());
        if(!c){
            throw new AccountNotFoundException(credential.getUsername() + " not found in dubbo.");
        }

        return createHandlerResult(credential, principalFactory.createPrincipal(credential.getUsername()),null);
    }
}
