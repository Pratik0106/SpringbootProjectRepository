package com.javabykiran.SpringbootWeekendBatch;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@RequestMapping("/getallemployee")
	public ArrayList<Employee> getAllemployee() throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		
		String query="select * from employee";
	
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(query);
		
		ArrayList<Employee> emplist=new ArrayList<>();
		while(rs.next())
		{
			Employee emp=new Employee();
			
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setPhoneno(rs.getString("phoneno"));
			emp.setDepartmentit(rs.getString("departmentit"));
			emp.setStatus(rs.getString("status"));
			emp.setCreateddtm(rs.getDate("createddtm"));
			emp.setCreatedby(rs.getString("createdby"));
			emp.setUpdateddtm(rs.getDate("updateddtm"));
			emp.setUpdatedby(rs.getString("updatedby"));
			emp.setCid(rs.getInt("cid"));
			emplist.add(emp);
			
		}
		
		return emplist;
	}
	@GetMapping("/getallemployeebyid/{id}")
	public ArrayList<Employee> getAllemployeebyId(@PathVariable String id) throws ClassNotFoundException, SQLException
	{
		int emp_id=Integer.parseInt(id);
		Connection conn=ConfigurationClass.getConnection();
		
		String query="select * from employee where id="+emp_id;
	
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(query);
		
		ArrayList<Employee> emplist=new ArrayList<>();
		while(rs.next())
		{
			Employee emp=new Employee();
			
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setPhoneno(rs.getString("phoneno"));
			emp.setDepartmentit(rs.getString("departmentit"));
			emp.setStatus(rs.getString("status"));
			emp.setCreateddtm(rs.getDate("createddtm"));
			emp.setCreatedby(rs.getString("createdby"));
			emp.setUpdateddtm(rs.getDate("updateddtm"));
			emp.setUpdatedby(rs.getString("updatedby"));
			emp.setCid(rs.getInt("cid"));
			emplist.add(emp);
			
		}
		
		return emplist;
	}
	
	@GetMapping("/getallemployeebyname/{name}")
	public ArrayList<Employee> getAllemployeebyName(@PathVariable String name) throws ClassNotFoundException, SQLException
	{
		
		Connection conn=ConfigurationClass.getConnection();
		
		String query="select * from employee where name='"+name+"'";
	
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(query);
		
		ArrayList<Employee> emplist=new ArrayList<>();
		while(rs.next())
		{
			Employee emp=new Employee();
			
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setPhoneno(rs.getString("phoneno"));
			emp.setDepartmentit(rs.getString("departmentit"));
			emp.setStatus(rs.getString("status"));
			emp.setCreateddtm(rs.getDate("createddtm"));
			emp.setCreatedby(rs.getString("createdby"));
			emp.setUpdateddtm(rs.getDate("updateddtm"));
			emp.setUpdatedby(rs.getString("updatedby"));
			emp.setCid(rs.getInt("cid"));
			emplist.add(emp);
			
		}
		
		return emplist;
	}
	
	@GetMapping("/getallemployeebystatus/{status}")
	public ArrayList<Employee> getAllemployeebyStatus(@PathVariable String status) throws ClassNotFoundException, SQLException
	{
		
		Connection conn=ConfigurationClass.getConnection();
		
		String query="select * from employee where status='"+status+"'";
	
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(query);
		
		ArrayList<Employee> emplist=new ArrayList<>();
		while(rs.next())
		{
			Employee emp=new Employee();
			
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setPhoneno(rs.getString("phoneno"));
			emp.setDepartmentit(rs.getString("departmentit"));
			emp.setStatus(rs.getString("status"));
			emp.setCreateddtm(rs.getDate("createddtm"));
			emp.setCreatedby(rs.getString("createdby"));
			emp.setUpdateddtm(rs.getDate("updateddtm"));
			emp.setUpdatedby(rs.getString("updatedby"));
			emp.setCid(rs.getInt("cid"));
			emplist.add(emp);
			
		}
		
		return emplist;
	}
	
	
	@PostMapping("/addemployee")
	public String addEmployee(@RequestBody Employee emp) throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		
		PreparedStatement psmt=conn.prepareStatement("insert into employee(name,phoneno,departmentit,status,createddtm,createdby,updateddtm,updatedby,cid) values(?,?,?,?,?,?,?,?,?)");
		psmt.setString(1, emp.getName());
		psmt.setString(2,emp.getPhoneno());
		psmt.setString(3, emp.getDepartmentit());
		psmt.setString(4, emp.getStatus());
		psmt.setDate(5, emp.getCreateddtm());
		psmt.setString(6, emp.getCreatedby());
		psmt.setDate(7, emp.getUpdateddtm());
		psmt.setString(8, emp.getUpdatedby());
		psmt.setInt(9, emp.getCid());
		int i=psmt.executeUpdate();///1
		if(i>0)
		{
			return "Employee "+emp.getName()+" Added Successfully!!";
		}
		else
		{
			return "something Went Wrong!!";
		}
		
	}
	@PutMapping("/updateemployee")
	public String updateEmployee(@RequestBody Employee emp) throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		
		PreparedStatement psmt=conn.prepareStatement("update employee set name=?,phoneno=?,departmentit=?,status=?,createddtm=?,createdby=?,updateddtm=?,updatedby=? where id=?");
		psmt.setString(1, emp.getName());
		psmt.setString(2,emp.getPhoneno());
		psmt.setString(3, emp.getDepartmentit());
		psmt.setString(4, emp.getStatus());
		psmt.setDate(5, emp.getCreateddtm());
		psmt.setString(6, emp.getCreatedby());
		psmt.setDate(7, emp.getUpdateddtm());
		psmt.setString(8, emp.getUpdatedby());
		psmt.setInt(9, emp.getId());
		int i=psmt.executeUpdate();///1
		if(i>0)
		{
			return "Employee "+emp.getName()+" Updated Successfully!!";
		}
		else
		{
			return "something Went Wrong!!";
		}
		
	}
	
	
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable String id) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConfigurationClass.getConnection();
		int emp_id=Integer.parseInt(id);
		String query="delete from employee where id="+emp_id;
		
		Statement stmt=connection.createStatement();
		int i=stmt.executeUpdate(query);
		if(i>0)
		{
			return "Employee "+id+" Deleted Successfully!";
		}
		else
		{
			return "Something went wrong!!";
		}
	
	}
	
	@GetMapping("/getallemployeebycname/{cname}")
	public ArrayList<Employee> getAllemployeebyCountryName(@PathVariable String cname) throws ClassNotFoundException, SQLException
	{
		
		Connection conn=ConfigurationClass.getConnection();
		String sql="select * from country where cname='"+cname+"'";
		Statement smt=conn.createStatement();
		ResultSet rs1=smt.executeQuery(sql);
		int id=0;
		if(rs1.next())
		{
			 id=rs1.getInt("cid");
		}
		
		String query="select * from employee where cid="+id;
	
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(query);
		
		ArrayList<Employee> emplist=new ArrayList<>();
		while(rs.next())
		{
			Employee emp=new Employee();
			
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setPhoneno(rs.getString("phoneno"));
			emp.setDepartmentit(rs.getString("departmentit"));
			emp.setStatus(rs.getString("status"));
			emp.setCreateddtm(rs.getDate("createddtm"));
			emp.setCreatedby(rs.getString("createdby"));
			emp.setUpdateddtm(rs.getDate("updateddtm"));
			emp.setUpdatedby(rs.getString("updatedby"));
			emp.setCid(rs.getInt("cid"));
			emplist.add(emp);
			
		}
		
		return emplist;
	}
	
	@GetMapping("/getcountry")
	public ArrayList<Country> getCountry() throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		
		ArrayList<Country> listcountry=new ArrayList<>();
		
		String query="select * from country";
		Statement smt=conn.createStatement();
		
		ResultSet rs=smt.executeQuery(query);
		while(rs.next())
		{
			Country ctr=new Country();
			ctr.setCid(rs.getInt("cid"));
			ctr.setCname(rs.getString("cname"));
			listcountry.add(ctr);
		}
		return listcountry;
	}
	
	@PostMapping("/addcountry")
	public String addCountry(@RequestBody Country country) throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		
		PreparedStatement psmt=conn.prepareStatement("insert into country(cname) values(?)");
		psmt.setString(1, country.getCname());
		
		int i=psmt.executeUpdate();
		if(i>0)
		{
			return "Country "+country.getCname()+" Added Successfully!";
		}
		else
		{
			return "Something Went Wrong!!";
		}
		
	}
	
	@PutMapping("/updatecountry")
	public String updateCountry(@RequestBody Country country) throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		
		PreparedStatement psmt=conn.prepareStatement("update country set cname=? where cid=?");
		psmt.setString(1, country.getCname());
		psmt.setInt(2, country.getCid());
		
		int i=psmt.executeUpdate();
		if(i>0)
		{
			return "Country "+country.getCid()+" Updated Successfully!";
		}
		else
		{
			return "Something Went Wrong!!";
		}
		
	}
	
	@DeleteMapping("/deletecountry/{cid}")
	public String deleteCountry(@PathVariable String cid) throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		
		String query="delete from country where cid="+cid;
		
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate(query);
		if(i>0)
		{
			return "Country "+cid+" Deleted Successfully!";
		}
		else
		{
			return "something Went Wrong";
		}
		
	}
	
	@DeleteMapping("/deletecountrybycname/{cname}")
	public String deleteCountrybycname(@PathVariable String cname) throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		
		String query="delete from country where cname="+cname;
		
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate(query);
		if(i>0)
		{
			return "Country "+cname+" Deleted Successfully!";
		}
		else
		{
			return "something Went Wrong";
		}
		
	}
	
	@GetMapping("/getemployeelistbeforetoday")
	public ArrayList<Employee> getemployeelistbeforetoday() throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		  long millis=System.currentTimeMillis();  
	      
		Date todaydate=new Date(millis);
		System.out.println(todaydate);
		String query="select * from employee where createddtm <'"+todaydate+"'";
		
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		
		ArrayList<Employee>emplist =new ArrayList<>();
		while(rs.next())
		{
			Employee emp=new Employee();
			
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setPhoneno(rs.getString("phoneno"));
			emp.setDepartmentit(rs.getString("departmentit"));
			emp.setStatus(rs.getString("status"));
			emp.setCreateddtm(rs.getDate("createddtm"));
			emp.setCreatedby(rs.getString("createdby"));
			emp.setUpdateddtm(rs.getDate("updateddtm"));
			emp.setUpdatedby(rs.getString("updatedby"));
			emp.setCid(rs.getInt("cid"));
			emplist.add(emp);
		}
		
		return emplist;
	}
}
