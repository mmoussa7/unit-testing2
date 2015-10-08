package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

	private Student student1;

	@Before
	public void setUp() throws Exception {
		student1 = new Student("Jane", "Smith");
	}

	@Test
	public void testStudentFirstName() {
		String karl = "Karl";
		student1.setFirstName(karl);
		assertEquals(karl, student1.getFirstName());
	}

	@Test
	public void testStudentLastName() {
		String wurst = "Wurst";
		student1.setLastName(wurst);
		assertEquals(wurst, student1.getLastName());
	}

	@Test( expected = IllegalArgumentException.class )
	public void testStudentSetFirstNameNull() {
		student1.setFirstName(null);
	}

	@Test( expected = IllegalArgumentException.class )
	public void testStudentSetFirstNameEmpty() {
		student1.setFirstName("");
	}

	@Test( expected = IllegalArgumentException.class )
	public void testStudentSetFirstNameInvalidCharacters() {
		student1.setFirstName("CS-443");
	}

	@Test( expected = IllegalArgumentException.class )
	public void testStudentSetLastNameNull() {
		student1.setLastName(null);
	}

	@Test( expected = IllegalArgumentException.class )
	public void testStudentSetLastNameEmpty() {
		student1.setLastName("");
	}

	@Test( expected = IllegalArgumentException.class )
	public void testStudentSetLastNameInvalidCharacters() {
		student1.setLastName("CS-443");
	}

	@Test( expected = IllegalArgumentException.class )
	public void testStudentConstructorNullFirstName() {
		@SuppressWarnings( "unused" )
		Student student2 = new Student(null, "Wurst");
	}

	@Test( expected = IllegalArgumentException.class )
	public void testStudentConstructorNullLastName() {
		@SuppressWarnings( "unused" )
		Student student2 = new Student("Karl", null);
	}

	@Test
	public void testLascComplete() {

		boolean lascComplete = false;
		student1.setLascComplete(lascComplete);
		assertEquals(lascComplete, student1.getLascComplete());

		lascComplete = true;
		student1.setLascComplete(lascComplete);
		assertEquals(lascComplete, student1.getLascComplete());

	}

	@Test
	public void testMajorComplete() {
		boolean majorComplete = false;
		student1.setMajorComplete(majorComplete);
		assertEquals(majorComplete, student1.getMajorComplete());
		majorComplete = true;
		student1.setMajorComplete(majorComplete);
		assertEquals(majorComplete, student1.getMajorComplete());
	}

	@After
	public void tearDown() {
		student1 = null;
	}

}
