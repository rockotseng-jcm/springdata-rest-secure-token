package example.springdata.rest;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @RequestMapping(value = "/login", produces = "application/json")
    public Map<String, String> login(Principal principal) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("username", principal.getName());
        return result;
    }

    @RequestMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session) {
        session.invalidate();
    }

}
