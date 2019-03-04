/**
 * 
 */
package Module2_Stacks;

/**
 * @author jph
 * Ref: Based on common implementation of stacks: Lecture Slides Module 2 - Stacks, test book, etc.
 */
public class OperandStackOrig {

	private char [] operandStack;
	private int tos;

	public OperandStackOrig() {
		this.operandStack = new char[50];
		tos = -1;
	}

	public boolean isEmpty() {
		return (this.tos <= -1);
	}
	
	public void push(char item) {
		System.out.println("push(" + item + ")");
		if (this.tos < this.operandStack.length - 1) {
			this.operandStack[++this.tos] = item;
		} else {
			System.out.println("Stack Full");
		}
	}
		
	public char pop() {
		if (this.tos > -1) {
			char item = this.operandStack[this.tos];
			System.out.println("pop => " + item);
			this.operandStack[this.tos] = (char) 0;
			this.tos--;
			return item;
		} else {
			System.out.println("Stack is Empty");
			return (char) 0;
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
				this.operandStack[i] = (char) 0;
		}
	}
	
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		
//		OperandStack testOperandStack = new OperandStack();
//		
//		
//		System.out.println("Empty: " + testOperandStack.isEmpty());
//		
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		System.out.println(testOperandStack.pop());
//		testOperandStack.push('A');
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		testOperandStack.push('B');
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		testOperandStack.push('C');
//		testOperandStack.push('D');
//		testOperandStack.push('E');
//		testOperandStack.push('F');
//		testOperandStack.push('G');
//		testOperandStack.push('H');
//		testOperandStack.push('I');
//		testOperandStack.push('J');
//		testOperandStack.push('K');
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		testOperandStack.pop();
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		testOperandStack.pop();
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//
//		testOperandStack.pop();
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		testOperandStack.pop();
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		testOperandStack.pop();
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//
//		testOperandStack.pop();
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		testOperandStack.pop();
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		testOperandStack.pop();
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//
//		testOperandStack.pop();
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		testOperandStack.pop();
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		testOperandStack.pop();
//		testOperandStack.displayOperandStack();
//		testOperandStack.size();
//		
//		System.out.println(testOperandStack.isEmpty());
//	}

}
