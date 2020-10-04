package com.javabykiran.SpringbootWeekendBatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringbootController {

	/*@RequestMapping("/getstring")
	public String getString()
	{
		return "hello Spring boot";
	}
	
	@RequestMapping("/getarraylist")
	public ArrayList<String> getArrayList()
	{
		ArrayList<String> arraylist=new ArrayList<>();
		arraylist.add("pqr");
		arraylist.add("str");
		arraylist.add("xyz");
		return arraylist;
	}
	
	@RequestMapping("/getint")
	public int getIntegervalue()
	{
		return 10;
	}
	
	@RequestMapping("/getintarray")
	public int[] getIntegerarray()
	{
		int array[]={10,20,30,40};
		return array;
	}
	
	@RequestMapping("/getintegerlist")
	public ArrayList<Integer> getIntegerlist()
	{
		ArrayList<Integer> list=new ArrayList<>();
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		return list;
	}
	
	@RequestMapping("/getstudent")
	public Student getStudent()
	{
		Student stud=new Student();
		stud.setRollno(111);
		stud.setName("abc");
		stud.setAge(25);
		return stud;
	}
	
	@RequestMapping("/getstudentlist")
	public ArrayList<Student> getArrayListStudent()
	{
		Student stud=new Student();
		stud.setRollno(222);
		stud.setName("pqr");
		stud.setAge(24);
		
		Student stud1=new Student();
		stud1.setRollno(111);
		stud1.setName("abc");
		stud1.setAge(25);
		
		ArrayList<Student> liststudent=new ArrayList<>();
		liststudent.add(stud);
		liststudent.add(stud1);
		
		return liststudent;
	}
	
	@RequestMapping("/gethashmapdata")
	public HashMap<Integer,ArrayList<Student>> getHashmapdata()
	{
		HashMap<Integer,ArrayList<Student>> hm=new HashMap<>();
		
		//Student data
		
		Student stud=new Student();
		stud.setRollno(11);
		stud.setName("Riya");
		stud.setAge(22);
		
		Student stud1=new Student();
		stud1.setRollno(12);
		stud1.setName("Pooja");
		stud1.setAge(23);
		
		ArrayList<Student> studlist=new ArrayList<>();
		studlist.add(stud);
		studlist.add(stud1);

		
		Student stud2=new Student();
		stud2.setRollno(11);
		stud2.setName("Divya");
		stud2.setAge(22);
		
		Student stud3=new Student();
		stud3.setRollno(12);
		stud3.setName("Harshada");
		stud3.setAge(23);
		
		ArrayList<Student> studlist1=new ArrayList<>();
		studlist1.add(stud2);
		studlist1.add(stud3);
		
		
		hm.put(1, studlist);
		hm.put(2, studlist1);
		return hm;
	}
	
	
	
	@PutMapping("/putdata")
	public String putStringData(@RequestBody String data)
	{
		String value="Hello";
		System.out.println("Existing Value:-"+value);
		
		value=data;
		System.out.println("Updated Value:-"+value);
		return "Value Updated";
	}
	
	@RequestMapping("/checkstudent/{rollno}")
	public String checkStudentbyRollNo(@PathVariable String rollno)
	{
		int rollno1=Integer.parseInt(rollno);
		
		Student stud=new Student();
		stud.setRollno(1);
		stud.setName("abc");
		stud.setAge(20);
		
		Student stud1=new Student();
		stud1.setRollno(2);
		stud1.setName("pqr");
		stud1.setAge(22);
		
		
		ArrayList<Student> studentlist=new ArrayList<>();
		studentlist.add(stud);
		studentlist.add(stud1);
		boolean flag=false;
		for(Student student:studentlist)
		{
			if(student.getRollno()==rollno1)
			{
				flag=true;
			}
		}
		if(flag==true)
		{
			return "Student Found!!";
		}
		else
		{
			return "Student Not Found!!";
		}
	
	}
	*/

	
	@GetMapping("/getstudent")
	public ArrayList<Student> getStudent() throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		
		Statement smt=conn.createStatement();
		
		String query="select * from student";
		
		ResultSet rs=smt.executeQuery(query);
		ArrayList<Student> arrayliststudent=new ArrayList<>();
		while(rs.next())
		{
			Student student=new Student();
			
			student.setId(rs.getInt("id"));
			student.setRollno(rs.getInt("rollno"));
			student.setName(rs.getString("name"));
			student.setAge(rs.getString("age"));
			
			arrayliststudent.add(student);
		}
		
		return arrayliststudent;
	}
	
	@PostMapping("/poststudentdata")
	public String postStudentData(@RequestBody Student student) throws SQLException, ClassNotFoundException
	{
		Connection conn=ConfigurationClass.getConnection();
		
		PreparedStatement psmt=conn.prepareStatement("insert into student(rollno,name,age) values(?,?,?)");
		psmt.setInt(1, student.getRollno());
		psmt.setString(2, student.getName());
		psmt.setString(3, student.getAge());
		
		int i=psmt.executeUpdate();
		if(i>0)
		{
			return "Student Added Successfully!! "+i;
		}
		else
		{
			return "Something Went Wrong!!";
		}

	}
	
	@DeleteMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable int id) throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		PreparedStatement psmt=conn.prepareStatement("delete from student where id=?");
		psmt.setInt(1, id);
		int i=psmt.executeUpdate();
		if(i>0)
		{
			return "Student Deleted Successfully!";
		}
		else
		{
			return "Something went Wrong!!";
		}
	
		
	}
	
	@PutMapping("/updatestudent")
	public String updateStudent(@RequestBody Student student) throws ClassNotFoundException, SQLException
	{
		Connection conn=ConfigurationClass.getConnection();
		
		PreparedStatement psmt=conn.prepareStatement("update student set rollno=?,name=?,age=? where id=?");
		psmt.setInt(1, student.getRollno());
		psmt.setString(2, student.getName());
		psmt.setString(3, student.getAge());
		psmt.setInt(4, student.getId());
		
		int i=psmt.executeUpdate();
		if(i>0)
		{
			return "Student"+student.getId()+" Updated Successfully!!";
		}
		else
		{
			return "Something Went Wrong!!";
		}
		
	}
	
	@GetMapping("/getstudentbyid/{id}")
	public Student getStudentbyId(@PathVariable String id) throws ClassNotFoundException, SQLException
	{
		int stud_id=Integer.parseInt(id);
		Connection conn=ConfigurationClass.getConnection();
		PreparedStatement psmt=conn.prepareStatement("select * from student where id=?");
		psmt.setInt(1, stud_id);
		Student stud=new Student();
		ResultSet rs=psmt.executeQuery();
		if(rs.next())
		{
			//int stud_id=rs.getInt("id");
			String name=rs.getString("name");
			String age=rs.getString("age");
			int rollno=rs.getInt("rollno");
			
			//stud.setId(stud_id);
			stud.setRollno(rollno);
			stud.setName(name);
			stud.setAge(age);
		}
		return stud;
	}
	
	
}
