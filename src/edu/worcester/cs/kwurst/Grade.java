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

import java.util.HashMap;

/**
 * Represents a course grade with letter and numeric equivalents.
 * 
 * A	4.0
 * A-	3.7
 * B+	3.3
 * B	3.0
 * B-	2.7
 * C+	2.3
 * C	2.0
 * C-	1.7
 * D+	1.3
 * D	1.0
 * D-	0.7
 * E	0.0
 * IP	0.0		In Progress
 * 
 * @author Karl R. WUrst 
 * @version CS-443 Fall 2015
 */
public class Grade
{
    /*
     * Builds a table of letter grades and their numeric equivalents. 
     */
    private static HashMap<String,Double> gradeTable = new HashMap<String,Double>();
    
    static {
        gradeTable.put("A",  4.0);
        gradeTable.put("A-", 3.7);
        gradeTable.put("B+", 3.3);
        gradeTable.put("B",  3.0);
        gradeTable.put("B-", 2.7);
        gradeTable.put("C+", 2.3);
        gradeTable.put("C",  2.0);
        gradeTable.put("C-", 1.7);
        gradeTable.put("D+", 1.3);
        gradeTable.put("D",  1.0);
        gradeTable.put("D-", 0.7);
        gradeTable.put("E",  0.0);
        gradeTable.put("IP", 0.0); // In Progress
    }

    private String grade;
    
    /**
     * Create a Grade from a letter grade.
     * 
     * @param letterGrade the letter grade (A, A-, B+, B, B-, C+, C, C-, D+, D, D-, E, IP).
     * @throws IllegalArgumentException
     */
    public Grade(String letterGrade) {
        if (!gradeTable.containsKey(letterGrade)) {
            throw new IllegalArgumentException(letterGrade + " is not a valid letter grade.");
        }
        grade = letterGrade;
    }
    
    /**
     * Returns the letter grade.
     * 
     * @return the letter grade.
     */
    public String getLetterGrade() {
        return grade;
    }

    /**
     * Returns the numeric grade.
     * 
     * @return the numeric grade.
     */
    public double getNumericGrade() {
        return gradeTable.get(grade);
    }

    /**
     * Returns a printable representation of a Grade
     *
     * @return a printable representation of a Grade
     */
    public String toString()  {
        return grade;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		return true;
	}
    
    
}
