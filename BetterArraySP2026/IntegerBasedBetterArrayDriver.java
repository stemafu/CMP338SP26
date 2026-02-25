
public class IntegerBasedBetterArrayDriver {

	public static void main(String[] args) {
		IntegerBasedBetterArray list = new IntegerBasedBetterArray();
		
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(25);
		list.add(40);
		list.add(39);
		list.add(45);
		list.add(44);
		list.add(32);
		list.add(11);
		list.add(13);
		
		for(int i = 0; i < 10000000; i++) {
			list.add(i);
		}
		
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		list.add(2222, 0);
		System.out.println(list.get(0));

	}

}
