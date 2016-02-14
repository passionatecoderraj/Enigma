package com.wcu.cs540.project1;

/**
 * @author Raj
 *
 *         This is the heart of Enigma. It provides the functionality to set
 *         rotors and encode/decode given String
 */
public class EnigmaMachine {

	private Rotor r1;
	private Rotor r2;
	private Rotor r3;
	private Reflector r;

	public EnigmaMachine(Rotor r1, Rotor r2, Rotor r3, Reflector r) {
		super();
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r = r;
	}

	/**
	 * 
	 * @param s
	 * @return encrypted/decrypted text
	 * 
	 *         It encrypts/decrypts given text
	 */
	public String encodeLine(String s) {
		StringBuilder sb = new StringBuilder();
		char ch;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (EnigmaUtil.isUpperCaseEnglishAlphabet(ch)) {
				ch = r1.encodeLR(ch);
				ch = r2.encodeLR(ch);
				ch = r3.encodeLR(ch);
				ch = r.convert(ch);
				ch = r3.encodeRL(ch);
				ch = r2.encodeRL(ch);
				ch = r1.encodeRL(ch);
				incrementRotors();
				sb.append(ch);
			} else
				sb.append(ch);
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * 
	 *            Sets the 3 rotor positions respectively
	 */
	public void setRotors(int a, int b, int c) {
		r1.set(a);
		r2.set(b);
		r3.set(c);
	}

	/**
	 * Increment the rotor positions
	 */
	private void incrementRotors() {
		if (r1.inc())
			if (r2.inc())
				r3.inc();
	}
}
