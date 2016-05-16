import java.util.Stack;

public class Main {
	private static Stack<Exp> st_oop = new Stack<Exp>();
	//stack for infix -> postfix
	private static Stack st = new Stack();
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
	public static Exp makeExpTree(String postfix) {
		String number = "1234567890";
		Exp root , left , right ;
		Number num;
		for (int i = 0; i < postfix.length(); i++) {
			String c = postfix.charAt(i) + "";
			switch(c){
				case "+" :
					left  = (Exp) st_oop.pop();
					right = (Exp) st_oop.pop();
					root = new PlusExp(left, right);
					st_oop.push(root);
					break;
					
				case  "-" :
					left  = (Exp) st_oop.pop();
					right = (Exp) st_oop.pop();
					root = new MinusExp(left, right);
					st_oop.push(root);
					break;
				case  "*" :
					left  = (Exp) st_oop.pop();
					right = (Exp) st_oop.pop();
					root = new MultiplyExp(left, right);
					st_oop.push(root);
					break;
				case  "/" :
					left  = (Exp) st_oop.pop();
					right = (Exp) st_oop.pop();
					root = new DivideExp(left, right);
					st_oop.push(root);
					break;
				default :
					num = new Number(c);
					st_oop.push(num);
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

	public static void printInfix(Exp root) {
		if(root == null){
			return;
		}
		printInfix(root.getleft());
		System.out.print(root.getdatum() + " ");
		printInfix(root.getright());
	}

	public static int eval(Exp root) {
		String operand = "1234567890";
		int left_result, right_result;
		int result = 0;
		
		if (operand.contains(root.getdatum()+"")){
			return Integer.parseInt(root.getdatum()+"");
		}
		left_result = eval(root.getleft());
		right_result = eval(root.getright());
		switch (root.getdatum()+"") {
			case "+" : result =  left_result + right_result; break;
			case "*" : result =  left_result * right_result; break;
			case "-" : result =  left_result - right_result; break;
			case "/" : result =  left_result / right_result; break;
		}
		
		return result; 
	}
	public static void main(String[] args) {
		System.out.println("------------------TEST CASE------------------\n\n");
		String test1 = "((2*3)+(4-5)*(8*9))+4";
		String test2 = "3-4-5-6*5+(8*5)";
		String test3 = "2+5*3-4+6-8*5";
		String test4 = "(((2*2)+5)*4)+(8-4/5+6)";
		String test5 = "((8+3*5-7)-6)*2";
		
		testCase(test1); testCase(test2); testCase(test3);
		testCase(test4); testCase(test5);
		
	}
	public static void testCase(String test){
		Exp exp;
		String postfix = IntoPos(test);
		exp = makeExpTree(postfix);
		System.out.println("Original : " + test);
		System.out.print("PreFix : ");
		printPrefix(exp);
		System.out.println();
		System.out.print("PostFix : ");
		printPostfix(exp);
		System.out.println();
		System.out.print("Infix : ");
		printInfix(exp);
		System.out.println();
		printTree(exp, 1);
		System.out.println("\nResult : " + eval(exp) +"\n\n");
		System.out.println("---------------------------------------------\n\n");
		
	}
}
