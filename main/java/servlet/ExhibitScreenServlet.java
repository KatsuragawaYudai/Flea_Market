package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import bean.Item;
import bean.User;
import dao.ItemDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/exhibitScreen")
@MultipartConfig
public class ExhibitScreenServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String error = "";
		String cmd = "";
		String link = "";
		
		try {
			
			HttpSession session = request.getSession();
			
			User user = (User)session.getAttribute("user");
			if(user == null) {
				error = "セッション切れの為、購入は出来ません。";
				cmd = "ログイン画面に戻る";
				link = "login";
			}
			
			Item item = new Item();
		
			ItemDao itemObjDao = new ItemDao();
			
			//フォームから情報取得
			String name = request.getParameter("name");
			String remark = request.getParameter("remark");
			String price = request.getParameter("price");
			Part image = request.getPart("image");
			String region = request.getParameter("region");
			InputStream imageStream = image.getInputStream();
			byte[] byteArray = imageStream.readAllBytes();
			String imageString = Base64.getEncoder().encodeToString(byteArray);
			String imageData = imageString;
			System.out.println("これが"+imageString);
			//商品情報が入力されていなければ、エラー
			if(name.equals("")) {
				
				error = "商品名が入力されていません。";
				cmd = "出品画面に戻る";
				link = "view/exhibitScreen.jsp";
				
			}else if(price.equals("")) {
				
				error = "価格が入力されていません";
				cmd = "出品画面に戻る";
				link = "view/exhibitScreen.jsp";
				
			}else if(region.equals("")){
				
				error = "地域が入力されていません";
				cmd = "出品画面に戻る";
				link = "view/exhibitScreen.jsp";
				
			}else if(Integer.parseInt(price) < 500) {
				
				error = "500円以上で出品してください。";
				cmd = "出品画面に戻る";
				link = "view/exhibitScreen.jsp";
				
			}else {
				
				item.setName(name);
				item.setRemark(remark);
				item.setPrice(Integer.parseInt(price));
				item.setProducerId(user.getUserId());
				item.setRegion(region);
				item.setImage(imageString);
				System.out.println("1+"+item.getImage());
				itemObjDao.insert(item);
			}
		
			request.setAttribute("item",item);
			
		}catch(IllegalStateException e) {
			
			error = "DB接続エラーの為、出品は行えませんでした。";
			cmd = "ログイン画面に戻る";
			link = "login";
			
		}catch(NumberFormatException e) {
			error = "価格の値が不正の為、出品は行えませんでした。";
			cmd = "出品画面に戻る";
			link = "view/exhibitScreen.jsp";
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			//フォワード処理
			if(error.equals("")) {
				
				response.sendRedirect(request.getContextPath() + "/userMenu");
			}else {
				
				request.setAttribute("error",error);
				request.setAttribute("cmd",cmd);
				request.setAttribute("link",link);
				
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				
			}
			
		}
	}
}
