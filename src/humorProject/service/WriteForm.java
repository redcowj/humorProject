package humorProject.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import humorProject.dao.MemberDao;
import humorProject.model.Member;

public class WriteForm implements CommandProcess{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum"); //pageNum파라미터를 받아옴. 자기가 어디페이지인지
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id"); //저장한 id값 가져오기
		MemberDao md = MemberDao.getInstance();
		Member member = md.select(id);
		request.setAttribute("member", member);
		request.setAttribute("pageNum", pageNum);
		return "writeForm.jsp";
	}

}
