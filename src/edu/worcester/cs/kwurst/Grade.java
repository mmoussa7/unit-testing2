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


/**
 * Represents a course grade with letter and numeric equivalents. A 4.0 A- 3.7 B+ 3.3 B 3.0 B- 2.7 C+ 2.3 C 2.0 C- 1.7
 * D+ 1.3 D 1.0 D- 0.7 E 0.0 IP 0.0 In Progress
 * 
 * @author Karl R. WUrst
 * @version CS-443 Fall 2015
 */
public enum Grade {

	A("A", 4.0),
	A_MINUS("A-", 3.7),
	B_PLUS("B+", 3.3),
	B("B", 3.0),
	B_MINUS("B-", 2.7),
	C_PLUS("C+", 2.3),
	C("C", 2.0),
	C_MINUS("C-", 1.7),
	D_PLUS("D+", 1.3),
	D("D", 1.0),
	D_MINUS("D-", 0.7),
	F("F", 0.0),
	INCOMPLETE("IC", 0.0),
	IN_PROGRESS("IP", 0.0),
	WITHDRAW("W", 0.0);

	private final String grade;
	private final double value;

	private Grade(String grade, double value) {
		this.grade = grade;
		this.value = value;
	}

	public double getNumericGrade() {
		return this.value;
	}

	public String getLetterGrade() {
		return this.grade;
	}
	
	public boolean isInProgress() {
		return this == IN_PROGRESS;
	}
	
	public boolean isPassingGrade() {
		return this.getNumericGrade() >= C.getNumericGrade();
	}
}
