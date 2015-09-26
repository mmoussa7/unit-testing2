package edu.worcester.cs.kwurst;
/* 
 * Copyright (C) 2013, 2014, 2015 Karl R. Wurst, Aparna Mahadev
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

/**
 * Represents a student record for the purposes of a degree audit.
 * 
 * @author Karl R. Wurst
 * @version CS-443 Fall 2015
 */
public class Student
{
    // Information about the individual student
    private String firstName, lastName, id;
    private Transcript transcript;
    
    // Keeps track of the id number to assign to the next student to be created
    private static int nextId = 1;

    /**
     * Creates a new student given a first and last name. An id number is assigned sequentially.
     * 
     * @param firstName the student's first name
     * @param lastName the student's last name
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = String.format("%07d",nextId); // 7 digits wide, zero padded
        nextId++;
		transcript = new Transcript();
    }

    /**
     * Returns the number of students which have been created.
     * 
     * @return the number of students which have been created
     */
    public static int getStudentCount() {
        return nextId-1;
    }

    /**
     * Sets the student's first name.
     * 
     * @param firstName the student's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the student's first name.
     * 
     * @returns the student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's last name.
     *
     * @param lastName the student's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the student's last name.
     * 
     * @returns the student's last name
     */    
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Returns the student's ID number.
     * 
     * @returns the student's ID number
     */    
    public String getId() {
        return id;
    }

    /**
     * Returns the student's GPA.
     * 
     * @return the student's GPA
     */
    public double getGpa() {
        return transcript.getGpa();
    }
    
    /**
     * Returns the student's current earned credits.
     * 
     * @return the student's current earned credits
     */
    public int getCurrentEarnedCr() {
        return transcript.getCurrentEarnedCr();
    }

    /**
     * Returns the student's anticipated additional credits.
     * 
     * @return the student's anticipated additional credits
     */
    public int getAnticipatedAdditionalCr() {
        return transcript.getAnticipatedAdditionalCr();
    }

    /**
     * Sets whether the student has completed the LASC requirements.
     * (This should really be done by looking at a 
     * list of completed courses, not by setting it directly.)
     * 
     * @param lascComplete whether LASC requirements are complete
     */
    public void setLascComplete(boolean lascComplete) {
        transcript.setLascComplete(lascComplete);
    }

    /**
     * Returns whether the student has completed the LASC requirements.
     * 
     * @return whether the student has completed the LASC requirements
     */
    public boolean getLascComplete() {
        return transcript.getLascComplete();
    }

    /**
     * Sets whether the student has completed the major requirements.
     * (This should really be done by looking at a 
     * list of completed courses, not by setting it directly.)
     * 
     * @param majorComplete whether major requirements are complete
     */
    public void setMajorComplete(boolean majorComplete) {
        transcript.setMajorComplete(majorComplete);
    }

    /**
     * Returns whether the student has completed the major requirements.
     * 
     * @return whether the student has completed the major requirements
     */
    public boolean getMajorComplete() {
        return transcript.getMajorComplete();
    }
    
    /**
     * Returns the student's remaining credits to graduate
     * (not including the courses they are currently taking).
     * 
     * @return the student's remaining credits to graduate
     */
    public int getCurrentRemainingCr() {
    	return transcript.getCurrentRemainingCr();
    }

    /**
     * Returns the student's anticipated remaining credits to graduate
     * (including the courses they are currently taking).
     * 
     * @return the student's anticipated remaining credits to graduate
     */
    public int getAnticipatedRemainingCr() {
    	return transcript.getAnticipatedRemainingCr();
    }

    /**
     * Returns whether the student is ready to graduate.
     * 
     * @return whether the student is ready to graduate
     */
    public boolean readyToGraduate() {
    	return transcript.readyToGraduate();
    }
    
	/**
	 * Adds a course to the student's transcript.
	 * 
	 * @param courseToAdd the course to add
	 */

	public void addCourse(Course c, Transcript.Semester semester, int year, Grade grade) {
		transcript.addCourse(c, semester, year, grade);
	}

	public boolean dropCourse(Course c, Transcript.Semester semester, int year) {
		return transcript.dropCourse(c, semester, year);
	}
	
	public boolean changeGrade(Course c, Transcript.Semester semester, int year, Grade grade) {
		return transcript.changeGrade(c, semester, year, grade);
	}
	
	/**
    * Returns the list of courses as a String.
    * 
    * @return the list of courses the student has taken
    */
    public String getTranscript() {
    	return transcript.getTranscript();
    }
    
	/**
	 * Returns a String representation of a Student
	 * 
	 * @return a string representing the student
	 */
	public String toString() {
		String s = id + " " + firstName + " " + lastName;
		s += "\tGPA = " + transcript.getGpa();
		s += "\tCredits Completed = " + transcript.getCurrentEarnedCr();
		s += "\nHere are all the courses the student has taken so far";
		s += "\n-----------------------------------------------------";
		s += "\n" + transcript.getTranscript();
        return s;
    }	
    
}
