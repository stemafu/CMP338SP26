
public class Driver {
	
	public static void main(String [] args) {
		
		Integer [] nums = new Integer[5];
		
		LinkedList hashtables [] = new LinkedList[5];
		
	
		
		for (int i = 0; i < hashtables.length; i++) {
			hashtables[i] = new LinkedList();
		}
		
		hashtables[1].add(9);
		
		for (int i = 0; i < hashtables.length; i++) {
			System.out.println(hashtables[i].size());
		}
	}

}
