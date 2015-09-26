package edu.worcester.cs.kwurst;

/* 
 * Copyright (C) 2013, 2015 Karl R. Wurst, Aparna Mahadev
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
 * Represents a course with a department, number, title, credits.
 * 
 * @author Karl R. Wurst
 * @author Aparna Mahadev
 * @version CS-443 Fall 2015
 */
public class Course {

	private String department;
	private int number;
	private String title;
	private int credits;
		
	/**
	 * Constructor for Course
	 * 
	 * @param department the department of the course
	 * @param number the number of the course
	 * @param title the title of the course
	 * @param credits the number of credit for the course
	 */
	public Course(String department, int number, String title, int credits) {
		this.department = department;
		this.number = number;
		this.title = title;
		this.credits = credits;
	}

	/**
	 * Returns the department of the course.
	 * 
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the department of the course.
	 * 
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Returns the course number.
	 * 
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the course number.
	 * 
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Returns the course title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the course title.
	 * 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the number of credits.
	 * 
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Sets the number of credits.
	 * 
	 * @param credits the credits to set
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * Prints a course in a pretty format
	 * 
	 * @return a string representation of the course
	 */
	@Override 
	public String toString() {
		return (department + "\t" + number + "\t" + title + "\t" + credits + "CR");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credits;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + number;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (number != other.number)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}