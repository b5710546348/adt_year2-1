
/**
 * 
 * @author Patchara Pattiyathanee 5710546348
 * Sep 8 , 2015
 */
import java.util.Scanner;

public class Pascal {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int n = input.nextInt();
		pascal(n);
	}

	public static long getFactorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * getFactorial(n - 1);
	}

	public static long getCombination(int n, int m) {
		return getFactorial(n) / (getFactorial(m) * (getFactorial(n - m)));
	}

	public static void pascal(int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					for (int k = 0; k < n - i; k++) {
						System.out.print("  ");
					}
				}
				System.out.print(getCombination(i, j) + "   ");
			}
			System.out.println();
		}
	}
}
