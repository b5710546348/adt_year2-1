import java.util.Stack;

public class TreeCell<T> extends Stack {
	private static Stack st = new Stack();
	private int kind;
	private int data;
	private TreeCell<T> left, right;
	private T datum;

	public TreeCell() {

	}

	public TreeCell(T x) {
		datum = x;
	}

	public TreeCell(T x, TreeCell<T> lft, TreeCell<T> rgt) {
		datum = x;
		left = lft;
		right = rgt;
	}

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
			if (operand.contains(text + "")) {
				postfix += text;
			} else if (text == '(') {
				st.push(text);
			} else if (st.isEmpty()) {
				st.push(text);
			} else if (text == ')') {
				char temp = (char) st.peek();
				while (temp != '(') {
					postfix += temp;
					st.pop();
					temp = (char) st.peek();
				}
				if ((char) st.peek() == '(') {
					st.pop();
				}

			} else if (priority((char) st.peek()) < priority(text)) {
				st.push(text);
			}

			else if (priority((char) st.peek()) >= priority(text)) {
				char temp = (char) st.peek();
				while (priority(temp) >= priority(text) && !st.isEmpty()) {
					temp = (char) st.peek();
					if (temp == '(') {
						break;
					}
					postfix += temp;
					st.pop();

				}
				st.push(text);
			}

		} // end for

		while (!st.isEmpty()) {
			char temp = (char) st.peek();
			if (temp != '(') {
				postfix += temp;

			}
			st.pop();
		}

		return postfix;

	}

	/*
	 * this method returns a root to the equivalent expression tree of the input
	 * postfix form
	 */
	public static TreeCell makeExpTree(String postfix) {
		String number = "1234567890";
		TreeCell root ;
		for (int i = 0; i < postfix.length(); i++) {
			String c = postfix.charAt(i) + "";
			if (number.contains(c)) {
				st.push(new TreeCell(Integer.parseInt(c), null, null));
			} else {
				TreeCell ln = (TreeCell) st.pop();
				TreeCell rn = (TreeCell) st.pop();
				st.push(new TreeCell(c, ln, rn));
			}
		}
		root = (TreeCell) st.pop();
		return root;

	}

	public static void printTree(TreeCell root, int level) {
		if (root != null) {
			printTree(root.right, level + 1);
			for (int i = 0; i < level; i++)
				System.out.print(" ");
			System.out.println(root.datum);
			System.out.println();
			printTree(root.left, level + 1);
		}
	}

	public static void printPrefix(TreeCell root) {
		if (root == null) {
			return;
		}
		System.out.print(root.datum + " ");
		printPrefix(root.left);
		printPrefix(root.right);
	}

	public static void printPostfix(TreeCell root) {
		if (root == null) {
			return;
		}
		printPostfix(root.left);
		printPostfix(root.right);
		System.out.print(root.datum + " ");
	}

	public static void printInfix(TreeCell root) {
		
	}

	public static int eval(TreeCell root) {
		String operand = "1234567890";
		int left_result, right_result;
		int result = 0;
		
		if (operand.contains(root.datum+"")){
			return Integer.parseInt(root.datum+"");
		}
		left_result = eval(root.left);
		right_result = eval(root.right);
		switch (root.datum+"") {
			case "+" : result =  left_result + right_result; break;
			case "*" : result =  left_result * right_result; break;
			case "-" : result =  left_result - right_result; break;
			case "/" : result =  left_result / right_result; break;
		}
		
		return result; 
	}
}
