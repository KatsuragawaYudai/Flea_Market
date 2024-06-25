package servlet;

import java.io.IOException;

import bean.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {

			//セッションオブジェクトの取得
			HttpSession session = request.getSession();

			UserDao userDaoObj = new UserDao();

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			User user = userDaoObj.selectByEmailAndPassword(email, password);

			int authority = user.getAuthority();

			if (user.getEmail() != null && user.getPassword() != null) {

		
				session.setAttribute("user", user);

				//Cookieオブジェクトの生成
				Cookie userCookie = new Cookie("email", email);
				userCookie.setMaxAge(60 * 60 * 24 * 5);
				response.addCookie(userCookie);

				Cookie passCookie = new Cookie("password", password);
				passCookie.setMaxAge(60 * 60 * 24 * 5);
				response.addCookie(passCookie);
				
				//管理者メニューとユーザーメニューへ
				if (authority == 0) {
					response.sendRedirect(request.getContextPath() + "/adminMenu");

					return;

				} else {
					response.sendRedirect(request.getContextPath() + "/userMenu");
					return;
				}

			} else {
				request.setAttribute("message", "入力データが間違っています！");
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);
				return;
			}

		} catch (IllegalStateException e) {
			request.setAttribute( "error","DB接続エラーの為、ログインは出来ません。"); 
			request.setAttribute("cmd", "ログイン画面へ戻る");
			request.setAttribute("link", "login");

			request.getRequestDispatcher("/view/error.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			request.setAttribute("message", "不正の為、ログインできません。");
			request.getRequestDispatcher("/view/login.jsp").forward(request, response);
			return;
			
		} 

	}
}

