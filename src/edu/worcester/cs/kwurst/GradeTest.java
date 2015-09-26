package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GradeTest {
	
	Grade g1;
	Grade g2;
	Grade g3;

	@Before
	public void setUp() throws Exception {
		g1 = new Grade("A");
		g2 = new Grade("A");
		g3 = new Grade("A-");
	}

	@Test
	public void testGetLetterGrade() {
		assertEquals(g1.getLetterGrade(), "A");
		assertNotEquals(g1.getLetterGrade(), "A-");
	}

	@Test
	public void testGetNumericGrade() {
		assertEquals(g1.getNumericGrade(), 4.0, 0.0);
		assertNotEquals(g3.getNumericGrade(), 4.0, 0.0);
	}
	
	@Test
	public void testEquals() {
		assertEquals(g1, g2);
		assertNotEquals(g1, g3);
	}
}
