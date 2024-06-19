package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Trade;

public class TradeDao extends DaoAbstract {
	private static final String TRADE_TABLE = "tradeinfo";
//	private static final String USER_TABLE = "userinfo";
	
	public ArrayList<Trade> selectAll() {
		String sql = """
			SELECT 
			a.trade_id, a.producer_id, a.customer_id, 
			x.name AS producer, y.name AS customer, 
			z.name AS item, trade_status, payment, earning, 
			start_time, update_time, a.item_id 
			FROM tradeinfo a
			INNER JOIN userinfo x ON producer_id=x.user_id 
			INNER JOIN userinfo y ON customer_id=y.user_id 
			INNER JOIN iteminfo z ON a.item_id=z.item_id;
			""";
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ResultSet rs = ps.executeQuery();
			ArrayList<Trade> tradeList = new ArrayList<>();
			while (rs.next()) {
				Trade trade = new Trade();
				registerTradeData(trade, rs);
				tradeList.add(trade);
			}
			return tradeList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	
//	public ArrayList<Trade> selectAll() {
//		String sql = """
//			SELECT * FROM %s 
//			""".formatted(TRADE_TABLE);
//		
//		try (
//			Connection con = getConnection();
//			PreparedStatement ps = con.prepareStatement(sql);
//		) {
//			ResultSet rs = ps.executeQuery();
//			ArrayList<Trade> tradeList = new ArrayList<>();
//			while (rs.next()) {
//				Trade trade = new Trade();
//				registerTradeData(trade, rs);
//				tradeList.add(trade);
//			}
//			return tradeList;
//		} catch(SQLException e) {
//			e.printStackTrace();
//			throw new IllegalStateException();
//		}
//	}
	
	public ArrayList<Trade> selectByProducerId(int producerId) {
		String sql = """
			SELECT 
			a.trade_id, a.producer_id, a.customer_id, 
			x.name AS producer, y.name AS customer, 
			z.name AS item, trade_status, payment, earning, 
			start_time, update_time, a.item_id 
			FROM tradeinfo a
			INNER JOIN userinfo x ON producer_id=x.user_id 
			INNER JOIN userinfo y ON customer_id=y.user_id 
			INNER JOIN iteminfo z ON a.item_id=z.item_id AND a.producer_id=?;
			""";
//		String sql = """
//			SELECT * FROM %s WHERE producer_id=?
//			""".formatted(TRADE_TABLE);
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, producerId);
			ResultSet rs = ps.executeQuery();
			ArrayList<Trade> tradeList = new ArrayList<>();
			while (rs.next()) {
				Trade trade = new Trade();
				registerTradeData(trade, rs);
				tradeList.add(trade);
			}
			return tradeList;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	public ArrayList<Trade> selectByCustomerId(int customerId) {
		String sql = """
			SELECT 
			a.trade_id, a.producer_id, a.customer_id, 
			x.name AS producer, y.name AS customer, 
			z.name AS item, trade_status, payment, earning, 
			start_time, update_time, a.item_id 
			FROM tradeinfo a
			INNER JOIN userinfo x ON producer_id=x.user_id 
			INNER JOIN userinfo y ON customer_id=y.user_id 
			INNER JOIN iteminfo z ON a.item_id=z.item_id AND a.customer_id=?;
			""";
//		String sql = """
//			SELECT * FROM %s WHERE customer_id=?
//			""".formatted(TRADE_TABLE);
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			ArrayList<Trade> tradeList = new ArrayList<>();
			while (rs.next()) {
				Trade trade = new Trade();
				registerTradeData(trade, rs);
				tradeList.add(trade);
			}
			return tradeList;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	/** 挿入に成功していればreturn 1 */
	public int insert(Trade trade) {
		String sql = """
			INSERT INTO %s
			(producer_id, customer_id, item_id, trade_status, payment, earning)
			VALUE(?, ?, ?, ?, ?, ?)
			""".formatted(TRADE_TABLE);
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)
		) {
			ps.setInt(1, trade.getProducerId());
			ps.setInt(2, trade.getCustomerId());
			ps.setInt(3, trade.getItemId());
			ps.setInt(4, trade.getTradeStatus());
			ps.setInt(5, trade.getPayment());
			ps.setInt(6, trade.getEarning());
			int ret = ps.executeUpdate();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	private Trade registerTradeData(Trade trade, ResultSet rs) throws SQLException {
		trade.setTradeId(rs.getInt("trade_id"));
		trade.setProducerId(rs.getInt("producer_id"));
		trade.setProducer(rs.getString("producer"));
		trade.setCustomerId(rs.getInt("customer_id"));
		trade.setCustomer(rs.getString("customer"));
		trade.setItemId(rs.getInt("item_id"));
		trade.setItem(rs.getString("item"));
		trade.setTradeStatus(rs.getInt("trade_status"));
		trade.setPayment(rs.getInt("payment"));
		trade.setEarning(rs.getInt("earning"));
		trade.setStartTime(rs.getString("start_time"));
		trade.setUpdateTime(rs.getString("update_time"));
		return trade;
	}
	
}
