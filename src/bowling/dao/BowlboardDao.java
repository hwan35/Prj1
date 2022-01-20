package bowling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bowling.db.DBCon;
import bowling.vo.Bowlboard;

public class BowlboardDao {
	public List<Bowlboard> bowlboardSelAll(String field,String query) throws Exception {

		String sql = "SELECT * FROM bowlboard WHERE "+ field +" like ? ORDER BY bno DESC";

		// DB연결
		Connection con = DBCon.getConnection();

		// 실행
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, "%"+query+"%");

		// 결과
		ResultSet rs = pstmt.executeQuery();

		// List에 Bowlboard내용 담기
		List<Bowlboard> list = new ArrayList<Bowlboard>();
		while (rs.next()) {
			Bowlboard b = new Bowlboard();
			b.setBno(rs.getInt("bno"));
			b.setBtitle(rs.getString("btitle"));
			b.setBcontent(rs.getString("bcontent"));
			b.setBwriter(rs.getString("bwriter"));
			b.setBdate(rs.getDate("bdate"));
			b.setBcnt(rs.getInt("bcnt"));

			list.add(b);
		}
		rs.close();
		pstmt.close();
		con.close();

		return list;
	}
	
	public int bowlboardCnt() throws Exception {
		String sql = "SELECT count(*) FROM bowlboard";

		// DB연결
		Connection con = DBCon.getConnection();

		// 실행
		Statement stmt = con.createStatement();

		// 결과
		ResultSet rs = stmt.executeQuery(sql);

		rs.next();
		int cnt = rs.getInt(1); // 가로 안에 있는 1은 sql에 있는 칼럼 index값
		
		rs.close();
		stmt.close();
		con.close();

		return cnt;
	}
	

	public Bowlboard bowlboardDetail(int bno) throws Exception {
		String sql = "SELECT * FROM bowlboard WHERE bno=?";

		// DB연결
		Connection con = DBCon.getConnection();

		// 실행
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, bno);

		// 결과
		ResultSet rs = pstmt.executeQuery();

		rs.next();

		Bowlboard b = new Bowlboard();
		b.setBno(rs.getInt("bno"));
		b.setBtitle(rs.getString("btitle"));
		b.setBcontent(rs.getString("bcontent"));
		b.setBwriter(rs.getString("bwriter"));
		b.setBdate(rs.getDate("bdate"));
		b.setBcnt(rs.getInt("bcnt"));

		rs.close();
		pstmt.close();
		con.close();

		return b;

	}

	public int bowlboardDel(int bno) throws Exception {

		String sql = "DELETE FROM bowlboard WHERE bno=?";

		// DB연결
		Connection con = DBCon.getConnection();

		// 실행
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bno);
		int del = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return del;
	}

	public int bowlboardReg(Bowlboard b) throws Exception {
		String sql = "INSERT INTO bowlboard VALUES(" 
				+ "(SELECT nvl(max(bno)+1,1) FROM bowlboard)" 
				+ ",?,?,?,SYSDATE,1)"; // sql 가로 잘 써넣기

		// DB연결
		Connection con = DBCon.getConnection();

		// 실행
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, b.getBtitle());
		pstmt.setString(2, b.getBcontent());
		pstmt.setString(3, b.getBwriter());
		
		 // 이쪽 아래 출력문 안 찍히면  sql 오타 확인할 것!
		int reg = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return reg;
	}

	public int bowlboardEdit(Bowlboard b) throws Exception {
		String sql = "UPDATE bowlboard SET btitle=?, bcontent=?, " 
				+ "bwriter=? WHERE bno=?";

		// DB연결
		Connection con = DBCon.getConnection();

		// 실행
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, b.getBtitle());
		pstmt.setString(2, b.getBcontent());
		pstmt.setString(3, b.getBwriter());
		pstmt.setInt(4, b.getBno());

		int edit = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return edit;
	}

}
