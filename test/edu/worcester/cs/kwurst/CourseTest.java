package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseTest {
	private Course course1;

	@Before
	public void setUp() throws Exception {
		course1 = new Course("Math", 1, "Pre-Algebra", 3);
	}

	@After
	public void tearDown() throws Exception {
		course1 = null;
	}

	@Test
	public void testDepartment() {
		course1.setDepartment("History");
		assertEquals("History", course1.getDepartment());
	}

	@Test
	public void testNumber() {
		course1.setNumber(2);
		assertEquals(2, course1.getNumber());
	}

	@Test
	public void testTitle() {
		course1.setTitle("Constitutions");
		assertEquals("Constitutions", course1.getTitle());
	}

	@Test
	public void testCredits() {
		course1.setCredits(4);
		assertEquals(4, course1.getCredits());
	}

	@Test
	public void testToString() {
		String department = "Math";
		int number = 1;
		String title = "Pre-Algebra";
		int credits = 3;
		assertEquals(department + "\t" + number + "\t" + title + "\t" + credits + "CR" ,course1.toString());
	}

}
