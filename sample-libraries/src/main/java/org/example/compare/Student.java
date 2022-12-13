package org.example.compare;

public class Student {
	private String name;
	private Integer age;
	private boolean graduate;

	public static Student of(String name, Integer age, boolean graduate) {
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		student.setGraduate(graduate);
		return student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isGraduate() {
		return graduate;
	}

	public void setGraduate(boolean graduate) {
		this.graduate = graduate;
	}
}
