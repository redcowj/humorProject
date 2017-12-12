package humorProject.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humorProject.dao.Board;
import humorProject.dao.BoardDao;



public class Write implements CommandProcess{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String subject = request.getParameter("subject");
		String  id= request.getParameter("id");
		String  category= request.getParameter("category");
		String  content= request.getParameter("content");
		//String originFile = request.getParameter("originFile");
//		int resultFile = 0;
//		FileUpload2 fUpload = new FileUpload2();
//		resultFile = fUpload.fileupload(request, response);
		
		String ip = request.getRemoteAddr();
		Board board = new Board();
		board.setSubject(subject);
		board.setId(id);
		board.setCategory(category);
		board.setContent(content);
		board.setIp(ip);
		BoardDao bd = BoardDao.getInstance();
		int result = bd.write(board);
		request.setAttribute("result", result);
		//request.setAttribute("resultFile", resultFile);
		return "write.jsp";
	}

}
