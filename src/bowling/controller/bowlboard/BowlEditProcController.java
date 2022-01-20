package bowling.controller.bowlboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bowling.controller.Controller;
import bowling.dao.BowlboardDao;
import bowling.vo.Bowlboard;

public class BowlEditProcController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("========== < BowlEditProcController > ==========");
		String bno=request.getParameter("c");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		String bwriter=request.getParameter("bwriter");
		
		Bowlboard b=new Bowlboard();
		b.setBno(Integer.parseInt(bno));
		b.setBtitle(btitle);
		b.setBcontent(bcontent);
		b.setBwriter(bwriter);
		
		BowlboardDao bdao=new BowlboardDao();
		int edit=bdao.bowlboardEdit(b);
		b=bdao.bowlboardDetail(Integer.parseInt(bno));
		
		request.setAttribute("b", b);
		request.getRequestDispatcher("bowlDetail.jsp").forward(request, response);
	}
}
