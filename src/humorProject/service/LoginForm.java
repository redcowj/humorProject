package humorProject.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		return "loginForm.jsp";
	}

}
