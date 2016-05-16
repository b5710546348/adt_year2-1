import java.util.Stack;

public class ExpTree {
	private static Stack st_oop = new Stack();
	private int kind;
	private int data;

	public static int priority(char c) {
		if (c == '*' || c == '/') {
			return 2;
		}
		if (c == '+' || c == '-') {
			return 1;
		}
		return 0;
	}

	public static String IntoPos(String infix) {
		String postfix = "";
		String operand = "1234567890";
		for (int i = 0; i < infix.length(); i++) {
			char text = infix.charAt(i);
			if (text == ' ') {
				continue;
			}
			if (operand.contains(text + "") || Character.isAlphabetic((int) text)) {
				postfix += text;
				continue;
			} else if (text == '(') {
				st_oop.push(text);
			} else if (st_oop.isEmpty()) {
				st_oop.push(text);
			} else if (text == ')') {
				char temp = (char) st_oop.peek();
				while (temp != '(') {
					postfix += temp;
					st_oop.pop();
					temp = (char) st_oop.peek();
				}
				if ((char) st_oop.peek() == '(') {
					st_oop.pop();
				}

			} else if (priority((char) st_oop.peek()) < priority(text)) {
				st_oop.push(text);
			}

			else if (priority((char) st_oop.peek()) >= priority(text)) {
				char temp = (char) st_oop.peek();
				while (priority(temp) >= priority(text) && !st_oop.isEmpty()) {
					temp = (char) st_oop.peek();
					if (temp == '(') {
						break;
					}
					postfix += temp;
					st_oop.pop();

				}
				st_oop.push(text);
			}

		} // end for

		while (!st_oop.isEmpty()) {
			char temp = (char) st_oop.peek();
			if (temp != '(') {
				postfix += temp;

			}
			st_oop.pop();
		}

		return postfix;

	}

	/*
	 * this method returns a root to the equivalent expression tree of the input
	 * postfix form
	 */
	public static Exp makeExpTree(String postfix) {
		String number = "1234567890";
		Exp root, left, right;
		Number num;
		for (int i = 0; i < postfix.length(); i++) {
			String c = postfix.charAt(i) + "";

			switch (c) {
			case "+":
				right = (Exp) st_oop.pop();
				left = (Exp) st_oop.pop();
				root = new PlusExp(left, right);
				st_oop.push(root);
				break;

			case "-":
				right = (Exp) st_oop.pop();
				left = (Exp) st_oop.pop();
				root = new MinusExp(left, right);
				st_oop.push(root);
				break;
			case "*":
				right = (Exp) st_oop.pop();
				left = (Exp) st_oop.pop();
				root = new MultiplyExp(left, right);
				st_oop.push(root);
				break;
			case "/":
				right = (Exp) st_oop.pop();
				left = (Exp) st_oop.pop();
				root = new DivideExp(left, right);
				st_oop.push(root);
				break;
			default:
				if ("1234567890".contains(c)) {
					num = new Number(c);
					st_oop.push(num);
				} else {
					st_oop.push(new VarExp(c));
				}
			}

		}
		root = (Exp) st_oop.pop();
		return root;

	}

	public static void printTree(Exp root, int level) {
		if (root != null) {
			printTree(root.getright(), level + 1);
			for (int i = 0; i < level; i++)
				System.out.print(" ");
			System.out.println(root.getdatum());
			System.out.println();
			printTree(root.getleft(), level + 1);
		}
	}

	public static void printPrefix(Exp root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getdatum() + " ");
		printPrefix(root.getleft());
		printPrefix(root.getright());
	}

	public static void printPostfix(Exp root) {
		if (root == null) {
			return;
		}
		printPostfix(root.getleft());
		printPostfix(root.getright());
		System.out.print(root.getdatum() + " ");
	}

	public static String printInfix(Exp root) {
		if (root.getleft() != null || root.getright() != null) {
			String s1 = printInfix(root.getleft());
			String s2 = printInfix(root.getright());
			return s1 + root.getdatum() + s2;
		} else {
			return root.getdatum();
		}
	}

	public static int eval(Exp root) {

		return 0;
	}
}
