package humorProject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humorProject.dao.Board;
import humorProject.dao.BoardDao;
import humorProject.dao.BoardFile;
import humorProject.dao.BoardFileDao;



public class View implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		BoardDao bd = BoardDao.getInstance();
		Board board = bd.select(num); //선택한 num에 맞는 글을 가져와서 거기의 정보를 가져옴 
		BoardFileDao fd = BoardFileDao.getInstance();
		List<BoardFile> fileList = null;
		fileList = fd.getImage(num);
		request.setAttribute("fileList", fileList); //list
		request.setAttribute("board", board);
		request.setAttribute("pageNum", pageNum);
		return "viewBoard.jsp";
	}

}
