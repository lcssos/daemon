package cn.martin.dubbo.authc;

/**
 * Created by lcssos on 15/12/24.
 */
public interface AuthenticationService {
    boolean check(String username, String password);
}
