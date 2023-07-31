package Common.Dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class OrderDao {

	private String id;
	private String pw;
	private String url;

	private String userid;
	private String prodid;
	private String useraddr;


	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static OrderDao instance;
	public static OrderDao getInstance() {
		if(instance==null)
			instance=new OrderDao();
		return instance;
	}



	public OrderDao()
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




}
