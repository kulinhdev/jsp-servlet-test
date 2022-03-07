package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import connect.BkConnection;
import utils.Mobile;

public class ImplMobileDAO implements IMobileDAO {

	public ImplMobileDAO() {
	}

	@Override
	public List<Mobile> selectAll(String sql) {
		Connection con = BkConnection.GetConnection();
		try {
			PreparedStatement pstt = con.prepareStatement(sql);
			ResultSet rs = pstt.executeQuery();

			List<Mobile> listMobile = new LinkedList<Mobile>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String warranty = rs.getString("warranty");
				boolean status = rs.getBoolean("status");
				String accessory = rs.getString("accessory");
				String image = rs.getString("image");

				Mobile m = new Mobile(id, name, price, status, warranty, accessory, image);

				listMobile.add(m);
			}

			return listMobile;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean insert(Mobile e) {
		Connection con = BkConnection.GetConnection();
		String insertSql = "INSERT INTO Mobile VALUES " + "(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstt;
		try {
			pstt = con.prepareStatement(insertSql);
			pstt.setInt(1, e.getId());
			pstt.setNString(2, e.getName());
			pstt.setFloat(3, e.getPrice());
			pstt.setBoolean(4, e.isStatus());
			pstt.setNString(5, e.getWarranty());
			pstt.setNString(6, e.getAccessory());
			pstt.setString(7, e.getImage());

			return pstt.executeUpdate() > 0;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return false;
	}

	@Override
	public Mobile findById(int findId) {
		Connection con = BkConnection.GetConnection();
		String findSql = "SELECT * FROM Mobile WHERE id = ?" + " ORDER BY id desc";
		try {
			PreparedStatement pstt = con.prepareStatement(findSql);
			pstt.setInt(1, findId);
			ResultSet rs = pstt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String warranty = rs.getString("warranty");
				boolean status = rs.getBoolean("status");
				String accessory = rs.getString("accessory");
				String image = rs.getString("image");

				Mobile m = new Mobile(id, name, price, status, warranty, accessory, image);

				return m;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean update(Mobile e) {
		Connection con = BkConnection.GetConnection();
		String updateSql = "UPDATE Mobile SET " + "name = ?, " + "price = ?, " + "status = ?, " + "warranty = ?,"
				+ "	accessory = ?, " + "image = ? " + "WHERE id = ?";
		PreparedStatement pstt;
		try {
			pstt = con.prepareStatement(updateSql);
			pstt.setNString(1, e.getName());
			pstt.setFloat(2, e.getPrice());
			pstt.setBoolean(3, e.isStatus());
			pstt.setNString(4, e.getWarranty());
			pstt.setNString(5, e.getAccessory());
			pstt.setString(6, e.getImage());
			pstt.setInt(7, e.getId());

			return pstt.executeUpdate() > 0;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(int deleteId) {
		Connection con = BkConnection.GetConnection();
		String  deleteSql = "DELETE Mobile WHERE id = ?";
		PreparedStatement pstt;
		try {
			pstt = con.prepareStatement(deleteSql);
			pstt.setInt(1, deleteId);

			return pstt.executeUpdate() > 0;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}


		return false;
	}

}
