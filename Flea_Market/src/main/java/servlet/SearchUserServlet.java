package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/search")
public class SearchUserServlet extends HttpServlet{

	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
	
		String error = "";
		String cmd = "";
		String link = "";
		
		UserDao daoSearch = new UserDao();
		ArrayList<User> list = new ArrayList<User>();

		response.setContentType("text/html; charset=UTF-8");
		
		String nickname = request.getParameter("nickname");

		try {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if(user == null) {
				error = "セッション切れ";
				cmd = "ログイン";
				link = "login";
				return;
							
			}
			list = daoSearch.searchByName(nickname);
			
		}catch(IllegalStateException e) {
			error = "DB接続エラー";
			cmd = "メニュー";
			link = "adminMenu";
		}finally {
			if (error.equals("")) {
				request.setAttribute("userList", list);
				request.getRequestDispatcher("/view/showUser.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.setAttribute("link", link);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
		
	}
}
