package bowling.controller.bowlboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bowling.controller.Controller;
import bowling.dao.BowlboardDao;
import bowling.vo.Bowlboard;

public class BowlDetailController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("========== < BowlDetailController > ==========");
		
		String bno=request.getParameter("c");
		BowlboardDao bdao=new BowlboardDao();
		Bowlboard b=bdao.bowlboardDetail(Integer.parseInt(bno));
		
		request.setAttribute("b", b); // 어떤 값을 가지고 돌아갈 때는 .jsp로 가고 없으면 바로 notice.do로 보냄
		request.getRequestDispatcher("bowlDetail.jsp").forward(request, response);
	}
	
}
