package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Item;

public class ItemDao extends DaoAbstract {
	private static final String ITEM_TABLE = "iteminfo";
	
	/** trade_status(ステータスで)抽出*/
	public ArrayList<Item> selectByTradeStatus(int tradeStatus) {
		String sql = """
			SELECT * FROM %s WHERE trade_status=?
			""".formatted(ITEM_TABLE);
		
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, tradeStatus);
			ResultSet rs = ps.executeQuery();
			ArrayList<Item> itemList = new ArrayList<>();
			while (rs.next()) {
				Item item = new Item();
				registerItemData(item, rs);
				itemList.add(item);
			}
			return itemList;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	/**  全出品(取引終了済み含め)一覧を表示 */
	public ArrayList<Item> selectAll() {
		String sql = """
			SELECT * FROM %s
			""".formatted(ITEM_TABLE);
		
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ResultSet rs = ps.executeQuery();
			ArrayList<Item> itemList = new ArrayList<>();
			while (rs.next()) {
				Item item = new Item();
				registerItemData(item, rs);
				itemList.add(item);
			}
			return itemList;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	/**  ユーザの出品一覧を取得 */
	public ArrayList<Item> selectByProducerId(int userId) {
		String sql = """
			SELECT * FROM %s WHERE producer_id=?
			""".formatted(ITEM_TABLE);
		
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			ArrayList<Item> itemList = new ArrayList<>();
			while (rs.next()) {
				Item item = new Item();
				registerItemData(item, rs);
				itemList.add(item);
			}
			return itemList;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	/**  ユーザの購入一覧を取得 */
	public ArrayList<Item> selectByCustomerId(int customerId) {
		String sql = """
			SELECT * FROM %s WHERE customer_id=?
			""".formatted(ITEM_TABLE);
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			ArrayList<Item> itemList = new ArrayList<>();
			while (rs.next()) {
				Item item = new Item();
				registerItemData(item, rs);
				itemList.add(item);
			}
			return itemList;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	/** 商品の検索 */
	public ArrayList<Item> searchByName(String name) {
		String sql = """
			SELECT * FROM %s WHERE name=?
			""".formatted(ITEM_TABLE);
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			String searchWord = "%" + name + "%";
			ps.setString(1, searchWord);
			ResultSet rs = ps.executeQuery();
			ArrayList<Item> itemList = new ArrayList<>();
			while (rs.next()) {
				Item item = new Item();
				registerItemData(item, rs);
				itemList.add(item);
			}
			return itemList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	
	/** 出品情報の登録 */
	// 成功していればreturn 1;
	public int insert(Item item) {
		String sql = """
			INSERT INTO %s VALUES(?, ?, ?, ?)
			""".formatted(ITEM_TABLE);
		
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, item.getName());
			ps.setString(2, item.getRemark());
			ps.setInt(3, item.getPrice());
			ps.setInt(3, item.getProducerId());
			int ret = ps.executeUpdate();
			return ret;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	
	
	enum ColumnNames {
		name,
		remark,
		price,
		producerId;
	}
	
	private Item registerItemData(Item item, ResultSet rs) throws SQLException {
		item.setItemId(rs.getInt("item_id"));
		item.setName(rs.getString("name"));
		item.setRemark(rs.getString("remark"));
		item.setPrice(rs.getInt("price"));
		item.setProducerId(rs.getInt("producer_id"));
		return null;
	}
}
