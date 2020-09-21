package com.javaex.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class GuestbookDaoImpl implements GuestbookDao {
	String dburl = "jdbc:mariadb://192.168.1.137:3307/mysite?userSSL=false";
	String dbuser = "mysite";
	String dbpass = "mysite";
	
	// 공통 메서드 : 접속
	private Connection getConnection() throws SQLException {
		// 드라이버 로드
		// 접속 객체 생성 후, 값을 return
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");	// 드라이버 로드
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);	// 접속 객체 생성 -> conn
		} catch(ClassNotFoundException e) {
			System.err.println("접속 실패");
		}
		
		return conn;
	}
	
	@Override
	public List<GuestbookVo> searchAll() {
		// SELECT ... FROM guestbook ORDER BY reg_date DESC
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<GuestbookVo> list = new ArrayList<>();
		
		String sql = "SELECT no, name, password, message, reg_date "
				+ "FROM guestbook ORDER BY reg_date DESC";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 커서 루프
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String message = rs.getString(4);
				Date regDate = rs.getDate(5);
				
				// VO 객체 생성
				GuestbookVo vo = new GuestbookVo(no, name, password, message, regDate);
				// 반환할 List에 vo 추가
				list.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;	// INSERT, UPDATE, DELETE 쿼리의 영향을 받은 레코드의 카운트 리턴
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO guestbook (name, password, message, reg_date) "
					+ "VALUES(?, ?, ?, now())";		// SQL 실행 계획
			pstmt = conn.prepareStatement(sql);
			
			// 동적 데이터 연결
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());
			
			// 실행: INSERT, UPDATE, DELETE -> executeUpdate()
			insertedCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return insertedCount;
	}

	@Override
	public int update(GuestbookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updatedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "UPDATE guestbook SET message = ?, reg_date = now() "
					+ "WHERE no = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			
			// 동적 데이터 연결
			pstmt.setString(1, vo.getMessage());
			pstmt.setLong(2, vo.getNo());
			pstmt.setString(3, vo.getPassword());
			
			updatedCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return updatedCount;
	}

	@Override
	public int delete(Long no, String password) {
		// 연습 문제
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM guestbook WHERE no = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			pstmt.setString(2, password);
			
			deletedCount = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return deletedCount;
	}

	@Override
	public List<GuestbookVo> searchByKeyword(String keyword) {
		List<GuestbookVo> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT no, name, password, message, reg_date FROM guestbook "
				+ "WHERE name LIKE ? OR message LIKE ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String message = rs.getString(4);
				Date regDate = rs.getDate(5);
				
				GuestbookVo vo = new GuestbookVo(no, name, password, message, regDate);
				list.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
