package com.wcu.cs540.project1;

/**
 * @author Raj
 * 
 *         This is Reflector. Provides the functionality to returns the symmetric
 *         equivalent of given character
 */
public class Reflector {

	private String convertingString;

	public Reflector(String convertingString) {
		this.convertingString = convertingString;
	}

	/**
	 * @param ch
	 * @return the symmetric equivalent from Reflector
	 */
	public char convert(char ch) {
		if (EnigmaUtil.isUpperCaseEnglishAlphabet(ch)) {
			int index = ch - 65;
			return convertingString.charAt(index);
		}
		return ch;
	}

}
