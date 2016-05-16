
public class Evaluator implements Visitor{

	
	public Integer visit(PlusExp n) {
		return (Integer)(n.getleft().accept(this)) + (Integer)(n.getright().accept(this));
	}

	
	public Object visit(MultiplyExp n) {
		return (Integer)(n.getleft().accept(this)) * (Integer)(n.getright().accept(this));
	}

	
	public Object visit(MinusExp n) {
		return (Integer)(n.getleft().accept(this)) - (Integer)(n.getright().accept(this));
	}

	
	public Object visit(DivideExp n) {
		return (Integer)(n.getleft().accept(this)) / (Integer)(n.getright().accept(this));
	}

	
	public Object visit(VarExp n) {
		return n.eval();
	}

	
	public Object visit(Number n) {
		return n.eval();
	}
	
	

}
