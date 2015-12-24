package cn.martin.authc.service;


import cn.martin.dubbo.authc.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lcssos on 15/12/24.
 */
@Service
//@Transactional
public class AuthentictionServiceImpl implements AuthenticationService {
    @Override
    public boolean check(String username, String password) {
        return username.equals(password) ? true : false;
    }
}
