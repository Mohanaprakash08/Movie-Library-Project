package DAOPackage;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import DTOPackage.Admin;
import DTOPackage.Movie;

public class DAO1 {
	
	public Connection getconnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mpdb1","root","root");
	}
	
	public int saveAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		
		Connection con = getconnection();
		PreparedStatement pst = con.prepareStatement("insert into admin values(?,?,?,?,?)");
		pst.setInt(1, admin.getAdminid());
		pst.setString(2, admin.getAdminname());
		pst.setLong(3, admin.getAdmincontact());
		pst.setString(4, admin.getAdminmail());
		pst.setString(5, admin.getAdminpass());
		return pst.executeUpdate(); 
	}



	public Admin findByEmail(String adminmail) throws ClassNotFoundException, SQLException {
		Connection con = getconnection();
		PreparedStatement pst = con.prepareStatement("select * from admin where adminmail=?");
		pst.setString(1, adminmail);
		ResultSet rs = pst.executeQuery();
		Admin admin = new Admin();
		
		while(rs.next()) {		
		admin.setAdminid(rs.getInt(1));
		admin.setAdminname(rs.getString(2));
		admin.setAdmincontact(rs.getLong(3));
		admin.setAdminmail(rs.getString(4));
		admin.setAdminpass(rs.getString(5));}
		return admin;
	}
		
		public int saveMovie(Movie movie) throws ClassNotFoundException, SQLException {
			
			Connection con = getconnection();
			PreparedStatement pst = con.prepareStatement("insert into movie values(?,?,?,?,?,?,?)");
			
			pst.setInt(1, movie.getMovieid());
			pst.setString(2, movie.getMoviename());
			pst.setDouble(3, movie.getMovieprice());
			pst.setDouble(4, movie.getMovierating());
            pst.setString(5, movie.getMoviegenre());
            pst.setString(6, movie.getMovielanguage());
            
//          Blob image = new SerialBlob(movie.getMovieimage());
            pst.setBlob(7,new SerialBlob(movie.getMovieimage()));
			
			return pst.executeUpdate();
			
		}
		
		public List<Movie> getAllMovies() throws ClassNotFoundException, SQLException{
			
			Connection con = getconnection();
			PreparedStatement pst = con.prepareStatement("select * from movie");
			ResultSet rs = pst.executeQuery();
			List<Movie> movies = new ArrayList<Movie>();
			
		
			while(rs.next())
			{
				Movie m = new Movie();
				m.setMovieid(rs.getInt(1));
				m.setMoviename(rs.getString(2));
				m.setMovieprice(rs.getDouble(3));
				m.setMovierating(rs.getDouble(4));
				m.setMoviegenre(rs.getString(5));
				m.setMovielanguage(rs.getString(6));
				Blob b = rs.getBlob(7);
				byte[] img = b.getBytes(1,(int)b.length());
				m.setMovieimage(img);
				movies.add(m);
			}
			return movies;
		}
		
		public int deleteMovie(int id) throws ClassNotFoundException, SQLException
		{
			Connection con = getconnection();
			PreparedStatement pst = con.prepareStatement("delete from movie where movieid = ?");
			pst.setInt(1, id);
			return pst.executeUpdate();
		}
		
	   public Movie findMovieById(int movieId) throws ClassNotFoundException, SQLException {
		Connection con = getconnection();
		PreparedStatement pst = con.prepareStatement("select * from movie where movieid = ?");
		pst.setInt(1, movieId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Movie m = new Movie();
		m.setMovieid(rs.getInt(1));
		m.setMoviename(rs.getString(2));
		m.setMovieprice(rs.getDouble(3));
		m.setMovierating(rs.getDouble(4));
		m.setMoviegenre(rs.getString(5));
		m.setMovielanguage(rs.getString(6));
		Blob b = rs.getBlob(7);
		byte[] img = b.getBytes(1, (int)b.length());
		m.setMovieimage(img);
		return m;
	}
		
		public int EditMovie(Movie movie) throws ClassNotFoundException, SQLException
		{
			Connection con = getconnection();
			PreparedStatement pst = con.prepareStatement("update movie set moviename = ?,movieprice = ?,movierating=?,moviegenre=?,movielanguage=?,movieimage=? where movieid = ?");
			
//			
			pst.setString(1, movie.getMoviename());
			pst.setDouble(2, movie.getMovieprice());
			pst.setDouble(3, movie.getMovierating());
            pst.setString(4, movie.getMoviegenre());
            pst.setString(5, movie.getMovielanguage());
            
//          Blob image = new SerialBlob(movie.getMovieimage());
            pst.setBlob(6,new SerialBlob(movie.getMovieimage()));
			
            
            pst.setInt(7, movie.getMovieid());
            
			return pst.executeUpdate();
		}
		
}
