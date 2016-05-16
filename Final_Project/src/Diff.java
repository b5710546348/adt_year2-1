
public class Diff implements Visitor{

	
	public Object visit(PlusExp n) {
		Exp exp = new PlusExp((Exp)(n.getleft().accept(this)) ,(Exp)( n.getright().accept(this)));
		return exp;
	}

	
	public Object visit(MinusExp n) {
		Exp exp = new MinusExp((Exp)(n.getleft().accept(this)) ,(Exp)( n.getright().accept(this)));
		return exp;
	}

	
	public Object visit( MultiplyExp n) {
		Exp exp1 = new MultiplyExp((Exp)n.getleft() , (Exp)(n.getright().accept(this)));
		Exp exp2 = new MultiplyExp((Exp)n.getright() , (Exp)(n.getleft().accept(this)));
		Exp result = new PlusExp(exp1 , exp2);
		return result;
	}

	
	public Object visit(DivideExp n) {
		Exp exp1 = new MultiplyExp((Exp)n.getright() , (Exp)(n.getleft().accept(this)));
		Exp exp2 = new MultiplyExp((Exp)n.getleft() , (Exp)(n.getright().accept(this)));
		Exp exp3 = new MultiplyExp((Exp)n.getright(),(Exp)n.getright());
		Exp exp4 = new MinusExp(exp1,exp2);
		Exp result = new DivideExp(exp4,exp3);
		return result;
	}

	
	public Object visit(VarExp n) {
		
		return new VarExp("1");
	}

	
	public Object visit(Number n) {
		
		return new Number("0");
	}

}
