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

@WebServlet("/freeSearchItem")
public class FreeSearchItemServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException{
		HttpSession session = request.getSession();
		String searchTxt = request.getParameter("searchText");
		String searchRegion = request.getParameter("searchRegion");
	
		ItemDao objItemDao = new ItemDao();
		
		ArrayList<Item> item_list = objItemDao.searchByNameAndRegionAndRemark(searchTxt, searchRegion, "");
//		System.out.println(item_list.get(0).getName());
		session.setAttribute("item_list", item_list);
		request.getRequestDispatcher("/view/freeItemList.jsp").forward(request, response);
	}
	

}