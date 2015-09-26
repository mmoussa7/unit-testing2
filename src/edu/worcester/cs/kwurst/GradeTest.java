package edu.worcester.cs.kwurst;

/*
 * Copyright (C) 2015 Karl R. Wurst
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 */

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
