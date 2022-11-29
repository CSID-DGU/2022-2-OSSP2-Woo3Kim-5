package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.dto.RelatedArea;
import com.Woo3Kim.graduation.dto.Subject;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

@Repository
public class JdbcRelatedAreaRepository implements RelatedAreaRepository {
    private final DataSource dataSource;

    public JdbcRelatedAreaRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void save(RelatedArea relatedArea) {
        String sql = "insert into RelatedArea(areaName) values ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, relatedArea.getAreaName());
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
    public Optional<RelatedArea> getRelatedAreaByAreaName(String areaName) {
        String sql = "select * from RelatedArea where areaName = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, areaName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                RelatedArea relatedArea = new RelatedArea();
                relatedArea.setAreaName(rs.getString("areaName"));
                return Optional.of(relatedArea);
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