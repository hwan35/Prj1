package bowling.controller.bowlboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bowling.controller.Controller;

public class BowlRegController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("========== < BowlRegController > ==========");
		
		request.getRequestDispatcher("bowlReg.jsp").forward(request, response);
	}
}
