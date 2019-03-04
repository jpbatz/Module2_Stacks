/**
 * 
 */
package Module2_Stacks;

/**
 * @author jph
 * Ref: Based on common implementation of stacks: Lecture Slides Module 2 - Stacks, test book, etc.
 */
public class SymbolStack {

	private char [] symbolsStack;
	private int tos;

	public SymbolStack() {
		this.symbolsStack = new char[50];
		tos = -1;
	}

	public boolean isEmpty() {
		return (this.tos <= -1);
	}
	
	public void push(char item) {
		System.out.println("push(" + item + ")");
		if (this.tos < this.symbolsStack.length - 1) {
			this.symbolsStack[++this.tos] = item;
		} else {
			System.out.println("Stack Full");
		}
	}
		
	public char pop() {
		if (this.tos > -1) {
			char item = this.symbolsStack[this.tos];
			System.out.println("pop => " + item);
			this.symbolsStack[this.tos] = (char) 0;
			this.tos--;
			return item;
		} else {
			System.out.println("Stack is Empty");
			return (char) 0;
		}	
	}	
	
	public void reset() {
		this.fillSymbolStack();
		this.tos = -1;
	}
	
	public int size() {
		int stackSize = this.tos+1;
		System.out.println("Size = " + stackSize);
		return stackSize;
	}
	
	public void displaySymbolStack() {
		for (int i = 0; i<50; i++) {
			System.out.print(this.symbolsStack[i] + " ");
		}
		System.out.println("\n-------------------\n");
	}
	
	public void fillSymbolStack() {
		for (int i=0; i<50; i++) {
			this.symbolsStack[i] = (char) 0;
		}
	}
	
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		
//		SymbolStack testSymbolStack = new SymbolStack();
//		
//		
//		System.out.println("Empty: " + testSymbolStack.isEmpty());
//		
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		System.out.println(testSymbolStack.pop());
//		testSymbolStack.push('0');
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		testSymbolStack.push('9');
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		testSymbolStack.push('8');
//		testSymbolStack.push('7');
//		testSymbolStack.push('6');
//		testSymbolStack.push('5');
//		testSymbolStack.push('4');
//		testSymbolStack.push('3');
//		testSymbolStack.push('2');
//		testSymbolStack.push('1');
//		testSymbolStack.push('0');
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		testSymbolStack.pop();
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		testSymbolStack.pop();
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//
//		testSymbolStack.pop();
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		testSymbolStack.pop();
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		testSymbolStack.pop();
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//
//		testSymbolStack.pop();
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		testSymbolStack.pop();
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		testSymbolStack.pop();
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//
//		testSymbolStack.pop();
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		testSymbolStack.pop();
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		testSymbolStack.pop();
//		testSymbolStack.displaySymbolStack();
//		testSymbolStack.size();
//		
//		System.out.println(testSymbolStack.isEmpty());
//	}

}
