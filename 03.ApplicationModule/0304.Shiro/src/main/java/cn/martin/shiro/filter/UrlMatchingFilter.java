package cn.martin.shiro.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lcssos on 15/12/20.
 */


@Slf4j
public class UrlMatchingFilter extends AccessControlFilter {


    private List<String> urls = new ArrayList<>();



    public void init(){

    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String path = ((HttpServletRequest) request).getServletPath();
//        System.out.println(path);
        path = WebUtils.getRequestUri((HttpServletRequest)request);
//        System.out.println(path);

//        System.out.println("url matches,config is " + Arrays.toString((String[])mappedValue));

//        Subject subject = SubjectUtils.ge
        Subject subject = SecurityUtils.getSubject();
        Object o = subject.getPrincipal();
        log.info(o.toString());


        //跳到onAccessDenied处理
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        WebUtils.issueRedirect(request,response,unauthorizedUrl);
        request.getRequestDispatcher("/WEB-INF/jsp/unauthorized.jsp").forward(request, response);
        return false;
    }
}
