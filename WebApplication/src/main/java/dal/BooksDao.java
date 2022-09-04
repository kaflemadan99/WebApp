package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.user.Books;

import utilities.DbCon;

public class BooksDao {

	public static String TABLE = "mytableinsql";
	
	public ArrayList<Books>findAll() {
		Connection con = DbCon.getConnection();
		ArrayList<Books> items = new ArrayList<> ();
		
		try {
			String sql = "selecct * from * " + TABLE;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Books book = new Books();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setCondition(rs.getString(4));
				book.setGenre(rs.getString(5));
				book.setComments(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return items;
	}

	public Books findByID(int id) {
		// TODO Auto-generated method stub
		Connection con = DbCon.getConnection();
		Books book = new Books();
		
		try {
			String sql = "select * from " + TABLE + " where Book_Id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setCondition(rs.getString(4));
				book.setGenre(rs.getString(5));
				book.setComments(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return book;
	}

	public void update(Books obj) {
		// TODO Auto-generated method stub
		Connection con = DbCon.getConnection();
		
			try {
			
		
					String qry = "update " + TABLE +" set Book_Name=?, Book_Author=?, Book_Condition=?, Book_Genre=?, comments=? where Book_id = ?";
		
					PreparedStatement ps = con.prepareStatement(qry);
					ps.setString(1, obj.getName());
					ps.setString(2, obj.getAuthor());
					ps.setString(3, obj.getCondition());
					ps.setString(4, obj.getGenre());
					ps.setString(5, obj.getComments());
					ps.setInt(6, obj.getId());
					
					ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
	}

	public Books save(Books obj) {
		// TODO Auto-generated method stub
		
		Connection con = DbCon.getConnection();
		
		try {
		
	
				String sql = "insert into " + TABLE +" (Book_Name, Book_Author, Book_Condition, Book_Genre, comments) values (?,?,?,?,?)";
				
	
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, obj.getName());
				ps.setString(2, obj.getAuthor());
				ps.setString(3, obj.getCondition());
				ps.setString(4, obj.getGenre());
				ps.setString(5, obj.getComments());
				
				ps.executeUpdate();
	
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DbCon.closeConnection();
	}
		return obj;
}


	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection con = DbCon.getConnection();
		
		try {
		
	
				String sql = "select * from " + TABLE +" where Book_Id = ? ";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				
				ps.executeUpdate();
	
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DbCon.closeConnection();
	}
		
	}

	public ArrayList<Books> findByBookName(String str) {
		// TODO Auto-generated method stub
		Connection con = DbCon.getConnection();
		ArrayList<Books> items = new ArrayList<>();
		
		try {
			String sql = "select * from " + TABLE + " where Book_Name = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, str);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Books book = new Books();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setCondition(rs.getString(4));
				book.setGenre(rs.getString(5));
				book.setComments(rs.getString(6));
				
				items.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return items;
	}

	public ArrayList<Books> findByBookAuthor(String str) {
		Connection con = DbCon.getConnection();
		ArrayList<Books> items = new ArrayList<>();
		
		try {
			String sql = "select * from " + TABLE + " where Book_Author = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, str);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Books book = new Books();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setCondition(rs.getString(4));
				book.setGenre(rs.getString(5));
				book.setComments(rs.getString(6));
				
				items.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return items;
	}
}
