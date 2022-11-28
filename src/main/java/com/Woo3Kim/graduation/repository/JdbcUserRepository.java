package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.dto.Job;
import com.Woo3Kim.graduation.dto.Subject;
import com.Woo3Kim.graduation.dto.User;
import com.Woo3Kim.graduation.dto.UserSubject;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class JdbcUserRepository implements UserRepository {
    private final DataSource dataSource;

    public JdbcUserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void saveUser(User user) {
        String sql = "insert into User(userId, pwd, job) values (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPwd());
            pstmt.setString(3, user.getJob());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {

            } else {
                throw new SQLException("저장 실패");
            }
        } catch (Exception e) {

        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public void updateUserJob(User user, Job job) {
        String sql = "update User set job = ? where userId = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, job.getJobName());
            pstmt.setString(2, user.getUserId());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {

            } else {
                throw new SQLException("저장 실패");
            }
        } catch (Exception e) {

        } finally {
            close(conn, pstmt, rs);
        }
    }


    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}
