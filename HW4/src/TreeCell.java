/**
 * 
 * @author Patchara Pattiyathanee 5710546348
 * 7 Oct 2015
 * 
 */
public class TreeCell<T extends Comparable<T>> {
	private T datum;
	private TreeCell<T> left, right;

	public TreeCell(T x) {
		datum = x;
	}

	public TreeCell(T x, TreeCell<T> lft, TreeCell<T> rgt) {
		datum = x;
		left = lft;
		right = rgt;
	}

	public T getDatum() {
		return datum;
	}

	public void setDatum(T new_datum) {
		datum = new_datum;
	}

	public TreeCell<T> getLeft() {
		return left;
	}

	public void setLeft(TreeCell<T> new_left) {
		left = new_left;
	}

	public TreeCell<T> getRight() {
		return right;
	}

	public void setRight(TreeCell<T> new_right) {
		right = new_right;
	}

	public static void printTree(TreeCell tc) {
		if (tc == null) {
			return;
		}
		System.out.print(tc.getDatum() + " ");
		printTree(tc.getLeft());
		printTree(tc.getRight());

	}

	// returns a reference to the root of binary search tree T with node x (the
	// datum) removed
	public static TreeCell delete(Object x, TreeCell T) {
		if (x == null) {
			return null;
		}
		if(T == null){
			return null;
		}
		if(T.getDatum().compareTo(x) == 0){
			if(T.getLeft() == null && T.getRight() == null){
				return null;
			}
			if(T.getLeft() == null && T.getRight() != null){
				return T.getRight();
			}
			if(T.getLeft() != null && T.getRight() == null){
				return T.getLeft();
			}
			//remove operation
			TreeCell temp = findMax(T.getLeft());
			TreeCell left_cell = removeNode(T.getLeft());
			T.setDatum(temp.getDatum());
			T.setLeft(left_cell);
			return T;
		}
		if (T.getDatum().compareTo(x) > 0) {
			T.setLeft(delete(x, T.getLeft()));
		}
		if (T.getDatum().compareTo(x) < 0) {
			T.setRight(delete(x, T.getRight()));
		}
		return T;
		
	}
	
	public static TreeCell findMax(TreeCell tc){
		if(tc.getRight() == null){
			return tc;
		}
		return findMax(tc.getRight());
	}
	
	public static TreeCell removeNode(TreeCell tc){
		if(tc.getRight() == null){
			tc = null;
			return tc;
		}
		tc.setRight(removeNode(tc.getRight()));
		return tc;
	}


}