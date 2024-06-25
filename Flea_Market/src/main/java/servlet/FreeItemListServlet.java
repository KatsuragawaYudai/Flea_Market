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

@WebServlet("/freeitemList")
public class FreeItemListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Item> freelist = new ArrayList<Item>();
		ItemDao freeItemDao = new ItemDao();
		HttpSession session = request.getSession();
		
		freelist = freeItemDao.selectAll();
		
		session.setAttribute("item_list", freelist);
		request.getRequestDispatcher("/view/freeItemList.jsp").forward(request, response);
		
	}
}
