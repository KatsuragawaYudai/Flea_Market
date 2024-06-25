package servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userInsert")
public class UserInsertServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String cmd = "";
		String link = "";

		try {

			User objUser = new User();
			UserDao objUserDao = new UserDao();

			String username = request.getParameter("name");
			String nickname = request.getParameter("nickname");
			String address = request.getParameter("address");
			String mail = request.getParameter("email");
			String pass = request.getParameter("password");

			if (pass.equals("")) {

				error = "パスワードが入力されていません";
				cmd = "ユーザー登録画面に戻る";
				link = "view/userInsert.jsp";
				return;
			}
			//パスワードの制約の判定
			if (!checkLength(pass)) {

				error = "パスワードの長さの要件を満たしていません。";
				cmd = "ユーザー登録画面に戻る";
				link = "view/userInsert.jsp";
				return;
			}
			if (!checkPassStyle(pass)) {

				error = "半角英数字以外の文字が含まれています。";
				cmd = "ユーザー登録画面に戻る";
				link = "view/userInsert.jsp";
				return;
			}
			if (!containCapitalLetter(pass)) {

				error = "大文字が含まれていません。";
				cmd = "ユーザー登録画面に戻る";
				link = "view/userInsert.jsp";
				return;
			}
			if (!containSmallLetter(pass)) {

				error = "小文字が含まれていません。";
				cmd = "ユーザー登録画面に戻る";
				link = "view/userInsert.jsp";
				return;
			}
			if (!containNumber(pass)) {

				error = "数字が含まれていません。";
				cmd = "ユーザー登録画面に戻る";
				link = "view/userInsert.jsp";
				return;
			}

			//入力されているか判定
			if (username.equals("")) {

				error = "本名が入力されていません。";
				cmd = "ユーザー登録画面に戻る";
				link = "view/userInsert.jsp";

			} else if (nickname.equals("")) {

				error = "ニックネームが入力されていません。";
				cmd = "ユーザー登録画面に戻る";
				link = "view/userInsert.jsp";

			} else if (address.equals("")) {

				error = "住所が入力されていません。";
				cmd = "ユーザー登録画面に戻る";
				link = "view/userInsert.jsp";

			} else if (mail.equals("")) {

				error = "メールアドレスが入力されていません";
				cmd = "ユーザー登録画面に戻る";
				link = "view/userInsert.jsp";

			} else {

				objUser.setName(username);
				objUser.setNickname(nickname);
				objUser.setAddress(address);
				objUser.setEmail(mail);
				objUser.setPassword(pass);
				objUser.setAuthority(1);

				objUserDao.insert(objUser);

			}

		} catch (IllegalStateException e) {

			error = "DB接続エラーの為、出品は行えませんでした。";
			cmd = "ログイン画面に戻る";
			link = "login";

		} finally {

			if (error.equals("")) {

				request.getRequestDispatcher("/view/login.jsp").forward(request, response);

			} else {

				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.setAttribute("link", link);

				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}

		}
	}

	private static boolean checkLength(String pass) {
		boolean length = true;
		if (pass.length() <= 8) {
			length = false;
		}
		return length;
	}

	private static boolean checkPassStyle(String pass) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
		Matcher m = pattern.matcher(pass);
		return m.find();
	}

	private static boolean containCapitalLetter(String pass) {
		Pattern pattern = Pattern.compile("[A-Z]+");
		Matcher m = pattern.matcher(pass);
		return m.find();
	}

	private static boolean containSmallLetter(String pass) {
		Pattern pattern = Pattern.compile("[a-z]+");
		Matcher m = pattern.matcher(pass);
		return m.find();
	}

	private static boolean containNumber(String pass) {
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher m = pattern.matcher(pass);
		return m.find();
	}
}