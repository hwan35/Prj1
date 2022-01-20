package bowling.controller.bowlboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bowling.controller.Controller;
import bowling.dao.BowlboardDao;
import bowling.vo.Bowlboard;

public class BowlRegProcController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("========== < BowlRegProcController > ==========");
		
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		String bwriter=request.getParameter("bwriter");
		
		Bowlboard b=new Bowlboard();
		b.setBtitle(btitle);
		b.setBcontent(bcontent);
		b.setBwriter(bwriter);
		
		BowlboardDao bdao=new BowlboardDao();
		int reg=bdao.bowlboardReg(b);
		
		response.sendRedirect("bowlNotice.do");
	}
}
