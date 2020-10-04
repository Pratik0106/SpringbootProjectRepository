package com.javabykiran.SpringbootWeekendBatch;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {

	@GetMapping("/getintdata")
	public int getIntData()
	{
		return 10;
	}
	
	@GetMapping("/getarraylist")
	public ArrayList<Integer> getArrayList()
	{
		ArrayList<Integer> arraylist=new ArrayList<>();
		arraylist.add(10);
		arraylist.add(20);
		arraylist.add(30);
		return arraylist;
	}
	
	@PostMapping("/datapost")
	public String postStringData(@RequestBody String data)
	{
		System.out.println("Data :-"+data);
		return "String Data Posted";
	}
	
	@PostMapping("/postlist")
	public String postIntegerArrayList(@RequestBody ArrayList<Integer> list)
	{
		System.out.println(list);
		for(Integer data:list)
		{
			System.out.println(data);
		}
		return "ArrayList Data posted";
	}
	
	@GetMapping("/getstudentdata")
	public Student getStudent()
	{
		Student student=new Student();
		student.setId(101);
		student.setName("abc");
		student.setRollno(20);
		student.setAge("20");
		return student;
	}
	
	@GetMapping("/getstudentarraylist")
	public ArrayList<Student> getStudentlist()
	{
		Student student=new Student();
		student.setId(101);
		student.setName("abc");
		student.setRollno(20);
		student.setAge("20");
		
		Student student1=new Student();
		student1.setId(102);
		student1.setName("xyz");
		student1.setRollno(22);
		student1.setAge("20");
		
		ArrayList<Student> list=new ArrayList<>();
		list.add(student);
		list.add(student1);
		
		return list;
	}
	
	@PostMapping("/postdata")
	public String postStudentDatabyjson(@RequestBody Student stud)
	{
		System.out.println("Student Name:-"+stud.getName() +" Student Roll NO:-"+stud.getRollno()+" Student Age:-"+stud.getAge());
		return "Data Added successfully";
	}
	
	
}
