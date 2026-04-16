import java.util.Arraylist;
import java.util.HashSet;

public class Removeduplicate {
	public static void main(String[]args) {
	 Arrarylist<Integer>list = new Arrarylist<>();
	 list.add(10);
	 list.add(20);
	 list.add(30);
	 list.add(10);
	 list.add(20);
	 
	 System.out.println("Arrarylist"  +list);
	 HashSet<Integer> Set  = new HashSet<>(list);
	 Arrarylist<Integer> uniqueList = Arrarylist<>(set);
      System.out.println("List after removing duplicates: " + uniqueList);	 
	  }
	}
	 
	 