package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.dto.*;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcSubjectRepository implements SubjectRepository {

    private final DataSource dataSource;

    public JdbcSubjectRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Subject subject) {
        String sql = "insert into Subject(subjectName, grade, kind, description) values (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, subject.getSubjectName());
            pstmt.setInt(2, subject.getGrade());
            pstmt.setString(3, subject.getKind());
            pstmt.setString(4, subject.getDescription());
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
    public Optional<Subject> getSubjectBySubjectName(String subjectName) {
        String sql = "select * from subject where subjectName = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, subjectName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectName(rs.getString("subjectName"));
                subject.setDescription(rs.getString("description"));
                subject.setKind(rs.getString("kind"));
                subject.setGrade(rs.getInt("grade"));
                return Optional.of(subject);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Subject> getAllSubject() {
        String sql = "select * from Subject";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectName(rs.getString("subjectName"));
                subject.setGrade(rs.getInt("grade"));
                subject.setKind(rs.getString("kind"));
                subject.setDescription(rs.getString("description"));
                subjects.add(subject);
            }
            return subjects;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public void saveSubjectRelatedArea(Subject subject, RelatedArea relatedArea) {
        String sql = "insert into SubjectRelatedArea(subject, areaName) values (?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, subject.getSubjectName());
            pstmt.setString(2, relatedArea.getAreaName());
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
    public List<Subject> getSubjectByRelatedArea(RelatedArea relatedArea) {
        String sql = "select subjectName, description, kind, grade from Subject, SubjectRelatedArea" +
                "where Subject.subjectName = SubjectRelatedArea.subjectName and SubjectRelatedArea.areaName = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, relatedArea.getAreaName());
            rs = pstmt.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while(rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectName(rs.getString("subjectName"));
                subject.setDescription(rs.getString("description"));
                subject.setKind(rs.getString("kind"));
                subject.setGrade(rs.getInt("grade"));
                subjects.add(subject);
            }
            return subjects;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public void saveSubjectJob(Subject subject, Job job) {
        String sql = "insert into SubjectJob(subjectName, jobName) values (?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, subject.getSubjectName());
            pstmt.setString(2, job.getJobName());
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
    public List<Subject> getSubjectByJob(Subject subject, Job job) {
        String sql = "select s.subjectName, s.description, s.kind, s.grade from Subject s, SubjectJob sj" +
                "where s.subjectName = sj.subjectName and sj.JobName = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, job.getJobName());
            rs = pstmt.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while(rs.next()) {
                Subject subjectTemp = new Subject();
                subjectTemp.setSubjectName(rs.getString("subjectName"));
                subjectTemp.setDescription(rs.getString("description"));
                subjectTemp.setKind(rs.getString("kind"));
                subjectTemp.setGrade(rs.getInt("grade"));
                subjects.add(subjectTemp);
            }
            return subjects;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public void saveUserSubject(User user, Subject subject) {
        String sql = "insert into UserSubject(userId, subjectName) values (?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, subject.getSubjectName());
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
    public List<Subject> getAllSubjectOfUser(User user) {
        String sql = "select s.subjectName, s.description, s.kind, s.grade from Subject s, UserSubject us" +
                "where s.subjectName = us.subjectName and us.userId = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            rs = pstmt.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while(rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectName(rs.getString("subjectName"));
                subject.setDescription(rs.getString("description"));
                subject.setKind(rs.getString("kind"));
                subject.setGrade(rs.getInt("grade"));
                subjects.add(subject);
            }
            return subjects;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Subject> getMajorOfUser(User user) {
        String sql = "select s.subjectName, s.description, s.kind, s.grade from Subject s, UserSubject us" +
                "where s.subjectName = us.subjectName and us.userId = ? and s.kind = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, "major");
            rs = pstmt.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while(rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectName(rs.getString("subjectName"));
                subject.setDescription(rs.getString("description"));
                subject.setKind(rs.getString("kind"));
                subject.setGrade(rs.getInt("grade"));
                subjects.add(subject);
            }
            return subjects;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Subject> getGEOfUser(User user) {
        String sql = "select s.subjectName, s.description, s.kind, s.grade from Subject s, UserSubject us" +
                "where s.subjectName = us.subjectName and us.userId = ? and s.kind = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, "GE");
            rs = pstmt.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while(rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectName(rs.getString("subjectName"));
                subject.setDescription(rs.getString("description"));
                subject.setKind(rs.getString("kind"));
                subject.setGrade(rs.getInt("grade"));
                subjects.add(subject);
            }
            return subjects;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Subject> getBasicOfUser(User user) {
        String sql = "select s.subjectName, s.description, s.kind, s.grade from Subject s, UserSubject us" +
                "where s.subjectName = us.subjectName and us.userId = ? and s.kind = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, "basic");
            rs = pstmt.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while(rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectName(rs.getString("subjectName"));
                subject.setDescription(rs.getString("description"));
                subject.setKind(rs.getString("kind"));
                subject.setGrade(rs.getInt("grade"));
                subjects.add(subject);
            }
            return subjects;
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
