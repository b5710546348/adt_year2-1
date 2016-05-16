import java.util.Stack;

public class Main {
	

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
		if(root != null){
			if("1234567890".contains(root.getdatum()) || Character.isAlphabetic((int)(root.getdatum().charAt(0)))){
				System.out.print(root.getdatum());
			}
			else{
				System.out.print("(");
				printInfix(root.getleft());
				System.out.print(root.getdatum());
				printInfix(root.getright());
				System.out.print(")");
			}
		}
	}

	public static int eval(Exp root) {
		String operand = "1234567890";
		int left_result, right_result;
		int result = 0;

		if (operand.contains(root.getdatum() + "")) {
			return Integer.parseInt(root.getdatum() + "");
		}
		left_result = eval(root.getleft());
		right_result = eval(root.getright());
		switch (root.getdatum() + "") {
		case "+":
			result = left_result + right_result;
			break;
		case "*":
			result = left_result * right_result;
			break;
		case "-":
			result = left_result - right_result;
			break;
		case "/":
			result = left_result / right_result;
			break;
		}

		return result;
	}

	public static void main(String[] args) {
		 String test1 = "(5/4+((2*3)+(4-5)*(8*9))+4";
		 String test2 = "3-4-5-6/5+(8*5)";
		 String test3 = "2/5*3-4/6-8*5";
		 String test4 = "(((2*2)+5)*4)+(8-4/5+6)";
		 String test5 = "((8/3*5-7)-6)/2";
		 String test6 = "((8/9)+(4/5)*(2*5/3))";
		 
		 System.out.println("Evaluation Test\n\n");
		
		 evalTest(test1); evalTest(test2); evalTest(test3);
		 evalTest(test4); evalTest(test5); evalTest(test6);
		 
		 String test_diff_1 = "(x*x)*(x*x)*x*(3*x+4)";
		 String test_diff_2 = "(x*x*x*x*x)+(2*6*x*3)*2";
		 String test_diff_3 = "(2*3*x*(5*x*4)+6-(4*5*x))";
		 String test_diff_4 = "((2*3)-(5*x))+((3*x)-3)";
		 String test_diff_5 = "((x*x+2*x+1)-(x-1)*(x+1))";
		 String test_diff_6 = "(2+x)*(4*x)*(3*x/5)";
		 
		 System.out.println("Diffrential and Simplification Test\n\n");
		 
		 diffTest(test_diff_1); diffTest(test_diff_2); diffTest(test_diff_3);
		 diffTest(test_diff_4); diffTest(test_diff_5); diffTest(test_diff_6);
		 
		 System.out.println("Assembly Code Generator Test\n\n");
		 
		 String mips_test_1 = "((1+5)/3) * 2";
		 String mips_test_2 = "(3-2)*4+5-6*3";
		 String mips_test_3 = "(9*4)+(3/2)*5";
		 MIPSTest(mips_test_1); MIPSTest(mips_test_2); MIPSTest(mips_test_3);
		 
}

	public static void evalTest(String test) {
		
		String postfix = ExpTree.IntoPos(test);
		Exp exp = ExpTree.makeExpTree(postfix);
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
		System.out.println("Normal Evaluation : " + eval(exp) );
		Visitor eval = new Evaluator();
		System.out.println("Visitor Evaluation :  " + exp.accept(eval) + "\n");

	}
	
	public static void diffTest(String test){
		String postfix = ExpTree.IntoPos(test);
		Exp exp = ExpTree.makeExpTree(postfix);
		System.out.println("Original : " + test);
		Visitor diff = new Diff();
		Visitor simp = new Simplify();
		Exp exp1 = (Exp)exp.accept(diff);
		Exp exp2 = (Exp)exp1.accept(simp);
		System.out.print("Differential equation : ");
		printInfix(exp1);
		System.out.println();
		System.out.print("After Simplifly : ");
		printInfix(exp2);
		System.out.println("\n");
	}
	
	public static void MIPSTest(String test){
		String postfix = ExpTree.IntoPos(test);
		Exp exp = ExpTree.makeExpTree(postfix);
		System.out.println("Original : " + test);
		Visitor mips = new MIPSAssemblyCodeGenerator();
		System.out.println("Assembly code : ");
		exp.accept(mips);
		System.out.println("\n");
	}
}
