import java.util.Scanner;

public class HT {
	private static Scanner scanner = new Scanner(System.in);

	// plot H centered on (xpos, ypos)
	public static void plotH(double xpos, double ypos, double size) {
		// compute the coordinates of H
		double xpos0 = xpos - size / 2;
		double xpos1 = xpos + size / 2;
		double ypos0 = ypos - size / 2;
		double ypos1 = ypos + size / 2;
		// draw H
		StdDraw.line(xpos0, ypos0, xpos0, ypos1); // left H
		StdDraw.line(xpos1, ypos0, xpos1, ypos1); // right H
		StdDraw.line(xpos0, ypos, xpos1, ypos); // connect the H
	}

	public static void plot(int n, double xpos, double ypos, double size) {
		if (n == 0)	{
			return;
		}
		plotH(xpos, ypos, size);
		// compute xpos- and ypos-coordinates of H
		double xpos0 = xpos - size / 2.0;
		double xpos1 = xpos + size / 2.0;
		double ypos0 = ypos - size / 2.0;
		double ypos1 = ypos + size / 2.0;
		// Your job is to fill in this part. Hint: think about recursively
		// calling plot 4 times to cover all the H corners
		plot(n - 1, xpos0, ypos0, size / 2.0);
		plot(n - 1, xpos0, ypos1, size / 2.0);
		plot(n - 1, xpos1, ypos0, size / 2.0);
		plot(n - 1, xpos1, ypos1, size / 2.0);

	}

	public static void main(String[] args) {
		System.out.print("Input size : ");
		int N = scanner.nextInt();
		double xpos = 0.5;
		double ypos = 0.5; // H center
		double size = 0.5; // H side

		plot(N, xpos, ypos, size);
	}
}
