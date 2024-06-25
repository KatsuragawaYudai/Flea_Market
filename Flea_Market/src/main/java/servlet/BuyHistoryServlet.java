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

@WebServlet("/buyHistory")
public class BuyHistoryServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		ArrayList<Trade> tradeList = new ArrayList<Trade>();
		
		TradeDao objTradeDao = new TradeDao();
		
		tradeList = objTradeDao.selectByCustomerId(user.getUserId());
		
		
		session.setAttribute("trade_list", tradeList);
		request.getRequestDispatcher("/view/buyHistory.jsp").forward(request, response);
	}
}
