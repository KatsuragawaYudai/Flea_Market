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


@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		try {
			//インスタンス化
			UserDao userDAO = new UserDao();

			//リスト取得する
			ArrayList<User> userList = userDAO.selectAll();

			//取得したListを格納
			request.setAttribute("userList", userList);
			
		}catch(IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は行えませんでした。";
		}finally {
			if(error.equals("")) {
				request.getRequestDispatcher("/view/showUser.jsp").forward(request, response);
			}else {
				request.setAttribute("cmd", "menu");
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
