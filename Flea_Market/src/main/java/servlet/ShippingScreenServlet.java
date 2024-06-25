package servlet;

import java.io.IOException;

import bean.Trade;
import bean.User;
import dao.TradeDao;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/shipping")
public class ShippingScreenServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String cmd = "";
		String link = "";
		int status = 0;
		UserDao daoObj = new UserDao();

		response.setContentType("text/html; charset=UTF-8");
		String strstatus = request.getParameter("status");
		if (strstatus != null) {
			status = Integer.parseInt(strstatus);
		}
		int tradeId = Integer.parseInt(request.getParameter("trade_id"));
		try {
			HttpSession session = request.getSession();
			//自分のUser情報から出品したものを出力する必要がある
			User user = (User)session.getAttribute("user");
			if(user == null) {
				error = "セッション切れの為、購入は出来ません。";
				cmd = "ログイン画面へ戻る";
				link= "login";
				return;
							
			}
			TradeDao TradeDao = new TradeDao();
			Trade trade = TradeDao.selectByTradeId(tradeId);
			request.setAttribute("trade",trade);
			
			if(status == 2) {
				trade.setTradeStatus(status);
				TradeDao.updateByTradeId(trade);
				return;
			}
			
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、書籍詳細は表示できませんでした。 <br>";
		} finally {
			if (status == 1 || status == 2) {
//				request.getRequestDispatcher("/userExhibitList").forward(request, response);
				response.sendRedirect(request.getContextPath() + "/userExhibitList");
			}
			else if (error == "") {
				request.getRequestDispatcher("/view/shippingScreen.jsp").forward(request, response);
			}else {	
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.setAttribute("link", link);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
