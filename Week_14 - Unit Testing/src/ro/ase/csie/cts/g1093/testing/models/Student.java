package ro.ase.csie.cts.g1093.testing.models;
import java.util.ArrayList;

import ro.ase.csie.cts.g1093.testing.exceptions.WrongAgeException;
import ro.ase.csie.cts.g1093.testing.exceptions.WrongGradeException;
import ro.ase.csie.cts.g1093.testing.exceptions.WrongNameException;


public class Student {
	
	public static final int MIN_AGE = 14;
	public static final int MAX_AGE = 90;
	public static final int MIN_GRADE = 1;
	public static final int MAX_GRADE = 10;
	public static final int MIN_NAME_SIZE = 3;
	public static final int MAX_NAME_SIZE = 255;
	
	protected String name;
	protected int age;
	protected ArrayList<Integer> grades;
	
	
	public Student(String name, int age, ArrayList<Integer> grades) {
		super();
		this.name = name;
		this.age = age;
		this.grades = grades;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) throws WrongNameException{
		if(name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE) {
			throw new WrongNameException();
		}
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) throws WrongAgeException{
		if(age < MIN_AGE || age > MAX_AGE) {
			throw new WrongAgeException();
		}
		this.age = age;
	}


	public void setGrades(ArrayList<Integer> grades) throws WrongGradeException{
		this.grades = (ArrayList<Integer>) grades.clone();
	}
	
	
	public int getGrade(int index) {
		return this.grades.get(index);
	}
	
	public int getNoGrades() {
		return this.grades.size();
	}
	

	public float getGradesAverage() {
		
		if(this.grades == null || this.grades.size() == 0) {
			return 0;
		}
		
		float sum = 0;
		for(int grade : this.grades) {
			sum += grade;
		}
		return sum/this.grades.size();
	}
	
	public int getMinGrade() {
		int min = this.grades.get(0);
		for(int grade : grades) {
			if(min > grade) {
				min = grade;
			}
		}
		return min;
	}
	
}