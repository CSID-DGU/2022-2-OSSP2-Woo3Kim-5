package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.domain.DesiredJob;
import com.Woo3Kim.graduation.domain.Main;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcDesiredJobRepository implements DesiredJobRepository{
    private final DataSource dataSource;

    public JdbcDesiredJobRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //희망 직무 저장
    @Override
    public void save(DesiredJob desiredJob) {
        String sql = "insert into DesiredJob(JobName) values ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, desiredJob.getJobName());
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
    public List<DesiredJob> getAllDesiredJob() {
        String sql = "select * from DesiredJob";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<DesiredJob> desiredJobs = new ArrayList<>();
            while(rs.next()) {
                DesiredJob desiredjob = new DesiredJob();
                desiredjob.setJobName(rs.getString("JobName"));
                desiredJobs.add(desiredjob);
            }
            return desiredJobs;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<DesiredJob> getDesiredJobByAreaName(String AreaName) {
        String sql = "select * from DesiredJob_RelatedArea where relatedArea = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, AreaName);
            rs = pstmt.executeQuery();
            List<DesiredJob> desiredJobs = new ArrayList<>();
            while(rs.next()) {
                DesiredJob desiredjob = new DesiredJob();
                desiredjob.setJobName(rs.getString("JobName"));
                desiredJobs.add(desiredjob);
            }
            return desiredJobs;
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
