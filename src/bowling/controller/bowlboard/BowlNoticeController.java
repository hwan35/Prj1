package bowling.controller.bowlboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bowling.controller.Controller;
import bowling.dao.BowlboardDao;
import bowling.vo.Bowlboard;

public class BowlNoticeController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("========== < BowlNoticeController > ==========");
		
		// search
		String field=request.getParameter("f");
		System.out.println("field : "+field);
		if (field==null || field.equals(""))
			field="btitle";
		
		String query=request.getParameter("q");
		System.out.println("query : "+query);
		
		if (query==null) 
			query="";
		
		
		BowlboardDao bdao=new BowlboardDao();
		List<Bowlboard> list=bdao.bowlboardSelAll(field,query); // 아래쪽에 출력문 찍어보고 안 나오면 DBCon에 오타있나 확인할 것!
		
		int cnt=bdao.bowlboardCnt();
		
		request.setAttribute("list", list);
		request.setAttribute("cnt", cnt);
		request.setAttribute("query", query);
		
		request.getRequestDispatcher("bowlNotice.jsp").forward(request, response);
	}

}
