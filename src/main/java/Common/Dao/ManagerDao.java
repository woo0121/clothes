package Common.Dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Common.Dto.MemberDto;

public class ManagerDao {

	private String id;
	private String pw;
	private String url;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static ManagerDao instance;
	public static ManagerDao getInstance() {
		if(instance==null)
			instance=new ManagerDao();
		return instance;
	}
	
	public ManagerDao()
	{
		id = "root";
		pw = "1234";
		url = "jdbc:mysql://localhost:3306/clothesdb";

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	// CRUD
	public int insert(MemberDto dto)
	{
		try
		{
			
//			pstmt = conn.prepareStatement("insert into tbl_member values(?,?,?,?,?)");
//			pstmt.setString(1, dto.getId());
//			pstmt.setString(2, dto.getPw());
//			pstmt.setString(3, dto.getusername());
//			pstmt.setString(4, dto.getAdr_addr());
//			pstmt.setString(5, dto.getRole());
//			int result = pstmt.executeUpdate();
//			pstmt.close();
//			return result;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return 0;		
	}
	
	
}

