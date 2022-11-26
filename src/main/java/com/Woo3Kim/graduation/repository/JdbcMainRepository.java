package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.domain.Main;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class JdbcMainRepository implements MainRepository{
    private final DataSource dataSource;

    public JdbcMainRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //메인 페이지의 서비스 소개와 개발자 소개 데이터 입력
    @Override
    public void save(Main main) {
        String sql = "insert into Main(serviceIntroduction, creatorIntroduction) values (?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, main.getServiceIndroduction());
            pstmt.setString(2, main.getCreatorIndroduction());
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
    public Optional<Main> getMain() {
        String sql = "select * from Main where MainId = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);                 //db의 첫 번째 데이터 값만 사용한다고 가정
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Main main = new Main();
                main.setServiceIndroduction(rs.getString("serviceIntroduction"));
                main.setCreatorIndroduction(rs.getString("creatorIntroduction"));
                return Optional.of(main);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
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
