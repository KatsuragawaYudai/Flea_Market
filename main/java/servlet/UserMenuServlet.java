package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Trade;
import bean.User;
import dao.TradeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userMenu")
public class UserMenuServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String transit = request.getParameter("transit");
		
		String error = null;
		String cmd = null;
		String link = null;
		
		ArrayList<String> notices = new ArrayList<>();

		try {
			if (user == null) {
				// session error
				error = "セッション切れです。再度ログインしてください。";
				cmd = "ログイン画面へ";
				link = "logout";
				return;
			}
			// message
			notices = createNotices(user);
			request.setAttribute("notice", notices);
			
			if (transit == null) {
				return;
			}
		} finally {
			if (error != null) {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.setAttribute("link", link);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} 
			// 正常系
			else if (transit == null) {
				request.getRequestDispatcher("/view/userMenu.jsp").forward(request, response);				
			} else if ("exhibitScreen".equals(transit)) {
				request.getRequestDispatcher("/view/exhibitScreen.jsp").forward(request, response);
			}
		}
	}
	
	private ArrayList<String> createNotices(User user) {
		ArrayList<String> rst = new ArrayList<String>();
		TradeDao tradeDao = new TradeDao();
		ArrayList<Trade> tradeList = tradeDao.selectByProducerId(user.getUserId());
		int status1count = 0;
		
		for (Trade trade : tradeList) {
			if (trade.getTradeStatus() == 1) {
				status1count++;
			}
		}
		
		ArrayList<Trade> customerTradeList = tradeDao.selectByCustomerId(user.getUserId());
		int status0count = 0;
		int status2count = 0;
		for (Trade trade : customerTradeList) {
			if (trade.getTradeStatus() == 0) {
				status0count++;
			} else if (trade.getTradeStatus() == 2) {
				status2count++;
			}
		}
		
		if (status1count != 0) {
			rst.add("商品を発送してください（" + status1count + "）");
		}
		if (status0count != 0) {
			rst.add("入金してください（" + status0count + "）");
		}
		if (status2count != 0) {
			rst.add("商品が発送されています。届きましたらステータスを更新してください（" + status2count + "）");
		}
		return rst;
	}
}