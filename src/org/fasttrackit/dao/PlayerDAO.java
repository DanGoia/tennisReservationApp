
package org.fasttrackit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.fasttrackit.helpers.DBHelpers;
import org.fasttrackit.pojo.Player;

public class PlayerDAO {

	public void insertPlayer(Player p) throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		String insertPlayer = "insert into player(first_name,last_name,email,age,player_level,matches_played,wins,losses,league_points)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertPlayer);

		ps.setString(1, p.getFirstName());
		ps.setString(2, p.getLastName());
		ps.setString(3, p.getEmail());
		ps.setInt(4, p.getAge());
		ps.setInt(5, p.getPlayerLevel());
		ps.setInt(6, p.getMatchesPlayed());
		ps.setInt(7, p.getMatchesWon());
		ps.setInt(8, p.getMatchesLost());
		ps.setInt(9, p.getLeaguePoints());

		ps.executeUpdate();
		helper.closeConnection(con);

	}

	public void deletePlayer(int id) throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		String deletePlayer = "delete from player where id_player=? ";
		PreparedStatement ps = con.prepareStatement(deletePlayer);
		ps.setInt(1, id);
		ps.executeUpdate();

		helper.closeConnection(con);

	}

	public void deletePlayer(Player p) throws SQLException, ClassNotFoundException {
		this.deletePlayer(p.getId());
	}

	public void updatePlayer(Player p) throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		String updatePlayer = "update player set first_name=?,last_name=?,email=?,age=?,player_level=?,matches_played=?,wins=?,losses=?,league_points=? where id_player=?";

		PreparedStatement ps = con.prepareStatement(updatePlayer);

		ps.setString(1, p.getFirstName());
		ps.setString(2, p.getLastName());
		ps.setString(3, p.getEmail());
		ps.setInt(4, p.getAge());
		ps.setInt(5, p.getPlayerLevel());
		ps.setInt(6, p.getMatchesPlayed());
		ps.setInt(7, p.getMatchesWon());
		ps.setInt(8, p.getMatchesLost());
		ps.setInt(9, p.getLeaguePoints());
		ps.setInt(10, p.getId());
		ps.executeUpdate();
		helper.closeConnection(con);

	}

	public ArrayList<Player> getPlayers() throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		ArrayList<Player> playersList = new ArrayList<Player>();

		String sqlShowPlayers = "SELECT * FROM tennis_app.player  ";

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(sqlShowPlayers);
		while (rs.next()) {

			int id = rs.getInt("id_player");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getString("email");
			int age = rs.getInt("age");
			int playerLevel = rs.getInt("player_level");
			int matchesPlayed = rs.getInt("matches_played");
			int wins = rs.getInt("wins");
			int losses = rs.getInt("losses");
			int league_points = rs.getInt("league_points");

			Player p = new Player(id, firstName, lastName, email, age, playerLevel, matchesPlayed, wins, losses,
					league_points);
			playersList.add(p);

		}
		helper.closeConnection(con);
		return playersList;

	}

	public ArrayList<Player> getPlayersRankings() throws SQLException, ClassNotFoundException {

		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();
		ArrayList<Player> playersList = new ArrayList<Player>();

		String sqlShowPlayers = "SELECT player.*, @rank := CASE\r\n"
				+ "    WHEN @partval = player_level AND @rankval = league_points THEN @rank\r\n"
				+ "    WHEN @partval = player_level AND (@rankval := league_points) IS NOT NULL THEN @rank + 1\r\n"
				+ "    WHEN (@partval := player_level) IS NOT NULL AND (@rankval := league_points) IS NOT NULL THEN 1\r\n"
				+ "END AS rnk\r\n" + "FROM player, (SELECT @rank := NULL, @partval := NULL, @rankval := NULL) AS x\r\n"
				+ "ORDER BY player_level DESC, league_points DESC;";

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(sqlShowPlayers);
		while (rs.next()) {

			int id = rs.getInt("id_player");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getString("email");
			int age = rs.getInt("age");
			int playerLevel = rs.getInt("player_level");
			int matchesPlayed = rs.getInt("matches_played");
			int wins = rs.getInt("wins");
			int losses = rs.getInt("losses");
			int league_points = rs.getInt("league_points");

			Player p = new Player(id, firstName, lastName, email, age, playerLevel, matchesPlayed, wins, losses,
					league_points);
			playersList.add(p);

		}
		helper.closeConnection(con);
		return playersList;

	}

	public Player getPlayerbyId(int id) throws SQLException, ClassNotFoundException {

		Player result = null;
		DBHelpers helper = new DBHelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from Player where id_player=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getNString("email");
			int age = rs.getInt("age");
			int playerLevel = rs.getInt("player_level");
			int matchesPlayed = rs.getInt("matches_played");
			int wins = rs.getInt("wins");
			int losses = rs.getInt("losses");
			int leaguePoints = rs.getInt("league_points");

			result = new Player(id, firstName, lastName, email, age, playerLevel, matchesPlayed, wins, losses,
					leaguePoints);

		}
		helper.closeConnection(con);
		return result;
	}
}
