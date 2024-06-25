package servlet;

import java.io.IOException;

import bean.User;
import dao.ItemDao;
import dao.TradeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminExhibitListDelete")
public class AdminExhibitListDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = null;
		String cmd = null;
		String link = null;
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		try {
			if (user == null) {
				// session error
				error = "セッション切れです。再度ログインしてください。";
				cmd = "ログイン画面へ";
				link = "logout";
				return;
			}
			// トレードを削除する
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			ItemDao itemDao = new ItemDao();
			TradeDao tradeDao = new TradeDao();
			//TODO: transactionにするべき
			itemDao.deleteByItemId(itemId);
			tradeDao.deleteByItemId(itemId);

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (error != null) {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.setAttribute("link", link);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/adminExhibitList");				
			}
		}
	}

}
