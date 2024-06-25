package servlet;

import java.io.IOException;

import bean.Trade;
import bean.User;
import dao.TradeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updatetrade")
public class UpdateTradeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = "";
		String error = "";
		String link = "";
		
		int tradeId = -1;
		try {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if(user == null) {
				error = "セッション切れ";
				cmd = "ログイン";
				link = "login";
				return;
							
			}
			//String tradeID = request.getParameter("tradeId");
			tradeId = Integer.parseInt(request.getParameter("tradeId"));
			String change = request.getParameter("change");
			TradeDao traUpdDAO = new TradeDao();
			Trade updateTrade = traUpdDAO.selectByTradeId(tradeId);
			updateTrade.setTradeStatus(3);

			if(change.equals("入金")) {
				updateTrade.setTradeStatus(1);
			}else if(change.equals("到着")) {
				updateTrade.setTradeStatus(3);
			}else{
				error = "error <br>";
				cmd = "取引状況画面";
				link = "transport";
				return;
			}
			
			traUpdDAO.updateByTradeId(updateTrade);
		} catch (IllegalStateException e) {
			error = "DB接続エラー<br>";
			cmd = "メニュー";
			link = "userMenu";
		} finally {
			if (cmd.equals("")) {
//				request.getRequestDispatcher("/transport").forward(request, response);
				response.sendRedirect(request.getContextPath() + "/transport?tradeId=" + tradeId);
			} else {
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.setAttribute("link", link);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
	}
	}
}