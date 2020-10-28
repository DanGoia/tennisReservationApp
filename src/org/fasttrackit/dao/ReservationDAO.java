package org.fasttrackit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.fasttrackit.helpers.DBHelpers;
import org.fasttrackit.pojo.Court;
import org.fasttrackit.pojo.Player;
import org.fasttrackit.pojo.Reservation;

public class ReservationDAO {

	// insert booking
	// delete booking
	// update booking
	// show bookings

	public void insertReservation(Reservation r) throws ClassNotFoundException, SQLException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();

		String insertReservation = "insert into reservation (year,month,day,reservation_hour,reservation_minute,hours_booked,id_court,id_player)"
				+ " values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertReservation);
		ps.setInt(1, r.getYear());
		ps.setInt(2, r.getMonth());
		ps.setInt(3, r.getDay());
		ps.setInt(4, r.getHourOfReservation());
		ps.setInt(5, r.getMinuteOfReservation());
		ps.setInt(6, r.getHoursBooked());
		ps.setInt(7, r.getCourtNumber().getId());
		ps.setInt(8, r.getP().getId());

		ps.executeUpdate();
		helper.closeConnection(con);
	}

	public void deleteReservation(Reservation r) throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		String deleteReservation = "delete from reservation where id=?";
		PreparedStatement ps = con.prepareStatement(deleteReservation);
		ps.setInt(1, r.getId());
		ps.executeUpdate();

		helper.closeConnection(con);
	}

	public void updateReservation(Reservation r) throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		String updateReservation = "update reservation set year=?,month=?,day=?, reservation_hour=?,reservation_minute=?,hours_booked=?,id_court=?,id_player=? where id_reservation=?";
		PreparedStatement ps = con.prepareStatement(updateReservation);

		ps.setInt(1, r.getYear());
		ps.setInt(2, r.getMonth());
		ps.setInt(3, r.getDay());
		ps.setInt(4, r.getHourOfReservation());
		ps.setInt(5, r.getMinuteOfReservation());
		ps.setInt(6, r.getHoursBooked());
		ps.setInt(7, r.getCourtNumber().getId());
		ps.setInt(8, r.getP().getId());
		ps.setInt(9, r.getId());

		ps.executeUpdate();
		helper.closeConnection(con);
	}

	public ArrayList<Reservation> getReservationList() throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		ArrayList<Reservation> reservationList = new ArrayList<Reservation>();

		String createTable =

				"create temporary table reservation_list\r\n"
						+ "				select tennis_app.reservation.id_reservation,tennis_app.reservation.year,tennis_app.reservation.month,tennis_app.reservation.day,tennis_app.reservation.reservation_hour,\r\n"
						+ "				tennis_app.reservation.reservation_minute, + tennis_app.reservation.hours_booked,\r\n"
						+ "				tennis_app.court.court_number, + tennis_app.court.id_court, + tennis_app.player.first_name,\r\n"
						+ "				tennis_app.player.last_name, + tennis_app.player.id_player\r\n"
						+ "				from tennis_app.reservation,tennis_app.court,tennis_app.player\r\n"
						+ "				where ((tennis_app.reservation.id_court = tennis_app.court.id_court)\r\n"
						+ "					AND (tennis_app.reservation.id_player=tennis_app.player.id_player));\r\n";

		Statement stmt = con.createStatement();
		stmt.executeUpdate(createTable);// de ce trebuie creata o a 2 obiect de tip statement??nu merge acelasi pentru 2
										// operatiuni???

		Statement stmt2 = con.createStatement();
		String getTable = "select*from reservation_list order by reservation_list.year ASC, reservation_list.month ASC  ";
		ResultSet rs = stmt2.executeQuery(getTable);

		while (rs.next()) {

			int id = rs.getInt("id_reservation");
			int year = rs.getInt("year");
			int month = rs.getInt("month");
			int day = rs.getInt("day");
			int reservationHour = rs.getInt("reservation_hour");
			int reservationMinute = rs.getInt("reservation_minute");
			int hoursBooked = rs.getInt("hours_booked");
			int courtNumber = rs.getInt("court_number");
			String firstName = rs.getNString("first_name");
			String lastName = rs.getString("last_name");

			Player p;
			Court c;
			Reservation r = new Reservation(id, c = new Court(), year, month, day, reservationHour, reservationMinute,
					hoursBooked, p = new Player());

			c.setCourtNumber(courtNumber);
			p.setFirstName(firstName);
			p.setLastName(lastName);

			reservationList.add(r);

		}
		helper.closeConnection(con);
		return reservationList;
	}

	public Reservation getReservationById(int idReservation) throws SQLException, ClassNotFoundException {

		Reservation result = null;
		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();

		String createTable =

				"create temporary table reservation_list\r\n"
						+ "				select tennis_app.reservation.id_reservation,tennis_app.reservation.year,tennis_app.reservation.month,tennis_app.reservation.day,tennis_app.reservation.reservation_hour,\r\n"
						+ "				tennis_app.reservation.reservation_minute, + tennis_app.reservation.hours_booked,\r\n"
						+ "				tennis_app.court.court_number, + tennis_app.court.id_court, + tennis_app.player.first_name,\r\n"
						+ "				tennis_app.player.last_name, + tennis_app.player.id_player\r\n"
						+ "				from tennis_app.reservation,tennis_app.court,tennis_app.player\r\n"
						+ "				where ((tennis_app.reservation.id_court = tennis_app.court.id_court)\r\n"
						+ "					AND (tennis_app.reservation.id_player=tennis_app.player.id_player));\r\n";

		Statement stmt = con.createStatement();
		stmt.executeUpdate(createTable);// de ce trebuie creata o a 2 obiect de tip statement??nu merge acelasi pentru 2
										// operatiuni???

		String sqlString = "select*from reservation_list where id_reservation=?";
		PreparedStatement stmt2 = con.prepareStatement(sqlString);
		stmt2.setInt(1, idReservation);
		ResultSet rs = stmt2.executeQuery();

		if (rs.next()) {

			int id = rs.getInt("id_reservation");
			int year = rs.getInt("year");
			int month = rs.getInt("month");
			int day = rs.getInt("day");
			int reservationHour = rs.getInt("reservation_hour");
			int reservationMinute = rs.getInt("reservation_minute");
			int hoursBooked = rs.getInt("hours_booked");
			int courtNumber = rs.getInt("court_number");
			String firstName = rs.getNString("first_name");
			String lastName = rs.getString("last_name");

			Player p;
			Court c;
			result = new Reservation(id, c = new Court(), year, month, day, reservationHour, reservationMinute,
					hoursBooked, p = new Player());

			c.setCourtNumber(courtNumber);
			p.setFirstName(firstName);
			p.setLastName(lastName);

		}
		helper.closeConnection(con);
		return result;
	}

	public void deleteReservationByID(int reservationId) throws SQLException, ClassNotFoundException {
		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		String deleteReservation = "delete from reservation where id_reservation=? ";
		PreparedStatement ps = con.prepareStatement(deleteReservation);
		ps.setInt(1, reservationId);
		ps.executeUpdate();

		helper.closeConnection(con);

	}

}