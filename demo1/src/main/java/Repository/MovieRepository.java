package Repository;

import Model.Movies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    public Movies findFirstMovie(int id) {
        Movies result = null;
        Connection conn = DBManager.getConnection();
        String SQL = "SELECT * FROM sys.`imdb-data`where ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new Movies(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("year"),
                        rs.getInt("length"),
                        rs.getString("subject"),
                        rs.getInt("popularity"),
                        rs.getString("awards"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String findRandomTitle() {
        String result = null;
        Connection conn = DBManager.getConnection();
        int random = (int) Math.round(Math.random() * 73 + 1);
        String SQL = "SELECT title FROM sys.`imdb-data`where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, random);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = rs.getString("title");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Movies> findTenSortByPop() {
        List<Movies> result = new ArrayList<>();
        Movies movie = null;
        Connection conn = DBManager.getConnection();
        String SQL = "SELECT * FROM sys.`imdb-data` order by RAND() limit 10";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                movie = new Movies(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("year"),
                        rs.getInt("length"),
                        rs.getString("subject"),
                        rs.getInt("popularity"),
                        rs.getString("awards"));
                result.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int findAward() {
        List<Movies> result = new ArrayList<>();
        Movies movie = null;
        Connection conn = DBManager.getConnection();
        String SQL = "SELECT * FROM sys.`imdb-data` where awards = 'yes' ";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                movie = new Movies(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("year"),
                        rs.getInt("length"),
                        rs.getString("subject"),
                        rs.getInt("popularity"),
                        rs.getString("awards"));
                result.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result.size();
    }

    public List<Movies> findComedyAward() {
        List<Movies> result = new ArrayList<>();
        Movies movie = null;
        Connection conn = DBManager.getConnection();
        String SQL = "SELECT * FROM sys.`imdb-data` where awards = 'yes' AND subject = 'Comedy' ";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                movie = new Movies(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("year"),
                        rs.getInt("length"),
                        rs.getString("subject"),
                        rs.getInt("popularity"),
                        rs.getString("awards"));
                result.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}


