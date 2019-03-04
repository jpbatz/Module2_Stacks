/**
 * 
 */
package Module2_Stacks;

/**
 * @author jph
 *
 */
public class OperatorStack {

	private char [] operatorStack;
	private int tos;

	public OperatorStack() {
		this.operatorStack = new char[10];
		tos = -1;
	}

	public boolean isEmpty() {
		return (this.tos <= -1);
	}
	
	public void push(char item) {
		System.out.println("push(" + item + ")");
		if (this.tos < this.operatorStack.length - 1) {
			this.operatorStack[++this.tos] = item;
		} else {
			System.out.println("Stack Full");
		}
	}
		
	public char pop() {
		if (this.tos > -1) {
			char item = this.operatorStack[this.tos];
			System.out.println("pop => " + item);
			this.operatorStack[this.tos] = 'x';
			this.tos--;
			return item;
		} else {
			System.out.println("Stack is Empty");
			return 'x';
		}	
	}	
	
	public int size() {
		int stackSize = this.tos+1;
		System.out.println("Size = " + stackSize);
		return stackSize;
	}
	
	public void displayOperatorStack() {
		for (int i = 0; i<10; i++) {
			System.out.print(this.operatorStack[i] + " ");
		}
		System.out.println();
	}
	
	public void fillOperatorStack() {
		for (int i=0; i<10; i++) {
			this.operatorStack[i] = 'o';
		}
	}
	
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		
//		OperatorStack testOperatorStack = new OperatorStack();
//		
//		
//		System.out.println("Empty: " + testOperatorStack.isEmpty());
//		
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		System.out.println(testOperatorStack.pop());
//		testOperatorStack.push('!');
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		testOperatorStack.push('@');
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		testOperatorStack.push('#');
//		testOperatorStack.push('$');
//		testOperatorStack.push('%');
//		testOperatorStack.push('^');
//		testOperatorStack.push('&');
//		testOperatorStack.push('*');
//		testOperatorStack.push('(');
//		testOperatorStack.push(')');
//		testOperatorStack.push('_');
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		testOperatorStack.pop();
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		testOperatorStack.pop();
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//
//		testOperatorStack.pop();
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		testOperatorStack.pop();
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		testOperatorStack.pop();
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//
//		testOperatorStack.pop();
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		testOperatorStack.pop();
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		testOperatorStack.pop();
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//
//		testOperatorStack.pop();
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		testOperatorStack.pop();
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		testOperatorStack.pop();
//		testOperatorStack.displayOperatorStack();
//		testOperatorStack.size();
//		
//		System.out.println(testOperatorStack.isEmpty());
//	}

}
