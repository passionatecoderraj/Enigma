package com.wcu.cs540.project1;

/**
 * @author Raj
 * 
 *         Description : This is sort of an utility class helps to determine
 *         number of letters in given String. Furthermore, It also helps in
 *         calculating how many alphabets in the decrypted text are not in the
 *         frequency range of English language.
 */
/*
 *
 */
public class English {

	private final static int max = Rotor.max;
	private static double[] engLetterFreq = { 8.1, 1.6, 3.2, 3.6, 12.3, 2.3, 1.6, 5.1, 7.2, 0.1, 0.5, 4.0, 2.2, 7.2,
			7.9, 2.3, 0.2, 6.0, 6.6, 9.6, 3.1, 0.9, 2.0, 0.2, 1.9, 0.1 };
	private static int[] engLetterDeviation = { 10, 50, 30, 30, 10, 30, 50, 20, 15, 100, 80, 30, 30, 20, 20, 30, 100,
			30, 20, 15, 30, 60, 40, 100, 40, 100 };
	private static int[] letterCount = new int[max];
	private static double[] letterPercent = new double[max];

	/**
	 * @param s
	 *            This method count the number of capital letters and updates
	 *            the same locally
	 */
	public static void countAllLetters(String s) {
		// count reset
		for (int i = 0; i < max; i++) {
			letterCount[i] = 0;
		}

		for (int i = 0; i < s.length(); i++) {
			if (EnigmaUtil.isUpperCaseEnglishAlphabet(s.charAt(i))) {
				int index = s.charAt(i) - 65;
				letterCount[index]++;
			}
		}
		calculatePercentageForAllLetters();
	}

	/**
	 * This calculates the percentage of occurrence of each letter relative to
	 * other letter
	 * 
	 */
	private static void calculatePercentageForAllLetters() {
		// percentage reset
		for (int i = 0; i < max; i++) {
			letterPercent[i] = 0;
		}

		int sum = 0;
		for (int i = 0; i < max; i++) {
			sum += letterCount[i];
		}

		for (int i = 0; i < max; i++) {
			letterPercent[i] = (double) (letterCount[i] * 100) / sum;
		}

	}

	/**
	 * 
	 * @param mult
	 * @return
	 * 
	 * 		Returns count of alphabets that are not in the range of actual
	 *         frequencies of English alphabet
	 */
	public static int getErrorCount(double mult) {
		int errorCount = 0;
		for (int i = 0; i < max; i++) {
			if (!isInRange(i, mult))
				errorCount++;
		}
		return errorCount;
	}

	/**
	 * 
	 * @param i
	 * @param mult
	 * @return
	 * 
	 * 		This method check whether given alphabet is with in the range of
	 *         Frequency count
	 */
	private static boolean isInRange(int i, double mult) {
		double low, high, val;
		val = (mult * engLetterDeviation[i] * engLetterFreq[i]) / 100;
		low = engLetterFreq[i] - val;
		high = engLetterFreq[i] + val;
		return letterPercent[i] >= low && letterPercent[i] <= high;
	}

}
