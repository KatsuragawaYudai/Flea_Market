package servlet;

import java.io.IOException;

import bean.Item;
import dao.ItemDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/freeItemDetail")
public class FreeItemDetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//String error = "";
		//String cmd = "";

		try {
			ItemDao itemObj = new ItemDao();
			 		
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			
			Item item = itemObj.selectByItemId(itemId); 
			
			request.setAttribute("item",item);
			
			request.getRequestDispatcher("/view/freeItemDetail.jsp").forward(request, response);
			return;
			
		}catch (IllegalStateException e) {
			request.setAttribute( "error","DB接続エラーの為、ログインは出来ません。"); 
			request.setAttribute("cmd", "ログイン画面へ戻る");
			request.setAttribute("link", "login");

		
		}finally {
			request.getRequestDispatcher("/error").forward(request, response);

		}
	}
}
