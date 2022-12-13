package org.example.compare;

import org.apache.commons.beanutils.BeanComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {

	private final List<Student> students = new ArrayList<>();

	@BeforeEach
	public void setUp() {
		students.add(Student.of("张三", 18, false));
		students.add(Student.of("赵四", 20, true));
		students.add(Student.of("李五", 15, false));
		students.add(Student.of("王二", 19, true));

	}

	//	<!-- https://mvnrepository.com/artifact/commons-beanutils/commons-beanutils -->
	@Test
	public void sortedByName() {
		BeanComparator<Student> sortedRule = new BeanComparator<>("name");
		// (Student t1,Student t2)
		List<Student> studentsBySortedName = students.stream()
			.sorted(sortedRule)
			.toList();
		students.sort(sortedRule);
		Assertions.assertEquals(students.get(0), studentsBySortedName.get(0));
	}

	@Test
	public void sortedByAge() {
		BeanComparator<Student> sortedRule = new BeanComparator<>("age");
		List<Student> studentsBySortedName = students.stream()
			.sorted(sortedRule)
			.toList();
		students.sort(sortedRule);
		Assertions.assertEquals(students.get(0), studentsBySortedName.get(0));
		Integer actualAge = students.get(0).getAge();
		Assertions.assertEquals(actualAge, 15);
	}

	@Test
	public void sortedByUnknownField() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			BeanComparator<Student> sortedRule = new BeanComparator<>("anyUnknownField");
			students.sort(sortedRule);
		});
	}

}
