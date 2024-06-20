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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		//セッションオブジェクトの取得
		HttpSession session = request.getSession();

		UserDao userDaoObj = new UserDao();

		int userId= Integer.parseInt(request.getParameter("userId"));
		String password = request.getParameter("password");

		User user = userDaoObj.selectByUserIdAndPassword(userId, password);
		
		if (user.getUserId() != -1 && user.getPassword() != null) {
			session.setAttribute("user", user);
			//Cookieオブジェクトの生成
			Cookie userCookie = new Cookie("userId",Integer.toString(userId));
			userCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(userCookie);

			Cookie passCookie = new Cookie("password", password);
			passCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(passCookie);
			
			request.getRequestDispatcher("/view/userMenu.jsp").forward(request, response);
		}
		
		
	}
}
