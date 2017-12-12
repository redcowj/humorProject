package humorProject.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humorProject.dao.Board;
import humorProject.dao.BoardDao;
import humorProject.dao.RowNum;

public class BoardList implements CommandProcess {
	//모든 페이지를 가져오는것이 아니라 선택한 페이지만 가져오도록 만듬 
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		final int ROWPERPAGE = 10; //한페이지당 보여주는 글의 개수
		final int PAGEPERBLOCK = 10;//페이지를 표시할 개수 
		String pageNum = request.getParameter("pageNum"); //pageNum은 현재 페이지
		if(pageNum == null || pageNum.equals("")){
			pageNum = "1";
		}
		int currentPage =Integer.parseInt(pageNum); //현재 페이지 1,  2, 3페이지
		int startRow = (currentPage -1)*ROWPERPAGE +1;// 1~10, 11~20, 21~30
		int endRow = startRow + ROWPERPAGE -1;
		BoardDao bd = BoardDao.getInstance();
		int total = bd.total(); //총 글의 개수
		System.out.println(total);
		int totPage = (int)Math.ceil((double)total/ROWPERPAGE);//한 페이지당 글을 표시할 수 있는 개수로 나누면 총 페이지개수가 나옴 
		int startPage = currentPage -(currentPage-1)%PAGEPERBLOCK; //1,2,3,4,5,6,7,8,9,0 || 11,12,13,14,15,16,17,18,19,20 페이지 수 10개씩 표시되게 한다.
													//7페이지면 1~10, 15페이지면 11~20, 28페이지면 21~30 페이지가 게시판밑에 표시됨
		int endPage = startPage + PAGEPERBLOCK-1;
		if(endPage>totPage) endPage = totPage; //마지막 페이지 수 변경, 34페이지까지있는 게시판이라면 이 코드가 없으면 40페이지까지 표시된다.
		int tot = total - startRow +1;
		Board board = new Board();
		board.setStartRow(startRow);
		board.setEndRow(endRow);
		List<Board> list = bd.getList(board); //지정한 페이지의 글만 읽어옴
		
		//시간 설정부분
		for(Board board1: list) {
			SimpleDateFormat sdf2 = new SimpleDateFormat("yy-MM-dd");// HH:mm:ss
			String old = sdf2.format(board1.getReg_date());
			//if(today.compareTo(board.getReg_date()) <0) board.setTime(news); //today가 무조건 커 1 이 나온다.
			board1.setTime(old);
		}
		request.setAttribute("PAGEPERBLOCK", PAGEPERBLOCK);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow",startRow );
		request.setAttribute("endRow",endRow );
		request.setAttribute("total", total);
		request.setAttribute("totPage", totPage);
		request.setAttribute("startPage",startPage );
		request.setAttribute("endPage", endPage);
		request.setAttribute("ROWPERPAGE", ROWPERPAGE);
		request.setAttribute("list", list);
		
		return "boardList.jsp";
	}

}
