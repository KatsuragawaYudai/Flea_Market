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

@WebServlet("/userExhibitList")
public class UserExhibitListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String cmd = "";
		String link = "";

		try{
			HttpSession session = request.getSession();
			//自分のUser情報から出品したものを出力する必要がある
			User user = (User)session.getAttribute("user");
			if(user == null) {
				error = "セッション切れの為、購入は出来ません。";
				cmd = "ログイン画面へ戻る";
				link= "login";
				return;
							
			}
			
			//int userId = 3;
			//自分のUserIDとプロデューサーIDを紐づけてItemを出力する
			TradeDao TradeDao = new TradeDao();
			ArrayList<Trade> trade_list = TradeDao.selectByItemIdExt(user.getUserId());
			
			request.setAttribute("trade_list",trade_list);

		}catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示はできませんでした。<br>";
			cmd = "ログイン画面へ戻る";
			link= "login";
		}finally{
			

			if (error=="") {
				request.getRequestDispatcher("/view/userExhibitList.jsp").forward(request, response);
			}else {	
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.setAttribute("link", link);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
