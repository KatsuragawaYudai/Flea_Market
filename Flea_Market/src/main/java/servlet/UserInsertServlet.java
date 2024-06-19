package servlet;

import java.io.IOException;

import bean.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userInsert")
public class UserInsertServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User objUser = new User();
		UserDao objUserDao = new UserDao();
		
		String username = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String address = request.getParameter("address");
		String mail = request.getParameter("email");
		String pass = request.getParameter("password");
		
		objUser.setName(username);
		objUser.setNickname(nickname);
		objUser.setAddress(address);
		objUser.setEmail(mail);
		objUser.setPassword(pass);
		
		objUserDao.insert(objUser);
		
		request.getRequestDispatcher("/view/login.jsp").forward(request, response);

	}
}
