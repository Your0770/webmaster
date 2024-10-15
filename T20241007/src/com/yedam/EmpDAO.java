package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	//field
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	//constructor
	
	//method
	void getOpen(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.25:1521:xe",
					"java",
					"1234"
					);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//getOpen()
	
	void getClose() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//getClose()

	public int ins(String empId, String empName, String tel, String hDate, int sal) {
		String sql = ""
				   + "insert into employee(employee_id, employee_name, tel, hire_date, salary) "
				   + "values (?, ?, ?, ?, ?)";
		int rows = 0;
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, empId);
			psmt.setString(2, empName);
			psmt.setString(3, tel);
			psmt.setString(4, hDate);
			psmt.setInt(5, sal);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("사번이 중복됩니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	} //ins()
	
	List<Employee> selAll(){
		String sql = ""
				   + "select * from employee";
		getOpen();
		List<Employee> result = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmId(rs.getString(1));
				emp.setEmName(rs.getString(2));
				emp.setTel(rs.getString(3));
				emp.setHireDate(rs.getString(4));
				emp.setSal(rs.getInt(5));
				
				result.add(emp);
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
	} //selAll()

	int upd(String empId, int sal) {
		String sql = ""
				   + "update employee "
				   + "set salary = ? "
				   + "where employee_id = ? ";
		int rows = 0;
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sal);
			psmt.setString(2, empId);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	} //upd()

	int del(String empId) {
		String sql = ""
				   + "delete from employee "
				   + "where employee_id = ? ";
		int rows = 0;
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, empId);
			rows = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}

	List<Employee> sel(String hDate) {
		String sql = ""
				   + "select * from employee "
				   + "where hire_date >= ? "
				   + "order by hire_date";
		getOpen();
		List<Employee> result = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, hDate);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmId(rs.getString(1));
				emp.setEmName(rs.getString(2));
				emp.setTel(rs.getString(3));
				emp.setHireDate(rs.getString(4));
				emp.setSal(rs.getInt(5));
				
				result.add(emp);
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
	}
	
	
	
	
	
	
}
