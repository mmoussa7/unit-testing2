package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.worcester.cs.kwurst.Transcript.Semester;

public class TranscriptTest {
	
	private Transcript transcript;
	private static final Course course1 = new Course("CS", 443, "Software Quality Assurance and Testing", 3);
	

	@Before
	public void setUp() throws Exception {
		transcript = new Transcript();
	}

	@Test
	public void testAddDropCourse() {
		transcript.addCourse(course1, Semester.FALL, 2015, Grade.IN_PROGRESS);
		assertEquals(3, transcript.getAnticipatedAdditionalCr());
		assertTrue(transcript.dropCourse(course1, Semester.FALL, 2015));
		assertEquals(0, transcript.coursesAttempted());
	}
	
	@Test
	public void testChangeGrade() {
		transcript.addCourse(course1, Semester.FALL, 2015, Grade.IN_PROGRESS);
		assertTrue(transcript.changeGrade(course1, Semester.FALL, 2015, Grade.A));
	}
	
}
