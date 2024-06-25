package servlet;

import java.io.IOException;

import bean.Item;
import bean.Trade;
import bean.User;
import dao.ItemDao;
import dao.TradeDao;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/transport")
public class TransportServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		UserDao daoObj = new UserDao();

		response.setContentType("text/html; charset=UTF-8");

		//String cmd = request.getParameter("cmd");
		//System.out.print(request.getParameter("itemId"));
		int tradeId =Integer.parseInt(request.getParameter("tradeId"));
		//System.out.print(tradeId);
		
		String error = "";
		String cmd = "";
		String link = "";
	
		/*int tradeId = 004;
		String proName = "中村";
		String cstName = "太郎";
		String itmName = "りんごのカード";*/
				
		
		try {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if(user == null) {
				error = "セッション切れ";
				return;
							
			}

			TradeDao traDAO = new TradeDao();
			Trade trade = traDAO.selectByTradeId(tradeId);
			
			ItemDao itmDAO = new ItemDao();
			Item item = itmDAO.selectByItemId(trade.getItemId());
			String itmName = item.getName();
			
			User producer = daoObj.selectByUserId(trade.getProducerId());
			String proName = producer.getName();
			
			User cuostomer = daoObj.selectByUserId(trade.getCustomerId());
			String cstName = cuostomer.getName();
			
			request.setAttribute("trade", trade);
			request.setAttribute("proName", proName);
			request.setAttribute("cstName", cstName);
			request.setAttribute("itmName", itmName);
			
			if(trade.getTradeStatus() == -1){
				error = "error<br>";
				cmd = "メニュー";
				link = "userMenu";
				return;
			}

		} catch (IllegalStateException e) {
			error = "DB接続エラー <br>";
			cmd = "メニュー";
			link = "userMenu";
			
		} finally {
			if (cmd.equals("") ) {
				request.getRequestDispatcher("/view/status.jsp").forward(request, response);
			}else {
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.setAttribute("link", link);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
