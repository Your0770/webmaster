package com.yedam.control.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String kw = req.getParameter("keyword");
		String sc = req.getParameter("searchCondition");
		BoardService svc = new BoardServiceImpl();
		
		if (req.getMethod().equals("GET")) {
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));
			req.setAttribute("boardvo", board);
			req.setAttribute("page", page);
			req.setAttribute("keyword", kw);
			req.setAttribute("searchCondition", sc);

			req.getRequestDispatcher("board/removeBoard.tiles").forward(req, resp);

		} else if(req.getMethod().equals("POST")){
			if(svc.removeBoard(Integer.parseInt(bno))) {
				resp.sendRedirect("boardList.do?searchCondition=" + sc +  "&keyword=" + kw + "&page="+ page);
			}else {
				resp.sendRedirect("board.do?searchCondition=" + sc + "&keyword=" + kw + "&page=" + page +"&bno=" + bno);
			}
			
		}
	}

}
