package humorProject.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionChk {
	public static void chk(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null || id.equals(""))
			try {
				response.sendRedirect("loginForm.do");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
	}
}
