/**
 * 
 */
package Module2_Stacks;

/**
 * @author jph
 *
 */
public class StringStack {

	private String [] stringStack;
	private int tos;
	/**
	 * 
	 */
	public StringStack() {
		this.stringStack = new String[10];
		tos = -1;
	}

	public boolean isEmpty() {
		return (this.tos <= -1);
	}
	
	public void push(String item) {
		System.out.println("push(" + item + ")");
		if (this.tos < this.stringStack.length - 1) {
			this.stringStack[++this.tos] = item;
		} else {
			System.out.println("Stack Full");
		}
	}
		
	public String pop() {
		if (this.tos > -1) {
			String item = this.stringStack[this.tos];
			System.out.println("pop => " + item);
			this.stringStack[this.tos] = null;
			this.tos--;
			return item;
		} else {
			System.out.println("Stack is Empty");
			return null;
		}	
	}	
	
	public int size() {
		int stackSize = this.tos+1;
		System.out.println("Size = " + stackSize);
		return stackSize;
	}
	
	public void displayStringStack() {
		for (int i = 0; i<10; i++) {
			System.out.print(this.stringStack[i] + " ");
		}
		System.out.println();
	}
	
	public void fillStringStack() {
		for (int i=0; i<10; i++) {
			this.stringStack[i] = "oye";
		}
	}
	
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		
//		StringStack testStringStack = new StringStack();
//		
//		
//		System.out.println("Empty: " + testStringStack.isEmpty());
//		
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		System.out.println(testStringStack.pop());
//		testStringStack.push("ten");
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		testStringStack.push("nine");
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		testStringStack.push("eight");
//		testStringStack.push("seven");
//		testStringStack.push("six");
//		testStringStack.push("five");
//		testStringStack.push("four");
//		testStringStack.push("three");
//		testStringStack.push("two");
//		testStringStack.push("one");
//		testStringStack.push("zero");
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		testStringStack.pop();
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		testStringStack.pop();
//		testStringStack.displayStringStack();
//		testStringStack.size();
//
//		testStringStack.pop();
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		testStringStack.pop();
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		testStringStack.pop();
//		testStringStack.displayStringStack();
//		testStringStack.size();
//
//		testStringStack.pop();
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		testStringStack.pop();
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		testStringStack.pop();
//		testStringStack.displayStringStack();
//		testStringStack.size();
//
//		testStringStack.pop();
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		testStringStack.pop();
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		testStringStack.pop();
//		testStringStack.displayStringStack();
//		testStringStack.size();
//		
//		System.out.println(testStringStack.isEmpty());
//	}


}
