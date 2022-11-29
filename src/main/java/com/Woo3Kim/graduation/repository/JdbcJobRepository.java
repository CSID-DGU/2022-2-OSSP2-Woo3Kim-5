package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.dto.Job;
import com.Woo3Kim.graduation.dto.Subject;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcJobRepository implements JobRepository {
    private final DataSource dataSource;

    public JdbcJobRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //희망 직무 저장
    @Override
    public void save(Job job) {
        String sql = "insert into Job(JobName) values ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, job.getJobName());
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
    public List<Job> getAllJob() {
        String sql = "select * from Job";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<Job> jobs = new ArrayList<>();
            while(rs.next()) {
                Job desiredjob = new Job();
                desiredjob.setJobName(rs.getString("JobName"));
                jobs.add(desiredjob);
            }
            return jobs;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Job> getJobByJobName(String JobName) {
        String sql = "select * from Job where JobName = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, JobName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Job job = new Job();
                job.setJobName(rs.getString("JobName"));
                return Optional.of(job);

            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    /*@Override
    public List<Job> getJobByAreaName(String AreaName) {
        String sql = "select * from DesiredJob_RelatedArea where relatedArea = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, AreaName);
            rs = pstmt.executeQuery();
            List<Job> jobs = new ArrayList<>();
            while(rs.next()) {
                Job desiredjob = new Job();
                desiredjob.setJobName(rs.getString("JobName"));
                jobs.add(desiredjob);
            }
            return jobs;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }*/

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
