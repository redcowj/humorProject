package humorProject.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import humorProject.dao.MemberDao;
import humorProject.model.Member;



public class MainAction implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		SessionChk.chk(request,response);
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id != null ) {
		MemberDao md = MemberDao.getInstance();
		Member member = md.select(id);
		request.setAttribute("member", member);
		}
		return "main.jsp";
	}

}
