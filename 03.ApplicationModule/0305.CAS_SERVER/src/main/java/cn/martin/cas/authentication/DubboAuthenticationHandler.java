package cn.martin.cas.authentication;

import org.jasig.cas.adaptors.jdbc.AbstractJdbcUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;

import java.security.GeneralSecurityException;

/**
 * Created by lcssos on 15/12/24.
 */
public class DubboAuthenticationHandler extends AbstractJdbcUsernamePasswordAuthenticationHandler {

    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential) throws GeneralSecurityException, PreventedException {

//        getJdbcTemplate().queryForObject("",String.class,usernamePasswordCredential.getUsername());


        return createHandlerResult(credential, principalFactory.createPrincipal(credential.getUsername()),null);
    }
}
