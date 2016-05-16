
public class Simplify implements Visitor{

	
	public Object visit(PlusExp n) {
		if(n.getleft().eval() == 0){
			return (Exp)n.getright().accept(this);
		}
		else if (n.getright().eval() == 0){
			return (Exp)n.getleft().accept(this);
		}
		else if(n.getleft().eval() == n.getright().eval()){
			return new MultiplyExp(new Number("2"),(Exp)n.getleft().accept(this));
		}
		return new PlusExp((Exp)n.getleft().accept(this) , (Exp)n.getright().accept(this));
	}

	
	public Object visit(MinusExp n) {
		if(n.getleft().eval() == n.getright().eval()){
			return new Number("0");
		}
		else if(n.getleft().eval() == 0){
			return (Exp)n.getright().accept(this);
		}
		else if (n.getright().eval() == 0){
			return (Exp)n.getleft().accept(this);
		}
		return new MinusExp((Exp)n.getleft().accept(this) , (Exp)n.getright().accept(this));
	}

	public Object visit(MultiplyExp n) {
		if(n.getleft().eval() == 1 ){
			return (Exp)n.getright().accept(this);
		}
		else if(n.getright().eval() == 1){
			return (Exp)n.getleft().accept(this);
		}
		else if(n.getleft().eval() == 0 || n.getright().eval() == 0){
			return new Number("0");
		}
		
		return new MultiplyExp((Exp)n.getleft().accept(this) , (Exp)n.getright().accept(this));
	}
	public Object visit(DivideExp n) {
		if(n.getright().eval() == 1){
			return n.getleft().accept(this);
		}
		if(n.getleft().eval() == 0){
			return new Number("0");
		}
		if(n.getleft().eval() == n.getright().eval()){
			return new Number("1");
		}
		return new DivideExp((Exp)n.getleft().accept(this) , (Exp)n.getright().accept(this));
	}

	
	public Object visit(VarExp n) {
		
		return new VarExp(n.getdatum());
	}

	
	public Object visit(Number n) {
		
		return new Number(n.getdatum());
	}
}
