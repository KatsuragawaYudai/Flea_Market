package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Item;
import bean.Trade;
import dao.ItemDao;
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
		
		ArrayList<Trade> tradeList = new ArrayList<Trade>();
		ArrayList<Item>itemList = new ArrayList<Item>();
		
		TradeDao objTradeDao = new TradeDao();
		ItemDao objItemDao = new ItemDao();
		
		tradeList = objTradeDao.selectAll();
		itemList = objItemDao.selectAll();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("trade_list", tradeList);
		session.setAttribute("item_list", itemList);
	}
}
