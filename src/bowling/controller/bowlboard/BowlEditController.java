package bowling.controller.bowlboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bowling.controller.Controller;
import bowling.dao.BowlboardDao;
import bowling.vo.Bowlboard;

public class BowlEditController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("========== < BowlEditController > ==========");
		
		String bno=request.getParameter("c");
		
		BowlboardDao bdao=new BowlboardDao();
		Bowlboard b=bdao.bowlboardDetail(Integer.parseInt(bno));
		
		request.setAttribute("b", b);
		request.getRequestDispatcher("bowlEdit.jsp").forward(request, response);
	}

}
