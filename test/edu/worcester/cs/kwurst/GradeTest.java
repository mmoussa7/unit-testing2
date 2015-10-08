package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import org.junit.Test;

public class GradeTest {

	@Test( expected = IllegalArgumentException.class )
	public void testInvalidGrade() {
		Grade grade = new Grade("FF");
	}
	
	@Test
	public void testGrade() {
		Grade grade = new Grade("A-");
		assertEquals("A-", grade.getLetterGrade());
		assertEquals(3.7, grade.getNumericGrade(), .09);
	}
}
