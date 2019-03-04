/**
 * 
 */
//package Module2_Stacks;

/**
 * @author jph
 * Ref: Based on common implementation of stacks: Lecture Slides Module 2 - Stacks, test book, etc.
 */
public class OperandStack {

	private String [] operandStack;
	private int tos;

	public OperandStack() {
		this.operandStack = new String[50];
		tos = -1;
	}

	public boolean isEmpty() {
		return (this.tos <= -1);
	}
	
	public void push(String item) {
		System.out.println("push(" + item + ")");
		if (this.tos < this.operandStack.length - 1) {
			this.operandStack[++this.tos] = item;
		} else {
			System.out.println("Stack Full");
		}
	}
		
	public String pop() {
		if (this.tos > -1) {
			String item = this.operandStack[this.tos];
			System.out.println("pop => " + item);
			this.operandStack[this.tos] = null;
			this.tos--;
			return item;
		} else {
			System.out.println("Stack is Empty");
			return null;
		}
	}	
	
	public void reset() {
		this.fillOperandStack();
		this.tos = -1;
	}
	
	public int size() {
		int stackSize = this.tos+1;
		System.out.println("Size = " + stackSize);
		return stackSize;
	}
	
	public void displayOperandStack() {
		for (int i = 0; i<50; i++) {
			System.out.print(this.operandStack[i] + " ");
		}
		System.out.println("\n-------------------\n");
	}
	
	public void fillOperandStack() {
			for (int i=0; i<50; i++) {
				this.operandStack[i] = null;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	OperandStack testOperandStack = new OperandStack();
	
	
	System.out.println("Empty: " + testOperandStack.isEmpty());
	
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	System.out.println(testOperandStack.pop());
	testOperandStack.push("ten");
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	testOperandStack.push("nine");
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	testOperandStack.push("eight");
	testOperandStack.push("seven");
	testOperandStack.push("six");
	testOperandStack.push("five");
	testOperandStack.push("four");
	testOperandStack.push("three");
	testOperandStack.push("two");
	testOperandStack.push("one");
	testOperandStack.push("zero");
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	testOperandStack.pop();
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	testOperandStack.pop();
	testOperandStack.displayOperandStack();
	testOperandStack.size();

	testOperandStack.pop();
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	testOperandStack.pop();
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	testOperandStack.pop();
	testOperandStack.displayOperandStack();
	testOperandStack.size();

	testOperandStack.pop();
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	testOperandStack.pop();
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	testOperandStack.pop();
	testOperandStack.displayOperandStack();
	testOperandStack.size();

	testOperandStack.pop();
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	testOperandStack.pop();
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	testOperandStack.pop();
	testOperandStack.displayOperandStack();
	testOperandStack.size();
	
	System.out.println(testOperandStack.isEmpty());
}

}
