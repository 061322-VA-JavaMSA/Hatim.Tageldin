package repositories;

import models.*;
import utils.*;

import java.sql.Date;
import java.sql.*;
import java.time.*;
import java.util.*;

public class BookRepo {
    private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    // Create
    public Book addBook(Book b) {
        try (Connection conn = cu.getConnection()) {
        	//Creating query string
            String sql = "insert into book (title, author, checked_out, due_date, account_id, genre) values (?, ?, ?, ?, ?, ?) returning *";
            //Preparing the query to be executed
            PreparedStatement ps = conn.prepareStatement(sql);
            //setting query paramaters
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setBoolean(3, false);
            ps.setNull(4, Types.DATE);
            ps.setNull(5, Types.INTEGER);
            ps.setString(6, b.getGenre());
            //executing query and getting result
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                b.setBookId(rs.getInt("id"));
                return b;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Read | HasMaps allows to make relation to two keys value
    public static HashMap<Integer, Book> viewCatalogue() {
        //making connection to db
    	try (Connection conn = cu.getConnection()) {
            String sql = "select * from book";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            //executing the query
            ResultSet rs = ps.executeQuery();
            
            HashMap<Integer, Book> catalogue = new HashMap<>();
            //creating book class objects from data fetched from db
            while (rs.next()) {
                Book b = new Book();
                b.setBookId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("auth"));
                b.setCheckedOut(rs.getBoolean("checked_out"));
                b.setDueDate(rs.getDate("due_date"));
                b.setBorrowedBy(rs.getInt("account_id"));
                b.setGenre(rs.getString("genre"));
                
                catalogue.put(b.getBookId(), b);
            }

            return catalogue;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Book getById(int id) {
    	//making db connection
        try (Connection conn = cu.getConnection()) {
            String sql = "select * from book where id = ?";
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            //executing query
            ResultSet rs = ps.executeQuery();
            //creating book class object
            if (rs.next()) {
                Book b = new Book();
                b.setBookId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("auth"));
                b.setCheckedOut(rs.getBoolean("checked_out"));
                b.setDueDate(rs.getDate("due_date"));
                b.setBorrowedBy(rs.getInt("account_id"));
                b.setGenre(rs.getString("genre"));

                return b;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Update
    public static Date updateCheckedOut(int bookId, int userId, boolean checkedOut) {
        //making db conenction
    	try (Connection conn = cu.getConnection()) {
            String sql = "update book set checked_out = ?, account_id = ?, due_date = ? where id = ? returning due_date";
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, checkedOut);
            //if book already checked out, update date and user id
            if (checkedOut) {
            	
                ps.setInt(2, userId);
                ps.setDate(3, Date.valueOf(LocalDate.now().plusWeeks(2)));
            }
            else {//if not checked out
                ps.setNull(2, Types.INTEGER);
                ps.setNull(3, Types.DATE);
            }

            ps.setInt(4, bookId);
            //executing query
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDate("due_date");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Delete
    public boolean deleteBook(int id) {
        //making db connection
    	try (Connection conn = cu.getConnection()) {
            String sql = "delete from book where id = ?";
            //need to account for null exception
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            //executing query
            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}