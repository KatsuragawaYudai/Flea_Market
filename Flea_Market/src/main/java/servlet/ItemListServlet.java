package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Item;
import dao.ItemDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/itemList")
public class ItemListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Item> list = new ArrayList<Item>();
		ItemDao objItemDao = new ItemDao();
		HttpSession session = request.getSession();
		
		list = objItemDao.selectAll();
		
		session.setAttribute("item_list", list);
		request.getRequestDispatcher("/view/itemList.jsp").forward(request, response);
		
	}
}
