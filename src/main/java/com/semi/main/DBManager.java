package com.semi.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	public static Connection connect() throws SQLException {
		// 수현
	//	String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=/Users/breakki/Wallet_DB202204301707";
		// 동우

//		String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=C:/ldw/Wallet_DB202204301707";

		// 태형
//		String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=C:/ldw/Wallet_DB202204301707";
		// 준우

		String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=C:/sjw/Wallet_DB202204301707";

		return DriverManager.getConnection(url, "SHMAC", "SHsoldesk802");

	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
