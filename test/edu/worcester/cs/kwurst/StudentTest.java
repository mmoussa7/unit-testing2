package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.worcester.cs.kwurst.Transcript.Semester;

public class StudentTest {

	private Student student1;
	private static final Course course1 = new Course("CS", 443, "Software Quality Assurance and Testing", 3);
	private static final Course course2 = new Course("AR", 130, "Painting I", 3);
	private static final Course course3 = new Course("UR", 230, "Technology, Public Policy, and Urban Society", 3);
	private static final Course course4 = new Course("EN", 252, "Technical Writing", 3);
	
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
	
	@Test
	public void testGpaNoCourses() {
		assertEquals(0.0, student1.getGpa(), 0.0);
	}
	
	@Test
	public void testGpaSingleCourse() {
		student1.addCourse(course1, Semester.FALL, 2015, Grade.A);
		assertEquals(4.0, student1.getGpa(), 0.0);
	}
	
	@Test
	public void testGpaMultipleCourses() {
		student1.addCourse(course1, Semester.FALL, 2015, Grade.A);
		student1.addCourse(course2, Semester.FALL, 2015, Grade.A_MINUS);
		assertEquals(3.85, student1.getGpa(), 0.01);
	}
	
	@Test
	public void testGpaInProgressCourses() {
		student1.addCourse(course1, Semester.FALL, 2015, Grade.IN_PROGRESS);
		student1.addCourse(course2, Semester.FALL, 2015, Grade.A);
		assertEquals("In progress courses do not affect GPA", 4.0, student1.getGpa(), 0);
	}
	

}