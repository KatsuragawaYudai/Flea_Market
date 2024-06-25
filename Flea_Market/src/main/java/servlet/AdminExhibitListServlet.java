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

@WebServlet("/adminExhibitList")
public class AdminExhibitListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String error = "";
		
		try {
			
			//TradeDaoのオブジェクト化
			TradeDao tradeDao = new TradeDao();
			
			ArrayList<Trade> trade_list = tradeDao.selectAll();
			
			//ItemDaoのオブジェクト化
			ItemDao itemDao = new ItemDao();
			ArrayList<Item> item_list = itemDao.selectByItemStatus(0);
			
			request.setAttribute("item_list", item_list);
			request.setAttribute("trade_list", trade_list);
			
		}catch(IllegalStateException e) {
			
			error = "DB接続エラーの為、出品一覧を表示できません。";
		}finally {
			
			if(error.equals("")) {
				request.getRequestDispatcher("/view/adminExhibitList.jsp").forward(request, response);
				
			}else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
			
		}
	}
}
