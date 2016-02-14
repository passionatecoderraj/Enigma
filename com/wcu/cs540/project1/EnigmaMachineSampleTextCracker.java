/**
 * 
 */
package com.wcu.cs540.project1;

/**
 * @author Raj
 */
/*
 * This class is to test whether encryption and decryptions works properly
 */
public class EnigmaMachineSampleTextCracker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rotor r1 = new Rotor(EnigmaUtil.ROTOR1);
		Rotor r2 = new Rotor(EnigmaUtil.ROTOR2);
		Rotor r3 = new Rotor(EnigmaUtil.ROTOR3);
		Reflector rf = new Reflector(EnigmaUtil.REFLECTOR);

		EnigmaMachine em = new EnigmaMachine(r1, r2, r3, rf);
		String s = "AAAAAAAAAAAAAAAAAAAAAAAAAAA";
		System.out.println(s);
		em.setRotors(5, 9, 14);
		String encodedS = em.encodeLine(s);
		System.out.println(encodedS);

		em.setRotors(5, 9, 14);
		String decodedEncodedS = em.encodeLine(encodedS);
		System.out.println(decodedEncodedS);
	}
}
