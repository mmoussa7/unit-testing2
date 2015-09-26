package edu.worcester.cs.kwurst;
/* Copyright (C) 2013, 2014, 2015 Karl R. Wurst, Aparna Mahadev
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
import java.util.ArrayList;

/**
 * Represents a student transcript for the purposes of a degree audit.
 * 
 * @author Karl R. Wurst
 * @version CS-443 Fall 2015
 */
public class Transcript {
    private double gpa;
    private int currentEarnedCr; // Current earned credits (already completed)
    private int anticipatedAdditionalCr; // Anticipated additional credits (currently taking)
    private boolean lascComplete; // Has the student completed LASC requirements
    private boolean majorComplete; //Has the student completed requirements for the major
	private ArrayList<CourseAttempted> transcript;
	
	public enum Semester { FALL, INTERSESSION, SPRING, SUMMER1, SUMMER2 };

    // Minimum number of credits required to graduate
    public static final int REQUIRED_CR = 120;
    // Minimum GPA required to graduate
    public static final double REQUIRED_GPA = 2.0;
    
    /**
     * Creates a new student transcript.
     */
    public Transcript() {
		transcript = new ArrayList<CourseAttempted> ();
    }

    /**
     * Returns the student's GPA.
     * 
     * @return the student's GPA
     */
    public double getGpa() {
        return gpa;
    }
    
    /**
     * Returns the student's current earned credits.
     * 
     * @return the student's current earned credits
     */
    public int getCurrentEarnedCr() {
        return currentEarnedCr;
    }

    /**
     * Returns the student's anticipated additional credits.
     * 
     * @return the student's anticipated additional credits
     */
    public int getAnticipatedAdditionalCr() {
        return anticipatedAdditionalCr;
    }

    /**
     * Sets whether the student has completed the LASC requirements.
     * (This should really be done by looking at a 
     * list of completed courses, not by setting it directly.)
     * 
     * @param lascComplete whether LASC requirements are complete
     */
    public void setLascComplete(boolean lascComplete) {
        this.lascComplete = lascComplete;
    }

    /**
     * Returns whether the student has completed the LASC requirements.
     * 
     * @return whether the student has completed the LASC requirements
     */
    public boolean getLascComplete() {
        // This should really be done by looking at a 
        // list of complete courses, not by returning a variable.
        return lascComplete;
    }

    /**
     * Sets whether the student has completed the major requirements.
     * (This should really be done by looking at a 
     * list of completed courses, not by setting it directly.)
     * 
     * @param majorComplete whether major requirements are complete
     */
    public void setMajorComplete(boolean majorComplete) {
        this.majorComplete = majorComplete;
    }

    /**
     * Returns whether the student has completed the major requirements.
     * 
     * @return whether the student has completed the major requirements
     */
    public boolean getMajorComplete() {
        // This should really be done by looking at a 
        // list of complete courses, not by returning a variable.
        return majorComplete;
    }
    
    /**
     * Returns the student's remaining credits to graduate
     * (not including the courses they are currently taking).
     * 
     * @return the student's remaining credits to graduate
     */
    public int getCurrentRemainingCr() {
    	if (currentEarnedCr >= 120) {
    		return 0;
    	} else {
    		return REQUIRED_CR - currentEarnedCr;
    	}
    }

    /**
     * Returns the student's anticipated remaining credits to graduate
     * (including the courses they are currently taking).
     * 
     * @return the student's anticipated remaining credits to graduate
     */
    public int getAnticipatedRemainingCr() {
    	if (currentEarnedCr >= 120) {
    		return 0;
    	} else {
    		return getCurrentRemainingCr() - anticipatedAdditionalCr;
    	}
    }

    /**
     * Returns whether the student is ready to graduate.
     * 
     * @return whether the student is ready to graduate
     */
    public boolean readyToGraduate() {
        return getCurrentRemainingCr() == 0 && gpa >= REQUIRED_GPA && lascComplete && majorComplete;
    }
    
	/**
	 * Adds a course to the student's transcript.
	 * 
	 * @param courseToAdd the course to add
	 */
	public void addCourse(Course c, Semester semester, int year, Grade grade) {
	    CourseAttempted courseToAdd = new CourseAttempted(c, semester, year, grade);
	    transcript.add(courseToAdd);

	    if (grade.getLetterGrade().equals("IP")) {
	    	anticipatedAdditionalCr += courseToAdd.course.getCredits();
	    } else {
			// the total number of credits attempted is the sum of
			// creditsCompleted and the number of credits of the course to be added
			// to the transcript
			int creditsAttempted = courseToAdd.course.getCredits() + currentEarnedCr;
			
			// gpa is computed by doing the following:
			// for each course attempted, multiply the number of credits by the
			// course grade.  
			// gpa is the sum of the above for all the courses divided by the
			// number of total credits
			// 
			double currentPoints = gpa * currentEarnedCr + 
					courseToAdd.grade.getNumericGrade() * courseToAdd.course.getCredits();
			                        
			gpa = currentPoints / creditsAttempted;
			
			if (courseToAdd.grade.getNumericGrade() > 0) 
			   currentEarnedCr += courseToAdd.course.getCredits();
	    }
	}
	
	public boolean dropCourse(Course c, Semester semester, int year) {
	    CourseAttempted courseToDrop = new CourseAttempted(c, semester, year, new Grade("IP"));
	    return transcript.remove(courseToDrop);
	}
	
	public boolean changeGrade(Course c, Semester semester, int year, Grade grade) {
	    CourseAttempted courseToChange = new CourseAttempted(c, semester, year, new Grade("IP"));
		int index = transcript.indexOf(courseToChange);
		if (index > 0) {
			courseToChange.grade = grade;
			transcript.set(index, courseToChange);
			return true;
		}
		return false;
	}

	/**
    * Returns the list of courses as a String.
    * 
    * @return the list of courses the student has taken
    */
    public String getTranscript() {
        String courseList = "";
        
        for (CourseAttempted ca: transcript) 
            courseList = courseList + ca + "\n";
                       
        return courseList;
    }
    
	/**
	 * Returns a String representation of a Student
	 * 
	 * @return a string representing the student
	 */
	public String toString() {
        return getTranscript();
    }	
    
    /**
     * Represents a course attempted by a student
     * in a given semester, year, and a grade
     * 
     * @author Aparna Mahadev
     * @version 1
     */
    
    /* This is an example of inner class.  Inner class is a class within another class.
     * Inner classes can be used to implement helper classes like the one shown here.
     * Here the inner class is defined to be private to restrict its visibility to only
     * the Student class.  Other classes in the package are not aware of its existence and
     * cannot use them.  Outer class Student can access the inner class's private instance
     * variables directly.  Refer to lines 115. 124 and 129 in this file.  The private
     * instance variable course of the inner class is accessed directly by the outer class (in
     * this case Student).
     */
	private class CourseAttempted  {

		private Course course;
		private Semester semester;
		private int year;
		private Grade grade;

		/**
		 * Constructor for objects of class CourseAttempted
		 * @param c The course that was attempted by the student
		 * @param semester Semester in which the course was taken
		 * @param year Year in which the course was taken
		 * @param grade Grade the student received for this course
		 */
		public CourseAttempted(Course c, Semester semester, int year, Grade grade)   {
			this.course = c;
			this.semester = semester;
			this.year = year;
			this.grade = grade;
		}

		/** 
		 * Returns a String representation of a course attempted
		 */
		public String toString() {
			String s = course.toString();
			s += "\t" + semester + year;
			s += "\t" + grade;
			return s;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((course == null) ? 0 : course.hashCode());
			result = prime * result + ((grade == null) ? 0 : grade.hashCode());
			result = prime * result + ((semester == null) ? 0 : semester.hashCode());
			result = prime * result + year;
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
			CourseAttempted other = (CourseAttempted) obj;
			if (course == null) {
				if (other.course != null)
					return false;
			} else if (!course.equals(other.course))
				return false;
			if (grade == null) {
				if (other.grade != null)
					return false;
			} else if (!grade.equals(other.grade))
				return false;
			if (semester == null) {
				if (other.semester != null)
					return false;
			} else if (!semester.equals(other.semester))
				return false;
			if (year != other.year)
				return false;
			return true;
		}
	}

	public Transcript getOuterType() {
		return Transcript.this;
	} 
	
}
