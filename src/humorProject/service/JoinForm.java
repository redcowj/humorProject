package humorProject.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinForm implements CommandProcess{

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		return "joinForm.jsp";
	}

}
