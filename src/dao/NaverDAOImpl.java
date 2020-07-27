package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import dto.NaverDTO;

public class NaverDAOImpl implements NaverDAO {

	@Override
	public void insert(NaverDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.condb();
			String sql = "INSERT INTO navertbl VALUES(?, ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			// 4. 데이터 binding
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getOriginallink());
			pstmt.setString(3, dto.getLink());
			pstmt.setString(4, dto.getDescription());
			pstmt.setString(5, dto.getPubDate());
			
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<NaverDTO> select() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		ArrayList<NaverDTO> list = new ArrayList<NaverDTO>();
		try {
			conn = DB.condb();
			String sql = "SELECT * FROM navertbl";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				NaverDTO dto = new NaverDTO();
				dto.setTitle(rs.getString("title"));
				dto.setOriginallink(rs.getString("originallink"));
				dto.setLink(rs.getString("link"));
				dto.setDescription(rs.getString("description"));
				dto.setPubDate(rs.getString("pubDate"));
//				System.out.println("title : " + dto.getTitle()+"\n"+ "originallink : "+dto.getOriginallink()+"\n"+"link : "+dto.getLink()+"\n"+"description : "+dto.getDescription()+"\n"+"pubDate"+dto.getPubDate()+"\n");
//				System.out.print(rs.getString("num") + ". ");
//				System.out.print(rs.getString("name") + " ");
//				System.out.println(rs.getString("price"));
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}


}
