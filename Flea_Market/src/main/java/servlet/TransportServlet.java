package servlet;

import java.io.IOException;

import bean.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/transport")
public class TransportServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";

		UserDao daoObj = new UserDao();

		response.setContentType("text/html; charset=UTF-8");

		String cmd = request.getParameter("cmd");
		String tradeId = request.getParameter("tradeId");
		try {

			User producer = daoObj.selectByUserID(tradeId);
			
			
			if(producer.getUserId() == null) {
				error = "表示対象の書籍が存在しない為、詳細情報は表示できませんでした。 <br>";
				cmd = "list";
				return;
			}

			request.setAttribute("book", bookDtl);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、書籍詳細は表示できませんでした。 <br>";
			cmd = "menu";
		} finally {
			if (cmd.equals("detail")) {
				request.getRequestDispatcher("/view/detail.jsp").forward(request, response);
			} else if(cmd.equals("delete")){
				request.getRequestDispatcher("/delete").forward(request, response);
			} else if(cmd.equals("update")){
				request.getRequestDispatcher("/update").forward(request, response);
			}else {
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
