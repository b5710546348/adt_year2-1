
public class MIPSAssemblyCodeGenerator implements Visitor {

	
	public Object visit(PlusExp n) {
		n.getleft().accept(this);
		System.out.println("sw $a0 0($sp)");
		System.out.println("addiu $sp $sp -4");
		n.getright().accept(this);
		System.out.println("lw $t1 4($sp)");
		System.out.println("add $a0 $t1 $a0");
		System.out.println("addiu $sp $sp 4");
		return null;
	}

	
	public Object visit(MinusExp n) {
		n.getleft().accept(this);
		System.out.println("sw $a0 0($sp)");
		System.out.println("addiu $sp $sp -4");
		n.getright().accept(this);
		System.out.println("lw $t1 4($sp)");
		System.out.println("sub $a0 $t1 $a0");
		System.out.println("addiu $sp $sp 4");
		return null;
	}

	
	public Object visit(MultiplyExp n) {
		n.getleft().accept(this);
		System.out.println("sw $a0 0($sp)");
		System.out.println("addiu $sp $sp -4");
		n.getright().accept(this);
		System.out.println("lw $t1 4($sp)");
		System.out.println("mult $a0 $t1");
		System.out.println("mflo $a0");
		System.out.println("addiu $sp $sp 4");
		return null;
	}

	
	public Object visit(DivideExp n) {
		n.getleft().accept(this);
		System.out.println("sw $a0 0($sp)");
		System.out.println("addiu $sp $sp -4");
		n.getright().accept(this);
		System.out.println("lw $t1 4($sp)");
		System.out.println("div $a0 $t1 $a0");
		System.out.println("addiu $sp $sp 4");
		return null;
	}

	
	public Object visit(VarExp n) {
		System.out.println("li $a0"+n.eval());
		return null;
	}
 
	
	public Object visit(Number n) {
		System.out.println("li $a0 "+n.getdatum());
		return null;
	}
	
}
