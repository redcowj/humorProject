package humorProject.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humorProject.dao.MemberDao;

public class IdChkAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id"); 
		MemberDao md = MemberDao.getInstance();
		int result = md.idChk(id);
		request.setAttribute("result", result);
		
		return "idChk.jsp";
	}

}
