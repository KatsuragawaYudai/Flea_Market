package daoTest;

import java.util.ArrayList;

import bean.Trade;
import bean.User;
import dao.TradeDao;
import dao.UserDao;

public class DaoTest {
	public static void main(String[] args) {

		TradeDao dao = new TradeDao();
		ArrayList<Trade> td = dao.selectByItemIdExt(2);
		for(Trade ttt: td) {
			System.out.println(ttt.getTradeStatus());
		}
	}

	public static void insertUserTest(User user) {
		UserDao dao = new UserDao();
		user.setName("本名");
		user.setNickname("表示名");
		user.setAddress("住所");
		user.setPassword("password");
		user.setEmail("email");
		user.setAuthority(1);
		dao.insert(user);
		System.out.println("ok");
		return;
	}
}
