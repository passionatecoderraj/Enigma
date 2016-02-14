package com.wcu.cs540.project1;

import java.io.IOException;

/**
 * @author Raj
 */
/*
 * It’s the starting point of execution for our project. It reads file and
 * look for rotor settings to decrypt the text
 */
public class EnigmaMachineCracker {

	private final static int max = Rotor.max;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {

		Rotor r1 = new Rotor(EnigmaUtil.ROTOR1);
		Rotor r2 = new Rotor(EnigmaUtil.ROTOR2);
		Rotor r3 = new Rotor(EnigmaUtil.ROTOR3);
		Reflector rf = new Reflector(EnigmaUtil.REFLECTOR);

		EnigmaMachine em = new EnigmaMachine(r1, r2, r3, rf);

		String s = EnigmaUtil.readStringFromFile();

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				for (int k = 0; k < max; k++) {
					em.setRotors(k, j, i);
					String encodedS = em.encodeLine(s);
					English.countAllLetters(encodedS);
					int errorCount = English.getErrorCount(EnigmaUtil.MULTIPLIER);
					if (errorCount <= EnigmaUtil.ERRORSALLOWED) {
						System.out.println("Rotor settings are : R1=" + i + ",R2=" + j + ",R3=" + k);
						System.out.println(
								"Current Error count :" + errorCount + ", with Multiplier : " + EnigmaUtil.MULTIPLIER);
						System.out.println(encodedS);
					}
				}
			}
		}
	}
}
