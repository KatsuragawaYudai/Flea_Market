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
	
	
	public Trade selectByItemId(int itemId) {
		String sql = """
			SELECT 
			a.trade_id, a.producer_id, a.customer_id, 
			x.name AS producer, y.name AS customer, 
			z.name AS item, trade_status, payment, earning, 
			start_time, update_time, a.item_id
			FROM tradeinfo a
			INNER JOIN userinfo x ON producer_id=x.user_id 
			INNER JOIN userinfo y ON customer_id=y.user_id 
			INNER JOIN iteminfo z ON a.item_id=?;
			""";
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, itemId);
			Trade trade = new Trade();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				registerTradeData(trade, rs);
				if (!rs.next()) {
					return trade;
				}
			}
			return trade;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	public ArrayList<Trade> selectByItemIdExt(int producerId) {
		String sql = """
			SELECT
			a.item_id,
			a.producer_id,
			b.customer_id,
			x.name AS producer,
			y.name AS customer,
			a.name AS item,
			trade_status, a.price AS payment, earning, start_time, update_time, b.trade_id
			FROM iteminfo a
			LEFT OUTER JOIN tradeinfo b ON a.item_id=b.item_id
			INNER JOIN userinfo x ON a.producer_id=x.user_id
			LEFT OUTER JOIN userinfo y ON b.customer_id=y.user_id
			WHERE a.producer_id=?;
			""";
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
	
	public ArrayList<Trade> selectByTradeStatus(int tradeStatus) {
		String sql = """
			SELECT
			a.item_id,
			a.producer_id,
			b.customer_id,
			x.name AS producer,
			y.name AS customer,
			a.name AS item,
			trade_status, a.price AS payment, earning, start_time, update_time, b.trade_id
			FROM iteminfo a
			LEFT OUTER JOIN tradeinfo b ON a.item_id=b.item_id
			INNER JOIN userinfo x ON a.producer_id=x.user_id
			LEFT OUTER JOIN userinfo y ON b.customer_id=y.user_id
			WHERE b.trade_status=?;
			""";
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, tradeStatus);
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
	
	public Trade selectByTradeId(int tradeId) {
		String sql = """
			SELECT 
			a.trade_id, a.producer_id, a.customer_id, 
			x.name AS producer, y.name AS customer, 
			z.name AS item, trade_status, payment, earning, 
			start_time, update_time, a.item_id 
			FROM tradeinfo a
			INNER JOIN userinfo x ON producer_id=x.user_id 
			INNER JOIN userinfo y ON customer_id=y.user_id 
			INNER JOIN iteminfo z ON a.item_id=z.item_id AND a.trade_id=?;
			""";
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, tradeId);
			Trade trade = new Trade();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				registerTradeData(trade, rs);
				if (!rs.next()) {
					return trade;
				}
			}
			// 対象のitemIdがない場合
			throw new RuntimeException();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
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
	
	public int updateByTradeId(Trade trade) {
		String sql = """
			UPDATE %s SET trade_status=?, payment=?, earning=? WHERE trade_id=?
			""".formatted(TRADE_TABLE);
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)
		) {
			ps.setInt(1, trade.getTradeStatus());
			ps.setInt(2, trade.getPayment());
			ps.setInt(3, trade.getEarning());
			ps.setInt(4, trade.getTradeId());
			int ret = ps.executeUpdate();
			System.out.println("test" + ret);
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	public int deleteByItemId(int itemId) {
		String sql = """
			DELETE FROM %s WHERE item_id=?
			""".formatted(TRADE_TABLE);
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql)
		) {
			ps.setInt(1, itemId);
			int ret = ps.executeUpdate();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	private Trade registerTradeData(Trade trade, ResultSet rs) throws SQLException {
		trade.setProducerId(rs.getInt("producer_id"));
		trade.setItemId(rs.getInt("item_id"));
		trade.setPayment(rs.getInt("payment"));

		trade.setProducer(rs.getString("producer"));
		trade.setCustomer(rs.getString("customer"));
		trade.setItem(rs.getString("item"));
		trade.setStartTime(rs.getString("start_time"));
		trade.setUpdateTime(rs.getString("update_time"));

		if(rs.getString("trade_id") != null) {
			trade.setTradeId(rs.getInt("trade_id"));
			trade.setTradeStatus(rs.getInt("trade_status"));
			trade.setCustomerId(rs.getInt("customer_id"));
			trade.setEarning(rs.getInt("earning"));
		}
		return trade;
	}
	
}
