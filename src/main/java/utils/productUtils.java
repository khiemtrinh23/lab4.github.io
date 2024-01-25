package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Product;

public class productUtils {

	//Đọc danh sách sản phẩm
		public static List<Product> queryProduct(Connection conn)
				throws SQLException {
			String sql = "Select * from PRODUCT  ";
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				List<Product> list = new ArrayList<Product>();
				while (rs.next()) {
					String code = rs.getString("CODE");
					String name = rs.getString("NAME");
					float price = rs.getFloat("FRICE");
					Product product = new Product();
					product.setCODE(code);
					product.setNAME(name);
					product.setFRICE(price);
					list.add(product);
				}
				return list;
		}
// Tìm kiếm theo mã sản phẩm (code)
		public static Product findProduct(Connection conn, String code) throws SQLException {
			String sql = "Select a.CODE, a.NAME, a.FRICE from PRODUCT a where a.CODE=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, code);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String name = rs.getString("NAME");
				float price = rs.getFloat("FRICE");
				Product product = new Product(code, name, price);
				return product;
			}
			return null;
		}
// Thêm mới sản phẩm
		public static void inserProduct(Connection conn, Product product)
				throws SQLException {
			String sql = "Inset into Product(CODE, NAME, PRICE) values (?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, product.getCODE());
			pstm.setString(2, product.getNAME());
			pstm.setFloat(3, product.getFRICE());
			pstm.executeUpdate();
		}
// Cập nhật 1 sản phẩm
		public static void updateProduct(Connection conn, Product product)
				throws SQLException {
			String sql = "Update Product set NAME = ?, FRICE=? shere CODE=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, product.getNAME());
			pstm.setFloat(2, product.getFRICE());
			pstm.setString(3, product.getCODE());
			pstm.executeUpdate();
		}
//Xóa 1 sản phẩm
		public static void deleteProduct(Connection conn, String code)
				throws SQLException {
			String sql = "Delete From Product where CODE= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, code);
			pstm.executeUpdate();
		}
}
