package bowling.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bowling.controller.bowlboard.BowlDelProcController;
import bowling.controller.bowlboard.BowlDetailController;
import bowling.controller.bowlboard.BowlEditController;
import bowling.controller.bowlboard.BowlEditProcController;
import bowling.controller.bowlboard.BowlNoticeController;
import bowling.controller.bowlboard.BowlRegController;
import bowling.controller.bowlboard.BowlRegProcController;

public class MyDispatcher extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		System.out.println("============ < MyDispatcher In > ============");
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		System.out.println("uri: "+uri);
		System.out.println("conPath: "+conPath);
		System.out.println("com: "+com);
		
		Controller controller=null;
		
		try {
			if (com.equals("/bowling/bowlNotice.do")) {
				controller=new BowlNoticeController();
			} else if (com.equals("/bowling/bowlDetail.do")) {
				controller=new BowlDetailController();
			} else if (com.equals("/bowling/bowlEdit.do")) {
				controller=new BowlEditController();
			} else if (com.equals("/bowling/bowlEditProc.do")) {
				controller=new BowlEditProcController();
			} else if (com.equals("/bowling/bowlReg.do")) {
				controller=new BowlRegController();
			} else if (com.equals("/bowling/bowlRegProc.do")) {
				controller=new BowlRegProcController();
			} else if (com.equals("/bowling/bowlDelProc.do")) {
				controller=new BowlDelProcController();
			}
			
			controller.execute(request, response); // 이거 안 쓰면 .do 페이지로 안 넘어간다!
			
		} catch (Exception e) {
			
		}
	}

}
