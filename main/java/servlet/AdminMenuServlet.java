package servlet;

import java.io.IOException;

import bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminMenu")
public class AdminMenuServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String error = null;
		String cmd = null;
		String link = null;
		
		try {
			if (user == null) {
				// session error
				error = "セッション切れです。再度ログインしてください。";
				cmd = "ログイン画面へ";
				link = "logout";
				return;
			}
		} finally {
			if (error != null) {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.setAttribute("link", link);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} else {
				// 正常系
				request.getRequestDispatcher("/view/adminMenu.jsp").forward(request, response);				
			}
		}
	}
}
