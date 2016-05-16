/**
 *
 * @author paruj
 * 
 *         Instruction: You must complete the code below and make them function
 *         correctly using recursion. No credits will be given otherwise.
 */

public class Rec {
	/** = number of times c occurs in s. */
	public static int numberc(char c, String s) {
		if (s.length() == 0) {
			return 0;
		}
		if (s.charAt(0) == c) {
			return 1 + numberc(c, s.substring(1));
		} else {
			return numberc(c, s.substring(1));
		}

	}

	/** = number of chars in s that are not c. */
	public static int numberNotc(char c, String s) {
		if (s.length() == 0) {
			return 0;
		}
		if (s.charAt(0) == c) {
			return numberc(c, s.substring(1));
		} else {
			return 1 + numberc(c, s.substring(1));
		}

	}

	/**
	 * = a copy of s but with all occurrences of c replaced by d. Example:
	 * replace("abeabe", 'e', '$') = "ab$ab$". For lab purposes, do NOT use the
	 * pre-existing String function replace
	 */
	public static String replace(String s, char c, char d) {
		if (s.length() == 0) {
			return "";
		}
		if (s.charAt(0) == c) {
			return d + "" + replace(s.substring(1), c, d);
		} else {
			return s.charAt(0) + "" + replace(s.substring(1), c, d);
		}

	}

	/**
	 * = a copy of s with adjacent duplicates removed. Example: for s =
	 * "abbcccdeaaa", the answer is "abcdea".
	 */
	public static String rem1(String s) {
		if (s.length() == 2) {
			return "";
		}
		if (s.charAt(0) == s.charAt(1)) {
			return s.charAt(1) + rem1(s.substring(1));
		} else {
			return rem1(s.substring(1));
		}
	}

	/**
	 * = number of the digits in the decimal representation of n. e.g.
	 * numDigits(0) = 1, numDigits(3) = 1, numDigits(34) = 2. numDigits(1356) =
	 * 4. Precondition: n >= 0.
	 */
	public static int numDigits(int n) {
		if (Math.abs(n) < 10) {
			return 1;
		}
		return 1 + numDigits(n / 10);

	}

	/**
	 * = sum of the digits in the decimal representation of n. e.g. sumDigits(0)
	 * = 0, sumDigits(3) = 3, sumDigits(34) = 7, sumDigits(345) = 12.
	 * Precondition: n >= 0.
	 */
	public static int sumDigits(int n) {
		if (n <= 0) {
			return 0;
		}
		return n % 10 + sumDigits(n / 10);
	}

	/**
	 * = a copy of s with to_remove_char removed. Example: removeChar("abeabe",
	 * 'e') = "abab".
	 */
	public static String removeChar(String s, char to_remove_char) {
		if (s.length() == 0) {
			return "";
		} else if (s.charAt(0) == to_remove_char) {
			return "" + removeChar(s.substring(1), to_remove_char);
		}
		return s.charAt(0) + removeChar(s.substring(1), to_remove_char);

	}

	/**
	 * = a copy of s with characters in reverse order. Example:
	 * reverse("abcdefg") = "gfedcab".
	 */
	public static String reverse(String s) {
		if (s.length() == 0) {
			return s;
		}
		return s.charAt(0) + reverse(s.substring(1));

	}

	public static void main(String[] args) {
		System.out.println(numberc('a', "aaabbbaccabda"));
		System.out.println(numberc('b', "aaabbbaccabda"));
		System.out.println(numberc('c', "aaabbbaccabda"));
		System.out.println(numberc('d', "aaabbbaccabda"));
		System.out.println("-----------------");
		System.out.println(numberNotc('a', "aaabbbaccabda"));
		System.out.println(numberNotc('b', "aaabbbaccabda"));
		System.out.println(numberNotc('c', "aaabbbaccabda"));
		System.out.println(numberNotc('d', "aaabbbaccabda"));
		System.out.println("-----------------");
		System.out.println(replace("aaabbbaccabda", 'a', 'b'));
		System.out.println(replace("aaabbbaccabda", 'b', 'c'));
		System.out.println(replace("aaabbbaccabda", 'c', 'd'));
		System.out.println(replace("aaabbbaccabda", 'd', 'a'));
		System.out.println("-----------------");
		System.out.println(rem1("aaabbbaccabda"));
		System.out.println(rem1("abbcccdeaaa"));
		System.out.println(rem1("aaaaaaaaaaaaaaaaaaa"));
		System.out.println(rem1("aabbbccccdddddeeeeeee"));
		System.out.println("-----------------");
		System.out.println(numDigits(123));
		System.out.println(numDigits(-123));
		System.out.println(numDigits(123456));
		System.out.println(numDigits(-123456));
		System.out.println(numDigits(1));
		System.out.println(numDigits(0));
		System.out.println("-----------------");
		System.out.println(sumDigits(123));
		System.out.println(sumDigits(-123));
		System.out.println(sumDigits(123456));
		System.out.println(sumDigits(-123456));
		System.out.println(sumDigits(1));
		System.out.println(sumDigits(0));
		System.out.println("-----------------");
		System.out.println(removeChar("eawabbcceccddeeaaeeeee", 'e'));
		System.out.println(removeChar("acacacacac", 'a'));
		System.out.println("-----------------");
		System.out.println(reverse("aaabbbaccabda"));
		System.out.println(reverse("abbcccdeaaa"));
		System.out.println(reverse("AMANAPLANACANALPANAMA"));
	}
}