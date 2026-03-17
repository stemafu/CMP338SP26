
public class StackDriver {
	
	public static void main(String [] args) {
		LinkedBasedStack<Integer> stack = new LinkedBasedStack<Integer>();
		
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
		stack.push(50);
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		stack.push(50);
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		for(int i = 1; i < 100; i++) {
			stack.push(i);
		}
		
		System.out.println(stack.peek());
		System.out.println(stack.size());		
		
	}

}
