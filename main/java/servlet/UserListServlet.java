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


@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String cmd = "";
		String link = "";
		try {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if(user == null) {
				error = "セッション切れ";
				cmd = "ログイン";
				link = "login";
				return;
							
			}
			//インスタンス化
			UserDao userDAO = new UserDao();

			//リスト取得する
			ArrayList<User> userList = userDAO.selectAll();

			//取得したListを格納
			request.setAttribute("userList", userList);
			
		}catch(IllegalStateException e) {
			error = "DB接続エラー";
			cmd = "メニュー";
			link = "adminMenu";
		}finally {
			if(error.equals("")) {
				request.getRequestDispatcher("/view/showUser.jsp").forward(request, response);
			}else {
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.setAttribute("link", link);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
