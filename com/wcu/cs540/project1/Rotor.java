/**
 * 
 */
package com.wcu.cs540.project1;

/**
 * @author Raj
 *
 *         This class provides functionality of Rotor including calculating the
 *         R->L wiring just once
 */
public class Rotor {

	// instance variables
	// rotor position
	private int position;
	// number of alphabets
	public final static int max = 26;
	// L->R wiring - from constructor parameter
	private char[] leftToRightWiring = new char[max];

	// R->L wiring - generated from R->L wiring
	private char[] rightToLeftWiring = new char[max];

	/**
	 * 
	 * @param s
	 * 
	 *            it accepts it's L->R wiring representation. Then calculates
	 *            the R->L wiring to improve time complexity
	 */
	public Rotor(String s) {
		leftToRightWiring = s.toCharArray();
		for (int i = 0; i < max; i++) {
			rightToLeftWiring[leftToRightWiring[i] - 65] = (char) (i + 65);
		}
	}

	/**
	 * 
	 * @return true if rotor reaches its maximum position else return false
	 */
	public boolean inc() {
		if (position < max - 1) {
			position = (position + 1) % max;
		} else if (position == max - 1) {
			position = (position + 1) % max;
			return true;
		}
		return false;
	}

	public void set(int n) {
		this.position = n;
	}

	/**
	 * 
	 * @param c
	 * @return L->R equivalent of character c
	 */
	public char encodeLR(char c) {
		if (EnigmaUtil.isUpperCaseEnglishAlphabet(c)) {
			int index = c - 65;
			index = (index + position) % max;
			return leftToRightWiring[index];
		}
		return c;
	}

	/**
	 * 
	 * @param c
	 * @return R->L equivalent of character c
	 */
	public char encodeRL(char c) {
		char ch = c;
		if (EnigmaUtil.isUpperCaseEnglishAlphabet(c)) {
			int index = c - 65;
			index = rightToLeftWiring[index] - 65;
			if (index - position < 0)
				index = max + index - position;

			else
				index = index - position;
			return (char) (index + 65);
		}
		return ch;
	}
}
