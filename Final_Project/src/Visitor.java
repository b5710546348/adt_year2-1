
public interface Visitor {
	public Object visit(PlusExp n);
	public Object visit(MultiplyExp n);
	public Object visit(MinusExp n);
	public Object visit(DivideExp n);
	public Object visit(VarExp n);
	public Object visit(Number n);
	
}
