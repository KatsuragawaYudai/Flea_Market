package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Item;

public class ItemDao extends DaoAbstract {
	private static final String ITEM_TABLE = "iteminfo";
	
	/** item_status(ステータスで)抽出*/
	public ArrayList<Item> selectByItemStatus(int itemStatus) {
		String sql = """
			SELECT x.item_id, x.name, x.producer_id, y.name AS producer, x.item_status, x.price, x.remark, x.region, x.image
			FROM iteminfo x INNER JOIN userinfo y ON x.producer_id=y.user_id AND item_status=?;		
			""";
		
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, itemStatus);
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
	
	/** 商品名（曖昧）、地域（曖昧）、備考（曖昧）をandで検索する*/
	public ArrayList<Item> searchByNameAndRegionAndRemark(String name, String region, String remark) {
		String sql = """
			SELECT x.item_id, x.name, x.producer_id, y.name AS producer, x.item_status, x.price, x.remark, x.region, x.image
			FROM iteminfo x INNER JOIN userinfo y ON x.producer_id=y.user_id 
			WHERE x.name LIKE ? AND x.region LIKE ? AND x.remark LIKE ?;		
			""";
		
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			name = "%" + name + "%";
			region = "%" + region + "%";
			remark = "%" + remark + "%";
			ps.setString(1, name);
			ps.setString(2, region);
			ps.setString(3, remark);
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
	
	/** 挿入が無ければ item.id=-1のインスタンス */
	public Item selectByItemId(int itemId) {
		String sql = """
			SELECT x.item_id, x.name, x.producer_id, y.name AS producer, x.item_status, x.price, x.remark, x.region, x.image
			FROM iteminfo x INNER JOIN userinfo y ON x.producer_id=y.user_id AND x.item_id=?;		
			""";
		
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, itemId);
			Item item = new Item();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				registerItemData(item, rs);
				if (!rs.next()) {
					return item;				
				}
			}
			// 対象のitemIdがない場合
			throw new RuntimeException();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	/**  全出品(取引終了済み含め)一覧を表示 */
	public ArrayList<Item> selectAll() {
		String sql ="""
			SELECT x.item_id, x.name, x.producer_id, y.name AS producer, x.item_status, x.price, x.remark, x.region, x.image
			FROM iteminfo x INNER JOIN userinfo y ON x.producer_id=y.user_id;		
			""";
		
		
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
		String sql ="""
			SELECT x.item_id, x.name, x.producer_id, y.name AS producer, x.item_status, x.price, x.remark, x.region, x.image
			FROM iteminfo x INNER JOIN userinfo y ON x.producer_id=y.user_id AND x.producer_id=?;		
			""";
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
		String sql ="""
			SELECT x.item_id, x.name, x.producer_id, y.name AS producer, x.item_status, x.price, x.remark, x.region, x.image
			FROM iteminfo x INNER JOIN userinfo y ON x.producer_id=y.user_id AND x.customer_id=?
			""";
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
		String sql ="""
			SELECT x.item_id, x.name, x.producer_id, y.name AS producer, x.item_status, x.price, x.remark, x.region, x.image
			FROM iteminfo x INNER JOIN userinfo y ON x.producer_id=y.user_id AND x.name LIKE ?
			""";
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
			INSERT INTO %s(name, remark, price, producer_id, region,image) VALUES(?, ?, ?, ?, ?,?)
			""".formatted(ITEM_TABLE);
		
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, item.getName());
			ps.setString(2, item.getRemark());
			ps.setInt(3, item.getPrice());
			ps.setInt(4, item.getProducerId());
			ps.setString(5, item.getRegion());
			ps.setString(6, item.getImage());
			int ret = ps.executeUpdate();
			return ret;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	/** 出品情報の登録 */
	// 成功していればreturn 1;
	public int delete(int itemId) {
		String sql = """
			DELETE FROM %s WHERE item_id=?
			""".formatted(ITEM_TABLE);
		
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, itemId);
			int ret = ps.executeUpdate();
			return ret;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	public int updateByItemId(Item item) {
		String sql = """
			UPDATE %s  SET name=?, remark=?, price=?, item_status=?, region=?, image=? WHERE item_id=?
			""".formatted(ITEM_TABLE);
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, item.getName());
			ps.setString(2, item.getRemark());
			ps.setInt(3, item.getPrice());
			ps.setInt(4, item.getItemStatus());
			ps.setString(5, item.getRegion());
			ps.setString(6, item.getImage());
			ps.setInt(7, item.getItemId());
			int ret = ps.executeUpdate();
			return ret;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
	
	public int deleteByItemId(int itemId) {
		String sql = """
			DELETE FROM %s WHERE item_id=?
			""".formatted(ITEM_TABLE);
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
	
	private Item registerItemData(Item item, ResultSet rs) throws SQLException {
		item.setItemId(rs.getInt("item_id"));
		item.setName(rs.getString("name"));
		item.setProducerId(rs.getInt("producer_id"));
		item.setProducer(rs.getString("producer"));
		item.setItemStatus(rs.getInt("item_status"));
		item.setPrice(rs.getInt("price"));
		item.setRemark(rs.getString("remark"));
		item.setRegion(rs.getString("region"));
		item.setImage(rs.getString("image"));
		return null;
	}
}
