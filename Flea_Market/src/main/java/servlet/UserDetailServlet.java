package servlet;

import java.io.IOException;

import bean.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userDetail")
public class UserDetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String cmd = "";
		String link = "";
		
		try {
		
			HttpSession session = request.getSession();
			
			UserDao userObj = new UserDao();
			
			int userId = Integer.parseInt(request.getParameter("userId"));
		
			User user = userObj.selectByUserId(userId);
			
			//userId = -1ならエラー
			if(user.getUserId() == -1) {
				
				error = "表示対象のユーザー情報が存在しない為、詳細情報は表示できませんでした。";
				cmd = "ユーザー一覧に戻る";
				link = "userList";
			}
			
			request.setAttribute("user", user);
			
			
		}catch(IllegalStateException e) {
			
			error = "DB接続エラーの為、書籍詳細は表示できませんでした。";
			cmd = "ログイン画面に戻る";
			link = "login";
			
		}finally {
			
			//フォワード処理
			if(error.equals("")) {
				
				request.getRequestDispatcher("/view/userDetail.jsp").forward(request, response);
				
			}else {
				
				request.setAttribute("error",error);
				request.setAttribute("cmd",cmd);
				request.setAttribute("link",link);
				
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				
			}
		}
	}	
}
