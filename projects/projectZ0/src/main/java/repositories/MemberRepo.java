package repositories;

import models.*;
import utils.*;

import java.sql.*;

public class MemberRepo {
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    // Create
    public Member addMember(Member m) {
        try (Connection conn = cu.getConnection()) {
        	//Query string
            String sql = "insert into members (full_name, address, phone_number, is_staff, fee, user_name, pass_word) values (?, ?, ?, ?, ?, ?, ?) returning *";
            //putting parameters in query
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getName());
            ps.setString(2, m.getAddress());
            ps.setString(3, m.getPhoneNumber());
            ps.setBoolean(4, m.getIsStaff());
            ps.setInt(5, m.getFee());
            ps.setString(6, m.getUsername());
            ps.setString(7, m.getPassword());
            //executing query
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                m.setAccountId(rs.getInt("id"));
                return m;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Read
    public Member getById(int id) {
        try (Connection conn = cu.getConnection()) {
            String sql = "select * from members where id = ?";
            //preparing query
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            //executing query
            ResultSet rs = ps.executeQuery();
            //get member and create member class object
            if (rs.next()) {
                Member m = new Member();
                m.setAccountId(rs.getInt("id"));
                m.setUsername(rs.getString("user_name"));
                m.setPassword(rs.getString("pass_word"));
                m.setName(rs.getString("full_name"));
                m.setAddress(rs.getString("address"));
                m.setPhoneNumber(rs.getString("phone_number"));
                m.setFee(rs.getInt("fee"));
                m.setStaff(rs.getBoolean("is_staff"));

                return m;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Member getByLogin(String username, String password) {
        try (Connection conn = cu.getConnection()) {
            String sql = "select * from members where user_name = ? and pass_word = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            //get member data and create member class object after login
            if (rs.next()) {
                Member m = new Member();
                m.setAccountId(rs.getInt("id"));
                m.setUsername(rs.getString("user_name"));
                m.setPassword(rs.getString("pass_word"));
                m.setName(rs.getString("full_name"));
                m.setAddress(rs.getString("address"));
                m.setPhoneNumber(rs.getString("phone_number"));
                m.setFee(rs.getInt("fee"));
                m.setStaff(rs.getBoolean("is_staff"));

                return m;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Update
    public int updateFee(int id, int fee) {
        try (Connection conn = cu.getConnection()) {
            String sql = "update members set fee = ? where id = ? returning fee";
            //preparing query
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, fee);
            ps.setInt(2, id);
            //executing query
            ResultSet rs = ps.executeQuery();
            //setting fee and returning
            if (rs.next()) {
                int newFee = rs.getInt("fee");
                return newFee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fee;
    }
}
