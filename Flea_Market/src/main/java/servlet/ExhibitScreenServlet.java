package servlet;

import java.io.IOException;

import bean.Item;
import dao.ItemDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exhibitScreen")
public class ExhibitScreenServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Item item = new Item();
		
		ItemDao itemObjDao = new ItemDao();
		
		item.setName(request.getParameter("name"));
		item.setRemark(request.getParameter("remark"));
		item.setPrice(Integer.parseInt(request.getParameter("price")));
		
		itemObjDao.insert(item);
		
		request.setAttribute("item",item);
		request.getRequestDispatcher("/userExhibitList").forward(request,response);
	}
}
