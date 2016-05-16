
public class Main {
	public static void main(String[] args) {
		TreeCell<Integer> tc = new TreeCell<Integer>(5, null, null);
		TreeCell<Integer> l = new TreeCell<Integer>(2, null, null);
		TreeCell<Integer> r = new TreeCell<Integer>(12, null, null);
		TreeCell<Integer> ll = new TreeCell<Integer>(-4, null, null);
		TreeCell<Integer> lr = new TreeCell<Integer>(3, null, null);
		TreeCell<Integer> rl = new TreeCell<Integer>(9, null, null);
		TreeCell<Integer> rr = new TreeCell<Integer>(21, null, null);
		TreeCell<Integer> rrl = new TreeCell<Integer>(19, null, null);
		TreeCell<Integer> rrr = new TreeCell<Integer>(25, null, null);

		tc.setLeft(l);
		tc.setRight(r);
		l.setLeft(ll);
		l.setRight(lr);
		r.setLeft(rl);
		r.setRight(rr);
		rr.setLeft(rrl);
		rr.setRight(rrr);

		tc.printTree(tc);
		System.out.println("\n--------------------------------");
		tc.printTree(tc.delete(5, tc));
		

	}
}
