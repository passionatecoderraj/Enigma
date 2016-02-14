package com.wcu.cs540.project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Raj
 *
 *         It has utility methods that can be useful across project. It also
 *         contain constants
 */
public class EnigmaUtil {

	public final static int ERRORSALLOWED = 6;
	public final static double MULTIPLIER = 1.0;

	public final static String ROTOR1 = "QWERTYUIOPLKJHGFDSAZXCVBNM";
	public final static String ROTOR2 = "ZAQWSXCDERFVBGTYHNMJUIKLOP";
	public final static String ROTOR3 = "PLOKMIJNUHBYGVTFCRDXESZWAQ";
	public final static String REFLECTOR = "NPKMSLZTWQCFDAVBJYEHXOIURG";

	private final static String FILEPATH = "C:\\raj\\study\\univ\\540\\encrypted.text";
	private final static int ASCII_FOR_UPPERCASE_START = 65;
	private final static int ASCII_FOR_UPPERCASE_END = 90;

	/**
	 * Returns True if character c is upper case alphabet in English else false
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isUpperCaseEnglishAlphabet(char c) {
		return c >= ASCII_FOR_UPPERCASE_START && c <= ASCII_FOR_UPPERCASE_END;
	}

	/*
	 * Reads encrypted.text file and returns the entire file contents as single
	 * String
	 */
	public static String readStringFromFile() {

		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILEPATH));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				sb.append(sCurrentLine);
			}
		} catch (IOException e) {
			System.out.println("Unknown error occured while loading file");
			e.printStackTrace();
		}

		return sb.toString();
	}

}
