package example.myrest.handler;

import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFailureHandler implements AuthenticationFailureHandler {

    private String username;
    private String password;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String errormsg = null;

        if(exception instanceof BadCredentialsException) {
            errormsg = "error.BadCredentials";
        } else if(exception instanceof InternalAuthenticationServiceException) {
            errormsg = "error.BadCredentials";
        } else if(exception instanceof DisabledException) {
            errormsg = "error.Disaled";
        } else if(exception instanceof CredentialsExpiredException) {
            errormsg = "error.CredentialsExpired";
        }

        System.out.println("에러 메시지!" + errormsg);

        response.sendRedirect("/account/login?error");
//        request.getRequestDispatcher("/account/login?error").forward(request, response);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
