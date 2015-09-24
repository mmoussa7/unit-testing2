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
 * Represents a course grade.
 * 
 * @author Karl R. WUrst 
 * @version Summer I 2015
 */
public class Grade
{
    /*
     * Builds a table of letter grades and their numeric equivalents.
     * This uses the Java HashMap http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html
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
     * Returns the letter grade (A, A-, B+, B, B-, C+, C, C-, D+, D, D-, E, IP).
     * 
     * @return the letter grade (A, A-, B+, B, B-, C+, C, C-, D+, D, D-, E, IP).
     */
    public String getLetterGrade() {
        return grade;
    }

    /**
     * Returns the numeric grade (4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.0, 0.0).
     * 
     * @return the numeric grade (4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.0, 0.0).
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
}
