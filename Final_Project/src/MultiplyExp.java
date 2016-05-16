public class MultiplyExp extends Exp {
	private Exp left, right;
	private String datum;

	public MultiplyExp(Exp a1, Exp a2) {
		left = a1;
		right = a2;
		datum = "*";
	}

	public Exp getleft() {
		return left;
	}

	public Exp getright() {
		return right;
	}

	public String getdatum() {
		return datum;
	}
	public void setLeft(Exp new_left) {

		this.left = new_left;
	}

	public void setRight(Exp new_right) {

		this.right = new_right;
	}

	public void setDatum(String new_datum) {

		this.datum = new_datum;
	}

	public int eval() {
		return left.eval() * right.eval();
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	
}