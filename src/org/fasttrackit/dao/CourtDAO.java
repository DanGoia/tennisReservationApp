package org.fasttrackit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.fasttrackit.helpers.DBHelpers;
import org.fasttrackit.pojo.Court;

public class CourtDAO {

	// insert court
	// delete court
	// show court availability

	public void insertCourt(Court c) throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();// creezi obiect conexiune
		Connection con = helper.getConnection();// initiezi conexiunea
		String insertCourt = "insert into court(court_number,court_surface)" + "values(?,?)";// string insert SQL
		PreparedStatement ps = con.prepareStatement(insertCourt);// trimite datele catre baza de date SQL, e preferat
																	// prepared statement
		ps.setInt(1, c.getCourtNumber());
		ps.setString(2, c.getCourtSurface());
		ps.executeUpdate();
		helper.closeConnection(con);
	}

	public void deleteCourt(Court c) throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		String deleteCourt = "delete from court where court_number=?";
		PreparedStatement ps = con.prepareStatement(deleteCourt);
		ps.setInt(1, c.getCourtNumber());
		ps.executeUpdate();

		helper.closeConnection(con);
	}

	public ArrayList<Court> getCourts() throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		ArrayList<Court> showCourts = new ArrayList<Court>();

		// se compune String pentru import din SQL
		String sqlShowCourt = "select * from tennis_app.court ORDER BY court_number ASC";
		// se creeaza interogarea SQL
		Statement stmt = con.createStatement();
		// se obtine rezultatul din baza prin ResultSet
		ResultSet rs = stmt.executeQuery(sqlShowCourt);

		while (rs.next()) {

			int id = rs.getInt("id_court");
			int courtNumber = rs.getInt("court_number");
			String courtSurface = rs.getString("court_surface");
			String courtType = rs.getString("court_type");
			Court c = new Court(id, courtNumber, courtSurface, courtType);
			showCourts.add(c);

		}
		helper.closeConnection(con);
		return showCourts;

	}

	public void updateCourt(Court c) throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();

		String updateCourt = "update court set court_number=?,court_surface=?,court_type=? where id_court=?";

		PreparedStatement ps = con.prepareStatement(updateCourt);

		ps.setInt(1, c.getCourtNumber());
		ps.setString(2, c.getCourtSurface());
		ps.setString(3, c.getCourtType());
		ps.setInt(4, c.getId());
		ps.executeUpdate();
		helper.closeConnection(con);
		;

	}

	public Court getCourtbyId(int id) throws SQLException, ClassNotFoundException {

		Court result = null;
		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from Court where id_court=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			int courtNumber = rs.getInt("court_number");
			String courtSurface = rs.getString("court_surface");
			String courtType = rs.getString("court_type");

			result = new Court(id, courtNumber, courtSurface, courtType);

		}
		helper.closeConnection(con);
		return result;
	}

	public void deleteCourtByID(int id) throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		String deleteCourt = "delete from court where id_court=? ";
		PreparedStatement ps = con.prepareStatement(deleteCourt);
		ps.setInt(1, id);
		ps.executeUpdate();

		helper.closeConnection(con);

	}
}
