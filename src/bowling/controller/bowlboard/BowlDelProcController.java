package bowling.controller.bowlboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bowling.controller.Controller;
import bowling.dao.BowlboardDao;

public class BowlDelProcController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("========== < BowlDelProcController > ==========");
		
		String bno=request.getParameter("c"); // request로 받은 값은 String으로 받아야 됨
	
		BowlboardDao bdao=new BowlboardDao();
		int del=bdao.bowlboardDel(Integer.parseInt(bno));
		
		response.sendRedirect("bowlNotice.do");
	}

}
