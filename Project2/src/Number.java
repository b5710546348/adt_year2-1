
public class Number extends Exp {
	private String datum;

	public Number(String n0) {
		datum = n0;
	}

	public String getdatum() {
		return datum;
	}

	public int eval() {
		return Integer.parseInt(datum);
	}

	@Override
	public void setLeft(Exp new_left) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRight(Exp new_right) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDatum(String new_datum) {
		// TODO Auto-generated method stub
		datum = new_datum;
	}

	@Override
	public Exp getright() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exp getleft() {
		// TODO Auto-generated method stub
		return null;
	}
}
