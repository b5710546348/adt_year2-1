
public abstract class Exp {
	private Exp left;
	private Exp right;
	private String datum;
	
	public abstract int eval();
	public abstract void setLeft(Exp new_left);
	public abstract void setRight(Exp new_right);
	public abstract void setDatum(String new_datum);
	public abstract Exp getright();
	public abstract Exp getleft();
	public abstract String getdatum();
}
