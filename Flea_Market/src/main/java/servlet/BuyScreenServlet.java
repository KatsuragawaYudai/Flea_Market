package servlet;

import java.io.IOException;

import bean.Item;
import dao.ItemDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buyScreen")
public class BuyScreenServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("itemId"));
		ItemDao objItemDao = new ItemDao();
		Item item = objItemDao.selectByItemId(id);
		request.setAttribute("item", item);
		request.getRequestDispatcher("/view/buyScreen.jsp").forward(request, response);
	}
}