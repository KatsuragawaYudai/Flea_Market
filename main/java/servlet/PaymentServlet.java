package servlet;

import java.io.IOException;

import bean.Item;
import bean.Trade;
import bean.User;
import dao.ItemDao;
import dao.TradeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.SendMail;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String cmd = "";
		String link = "";

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			error = "セッション切れ";
			cmd = "ログイン";
			link = "login";
			return;

		}
		int id = Integer.parseInt(request.getParameter("itemId"));
		ItemDao objItemDao = new ItemDao();
		//idでアイテム特定
		Item item = objItemDao.selectByItemId(id);
		//アイテムステータスの情報の更新
		item.setItemStatus(1);
		//更新
		objItemDao.updateByItemId(item);

		Trade trade = new Trade();
		TradeDao objTradeDao = new TradeDao();

		/*
		 * public int insert(Trade trade) 
		 * (producer_id, customer_id, item_id, trade_status, payment, earning)
		 */
		trade.setProducerId(item.getProducerId());
		trade.setCustomerId(user.getUserId());
		trade.setItemId(item.getItemId());
		trade.setTradeStatus(0);
		trade.setPayment(item.getPrice());
		trade.setEarning((int)(item.getPrice()*0.1));
		
		String mailmsg = user.getName() +"様、購入ありがとうございます。\n下記の商品の購入が完了しました。"
				+ "入金をお願いします。\n\n"+ "商品名:" + item.getName() + 
				"\n値段:" + item.getPrice() + "\n\n今回はデモのため、既定のメールアドレスのみ送信しています。"; 
		
		objTradeDao.insert(trade);
		SendMail Mail = new SendMail();
		Mail.sendMail("",mailmsg);
		request.setAttribute("msg", "購入が完了しました。入金を確定してください。");
		request.setAttribute("item", item);
		request.getRequestDispatcher("/buyHistory").forward(request, response);
	}
}
