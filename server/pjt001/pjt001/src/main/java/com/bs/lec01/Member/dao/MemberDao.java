package com.bs.lec01.Member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bs.lec01.Member.Member;
import com.bs.lec01.Member.Prescription;
import com.bs.lec01.Member.Prescription_drug;
import com.bs.lec01.Member.Waiting;

@Repository
public class MemberDao implements IMemberDao {

	private String driver = "com.mysql.cj.jdbc.Driver";

	
	  private String url ="jdbc:mysql://localhost:3306/h_info?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	  private String userid = "a"; 
	  private String userpw = "zz";
	 
	
	/*
	 * private String url =
	 * "jdbc:mysql://localhost:3306/member?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	 * private String userid = "root"; private String userpw = "1234";
	 */

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	

	@Override
	public Waiting waitingInsert(Waiting wat) {
		Waiting wait = null;
		int result = 0;
		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "INSERT INTO hospital_parmacy_waiting ( hp_num, m_num, name, "
					+ " waiting_num,status ) values (?,?,?,?,'대기')";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wat.getHp_num());
			pstmt.setInt(2, wat.getM_num());
			pstmt.setString(3, wat.getName());
			pstmt.setInt(4, wat.getWaiting_num());

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return wait;

	}

	@Override
	public Member memberInsert(Member member) {
		Member mem = null;
		int result = 0;
		// Map<String, String>;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "INSERT INTO member ( name, gender, place, " + "Citizen_num, phone,age ) values (?,?,?,?,?,?)";
			String sql1 = "SELECT * FROM member WHERE citizen_num=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getGender());
			pstmt.setString(3, member.getPlace());
			pstmt.setString(4, member.getCitizen_num());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getAge());

			result = pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, member.getCitizen_num());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				mem = new Member();
				mem.setM_num(rs.getString("m_num"));
				mem.setDateInserted(rs.getString("dateInserted"));

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return mem;

	}

	@Override
	public List<Member> MemberSelect() {

		Member mem = null;
		List<Member> users = new ArrayList<Member>();

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "SELECT * FROM member";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem = new Member();
				mem.setM_num(rs.getString("m_num"));
				mem.setName(rs.getString("name"));
				mem.setGender(rs.getString("gender"));
				mem.setCitizen_num(rs.getString("citizen_num"));
				mem.setPlace(rs.getString("place"));
				mem.setPhone(rs.getString("phone"));
				mem.setDateInserted(rs.getString("dateInserted"));
				mem.setAge(rs.getString("age"));

				users.add(mem);

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return users;

	}

	@Override
	public int memberModify(Member member) {

		int update = 0;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "UPDATE member SET " + member.getField() + "=? WHERE m_num=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getValue());
			pstmt.setInt(2, Integer.parseInt(member.getM_num()));

			update = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return update;

	}

	@Override
	public int memberDelete(int num) {

		int result = 0;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "DELETE from member WHERE m_num = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	@Override
	public HashMap<String, String> prescriptionissue(int num) {
		HashMap<String, String> map = new HashMap<String, String>();

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, this.userid, this.userpw);
			String sql = "SELECT * FROM prescription ORDER BY pre_num DESC LIMIT 1;";
			String sql1 = "SELECT * FROM member WHERE m_num = ? ";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			if (rs.next())
				map.put("pre_num", Integer.toString(rs.getInt("pre_num") + 1));
			else
				map.put("pre_num", "1");

			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				map.put("citizen_num", rs.getString("citizen_num"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return map;

	}
	

	@Override
	public List<Waiting> waitSelect() {

		Waiting wait = null;
		List<Waiting> users = new ArrayList<Waiting>();

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "SELECT * FROM hospital_parmacy_waiting WHERE status NOT IN('보류') and hp_num=1";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			int wating_num = 1;
			while (rs.next()) {

				wait = new Waiting();

				wait.setM_num(rs.getInt("m_num"));
				wait.setName(rs.getString("name"));
				wait.setStatus(rs.getString("status"));
				wait.setWaiting_num(wating_num);
				users.add(wait);
				wating_num++;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return users;

	}

	public int waitingDelete(int m_num) {
		int result = 0;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "DELETE from hospital_parmacy_waiting WHERE m_num = ? and hp_num=1";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, m_num);

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	public int defer(int m_num) {
		int result = 0;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "UPDATE hospital_parmacy_waiting SET status='보류'  WHERE m_num = ? and hp_num=1";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, m_num);

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int examination(int m_num) {
		int result = 0;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "UPDATE hospital_parmacy_waiting SET status='진료'  WHERE m_num = ? and hp_num=1";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, m_num);

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int waitholdon(int m_num) {
		int result = 0;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "UPDATE hospital_parmacy_waiting SET status='대기'  WHERE m_num = ? and hp_num=1";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, m_num);

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Waiting> deferSelect() {
		Waiting wait = null;
		List<Waiting> users = new ArrayList<Waiting>();

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "SELECT * FROM hospital_parmacy_waiting WHERE status='보류' and hp_num=1";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				wait = new Waiting();

				wait.setStatus(rs.getString("status"));
				wait.setM_num(rs.getInt("m_num"));
				wait.setName(rs.getString("name"));
				wait.setWaiting_num(999);
				users.add(wait);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return users;

	}

	public void prescriptionsave(Prescription pre) {
		int result = 0;
		List<Prescription_drug> drug = pre.getDrugs();
		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);

			String sql2 = "INSERT INTO prescription(h_num,m_num,usase,period) value (?,?,?,?)";
			String sql = "INSERT INTO prescription_drug(pre_num,drug_name,dose,dtime,total_days) values (?,?,?,?,?) ";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, pre.getH_num());
			pstmt.setInt(2, pre.getM_num());
			pstmt.setString(3, pre.getUsase());
			pstmt.setString(4, pre.getPeriod());
			result = pstmt.executeUpdate();

			for (int i = 0; i < drug.size(); i++) {
				Prescription_drug _d = drug.get(i);
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pre.getPre_num());
				pstmt.setString(2, _d.getDrug_name());
				pstmt.setInt(3, _d.getDose());
				pstmt.setInt(4, _d.getDtime());
				pstmt.setInt(5, _d.getTotal_days());
				result = pstmt.executeUpdate();
				System.out.println(_d.getDrug_name());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

/*
 * @Override public int PrescriptionDelete(Prescription pre) { // TODO
 * Auto-generated method stub
 * 
 * int result = 0;
 * 
 * try {
 * 
 * Class.forName(driver); conn = DriverManager.getConnection(url, userid,
 * userpw); String sql = "DELETE from member WHERE num = ?"; pstmt =
 * conn.prepareStatement(sql); int num = Integer.parseInt(pre.getNum());
 * pstmt.setInt(1, num);
 * 
 * result = pstmt.executeUpdate();
 * 
 * } catch (ClassNotFoundException e) { e.printStackTrace(); } catch
 * (SQLException e) { e.printStackTrace(); } finally { try { if(pstmt != null)
 * pstmt.close(); if(conn != null) conn.close(); } catch (SQLException e) {
 * e.printStackTrace(); } }
 * 
 * 
 * return 0; }
 */
