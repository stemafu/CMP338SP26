
public class hashTableDriver {
	
	public static void main(String [] args) {
		Person<Integer> p1 = new Person<Integer>("Drink", "Water", 5);
		
		
		HashTable<Person<Integer>, Integer> hashTable;
		
		
		hashTable = new HashTable<Person<Integer>, Integer>();
		
		
		
		hashTable.insert(p1);
		
		
	}

}
