package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TranscriptTest {

	Transcript t1;
	
	@Before
	public void setUp() throws Exception {
		t1 = new Transcript();
	}

	@Test
	public void testGpa() {
		assertEquals(0.0, t1.getGpa(), 0.0);
		t1.addCourse(
				new Course("CS", 443, "Software Quality Assurance and Testing", 3), 
				Transcript.Semester.FALL, 2015, new Grade("A"));
		assertEquals(4.0, t1.getGpa(), 0.0);
		t1.addCourse(
				new Course("CS", 448, "Software Development Capstone", 3), 
				Transcript.Semester.FALL, 2015, new Grade("C"));
		assertEquals(3.0, t1.getGpa(), 0.0);
		t1.addCourse(
				new Course("CS", 348, "Software Process Management", 3), 
				Transcript.Semester.FALL, 2015, new Grade("IP"));
		assertEquals(3.0, t1.getGpa(), 0.0);	
	}
	
	@Test
	public void testCourseAttemptedEqual() {
		CourseAttempted c1 = new CourseAttempted(new Course("CS", 348, "Software Process Management", 3), 
				Transcript.Semester.FALL, 2015, new Grade("IP"));
	}

}