package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Trade;
import dao.TradeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sales")
public class SalesServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String error = "";
		String cmd = "";

		try {
		
			//インスタンス化
			TradeDao trade = new TradeDao();
			
			//取引情報を呼び出し、戻り値をアレイリストに格納
			ArrayList<Trade> tradeList =trade.selectByTradeStatus(3);
			
			//リクエストスコープに設定
			request.setAttribute("list",tradeList);
			
			//sales.jspを遷移
			request.getRequestDispatcher("/view/sales.jsp").forward(request,response);
			
			return;
			
		}catch (IllegalStateException e) {
			request.setAttribute( "error","DB接続エラーの為、ログインは出来ません。"); 
			request.setAttribute("cmd", "ログイン画面へ戻る");
			request.setAttribute("link", "login");

		
		}finally {
			request.getRequestDispatcher("/error").forward(request, response);
		}
	}
}
