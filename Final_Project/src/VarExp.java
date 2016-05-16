
public class VarExp extends Exp{
	
	private Exp left, right;
	private String datum;
	public VarExp(String datum){
		this.datum = datum;
	}
	
	public int eval() {
		char temp = this.datum.charAt(0);
		return (int)temp;
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

	
	public Exp getright() {
		
		return this.right;
	}

	
	public Exp getleft() {
		
		return this.left;
	}

	
	public String getdatum() {
		
		return this.datum;
	}

	
	public Object accept(Visitor v) {
		
		return v.visit(this);
	}

}
