package com.giffgaff.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.time.Duration;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import org.junit.Test;

import junit.framework.Assert;

public class PerformanceTest {

	@Test
	public void fetch_perfomance_test() {

		try {
			assertTimeout(Duration.ofSeconds(1), () -> {
				Connection conn = MysqlConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("select * from customer order by create_date desc");
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					// Thread.sleep(1); it will fail if
					System.out.print(
							rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getString(3) + "\t" + rs.getString(8));
					System.out.println();
				}
			});

			MysqlConnection.closeConnection();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

	}

	@Test(expected = NullPointerException.class)
	public void fetchData_Exception_Test() throws SQLException {

		// Connection conn = MysqlConnection.getConnection();
		Connection conn = null;
		PreparedStatement ps = conn.prepareStatement("select * from customer order by create_date desc");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getString(3) + "\t" + rs.getString(8));
			System.out.println();
		}

		MysqlConnection.closeConnection();
	}

	@Test
	public void testSetTime() throws Throwable {
		Date testObject = new Date();
		testObject.setTime(100000L);
		assertEquals(100000L, testObject.getTime());
	}

	@Test
	public void use_dictionary_test() {

		try {
			Dictionary dictionary = new Hashtable();

			assertTimeout(Duration.ofSeconds(1), () -> {
				Connection conn = MysqlConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("select * from customer order by create_date desc");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					dictionary.put(rs.getInt(1), rs.getString(8));
				}
			});
			assertNotNull(dictionary);

			for (Enumeration e = dictionary.elements(); e.hasMoreElements();) // Enumeration elements
				// System.out.println(""+e.nextElement() + " ");
				assertNotNull(e.nextElement());

			MysqlConnection.closeConnection();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

	}

}
