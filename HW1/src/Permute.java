
/**
 * 
 * @author Patchara Pattiyathanee 5710546348 
 * Sep 8, 2015
 */
import java.util.ArrayList;
import java.util.Collections;

public class Permute {
	public static ArrayList<String> permuteK(String s , int n) {
		ArrayList<String> as = new ArrayList<String>();
		
		return as;
	}

	public static void main(String[] args) {
		ArrayList<String> as = permuteK("abcd" , 2);

		Collections.sort(as);
		for (int i = 0; i < as.size(); i++)
			System.out.println(as.get(i));
		System.out.println("Permutation size is " + as.size());
		/*
		 * for (String s: as) System.out.println(s);
		 */
	}
}
