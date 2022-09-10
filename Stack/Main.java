package Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack stack = new Stack();
		
		stack.push(10);
		stack.push(20);
		System.out.println(stack.peek());
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		System.out.println(stack);
		stack.pop();
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
	}

}
