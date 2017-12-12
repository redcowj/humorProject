package humorProject.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import humorProject.dao.MemberDao;
import humorProject.model.Member;



public class LoginAction implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member member = new Member();
		member.setId(id);
		member.setPassword(password);
		MemberDao md = MemberDao.getInstance();
		int result = md.loginChk(member);
		if(result>0) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);//세션에 넣어놓기~~~로그인.
		}
		request.setAttribute("result", result);
		return "login.jsp";
	}
}
