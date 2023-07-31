package Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Common.Dto.EmailCodeDto;
import Common.Dto.MemberDto;

public class MemberDao {

	private String id;
	private String pw;
	private String url;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static MemberDao instance;

	public static MemberDao getInstance() {
		if (instance == null)
			instance = new MemberDao();
		return instance;
	}

	public MemberDao() {
		id = "root";
		pw = "1234";
		url = "jdbc:mysql://localhost:3306/clothesdb";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int insert(MemberDto dto) {
		try {
			System.out.println(dto.getAddr());
			pstmt = conn.prepareStatement("insert into tbl_member(pwd,name,phone,addr,email) values(?,?,?,?,?)");
			pstmt.setString(1, dto.getPwd());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getEmail());
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public int email(EmailCodeDto Dto) {
		try {
			pstmt = conn.prepareStatement("select member_id from tbl_member where email=?");
			pstmt.setString(1, Dto.getEmail());
			rs = pstmt.executeQuery();
			if (rs.next() == true) {
				return 1;

			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public void emailcode(EmailCodeDto Dto) {
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO tbl_emailcode VALUES (NULL, ?, CURDATE(), ?)");
	        pstmt.setString(1, Dto.getEmailcode());
	        pstmt.setString(2, Dto.getEmail());
	        pstmt.executeUpdate();
	        pstmt.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	
	public int emailvalid(EmailCodeDto Dto) {
		try {
			pstmt = conn.prepareStatement("select * from tbl_emailcode where emailcode=?");
			pstmt.setString(1, Dto.getEmailcode());
			rs = pstmt.executeQuery();
			if (rs.next() == true) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
}
