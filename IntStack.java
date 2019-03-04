/**
 * 
 */
package Module2_Stacks;

/**
 * @author jph
 *
 */
public class IntStack {

	private int [] intStack;
	private int tos;
	
	/**
	 * 
	 */
	public IntStack() {
		this.intStack = new int[10];
		this.tos = -1;
	}

	public boolean isEmpty() {
		return (this.tos <= -1);
	}
	
	public void push(int item) {
		System.out.println("push(" + item + ")");
		if (this.tos < this.intStack.length - 1) {
			this.intStack[++this.tos] = item;
		} else {
			System.out.println("Stack Full");
		}
	}
	
	public int pop() {
		if (this.tos > -1) {
			int item = this.intStack[this.tos];
			System.out.println("pop => " + item);
			this.intStack[this.tos] = 0;
			this.tos--;
			return item;
		} else {
			System.out.println("Stack is Empty");
			return -1;
		}
		
	}
	
	public int size() {
		int stackSize = this.tos+1;
		System.out.println("Size = " + stackSize);
		return stackSize;
	}
	
	public void displayIntStack() {
		for (int i = 0; i<10; i++) {
			System.out.print(this.intStack[i] + " ");
		}
		System.out.println();
	}
	
	public void fillIntStack() {
		for (int i=0; i<10; i++) {
			this.intStack[i] = 0;
		}
	}
	
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		
//		IntStack testIntStack = new IntStack();
//		
//		System.out.println("Empty: " + testIntStack.isEmpty());
//		
//		testIntStack.displayIntStack();
//		testIntStack.size();
//		
//		System.out.println(testIntStack.pop());
//		testIntStack.push(10);
//		testIntStack.displayIntStack();
//		testIntStack.size();
//		
//		testIntStack.push(9);
//		testIntStack.displayIntStack();
//		testIntStack.size();
//		
//		testIntStack.push(8);
//		testIntStack.push(7);
//		testIntStack.push(6);
//		testIntStack.push(5);
//		testIntStack.push(4);
//		testIntStack.push(3);
//		testIntStack.push(2);
//		testIntStack.push(1);
//		testIntStack.push(0);
//		testIntStack.displayIntStack();
//		testIntStack.size();
//		
//		testIntStack.pop();
//		testIntStack.displayIntStack();
//		testIntStack.size();
//		
//		testIntStack.pop();
//		testIntStack.displayIntStack();
//		testIntStack.size();
//
//		// pop empty stack
//		testIntStack.pop();
//		testIntStack.displayIntStack();
//		testIntStack.size();
//		
//		System.out.println(testIntStack.isEmpty());
//	}

}
