import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnect {
	public databaseConnect() {

		// TODO Auto-generated constructor stub

		//makeConnection();

	}

	

	public static Connection makeConnection() {

//		String server = "localhost";

//		String db = "h_waiting";

		String user = "a";

		String pw = "zz";
//		String url = "jdbc:mysql://211.195.123.78:3306/h_info?serverTimezone=UTC&useSSL=false";

		String url = "jdbc:mysql://h.waiting.o-r.kr/h_info?serverTimezone=UTC";

		/*
		 * String url = "jdbc:mysql://"+ server +
		 * 
		 * "/" + db +"?serverTimezone=UTC&useSSL=false";
		 */

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url,user,pw);

			System.out.println("연결 성공");		

			

			/*String sql = "INSERT INTO member(name, gender, age, place, phone) VALUES"

					+ "('홍길동','남','30','서울특별시 서초구', '010-1111-2222')";

			for (int i=0; i<30; i++) {

			Statement stmt = con.prepareStatement(sql);

			if(stmt.executeUpdate(sql) == 1)

				System.out.println("추가 성공");

			}*/



		} catch (ClassNotFoundException e){

			System.out.println("jdbc 드라이버 없음");

		}catch (SQLException e) {

			// TODO: handle exception

			System.out.println("데이터 베이스 연결 실패");

			System.out.println(e);

		}

		return con;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		makeConnection();
	}

}
