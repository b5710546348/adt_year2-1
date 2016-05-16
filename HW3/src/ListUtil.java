import java.util.Collections;
import java.util.List;

public class ListUtil {
	
	/*
	Given a list and an int, return the number of times that int occurs in the list.
	*/
	public static int Count(ListCell head, int searchFor){
		int count = 0;
		ListCell<Integer> temp_cell = new ListCell<Integer>(new Integer(searchFor),null);
		while(head != null){
			if(head.getDatum().equals(temp_cell.getDatum())){
				count++;
			}
			head = head.getNext();
		}
		return count;
	}
	
	/*
	Given a list, an index 'n' in the range 0..length, and a data element, add a new node to the list so that it has the given index.
	*/
	public static ListCell InsertNth(ListCell headRef, int index, int data){
		int count_index = 0;
		ListCell<Integer> temp = headRef;
		while(temp != null){
			if(count_index == index){
				temp.setDatum(new Integer(data));
			}
			temp = temp.getNext();
			count_index++;
		}
		
		return temp;
	}
	
	public static ListCell SortedInsert(ListCell headRef, ListCell newNode){
		Collections.sort((List<Integer>) headRef);
		return null;
	}
	
	// Given a list, change it to be in sorted order (using SortedInsert()). 
	public static ListCell InsertSort(ListCell headRef){
		
		return null;
	}
	
	public static ListCell RemoveDuplicates(ListCell head){
		return null;
	}
	
	//main 
	public static void main(String[] args) {
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		System.out.println("Test Counting ListCell");
		ListCell<Integer> cell = new ListCell<Integer>(one , new ListCell<Integer>(one , new ListCell<Integer>(one,null)));
		System.out.println("Number  1"  +  " : " + Count(cell,1));
	}
	
}
