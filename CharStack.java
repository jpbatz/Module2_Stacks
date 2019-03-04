/**
 * 
 */
package Module2_Stacks;

/**
 * @author jph
 *
 */
public class CharStack {

	private char [] charStack;
	private int tos;

	public CharStack() {
		this.charStack = new char[10];
		tos = -1;
	}

	public boolean isEmpty() {
		return (this.tos <= -1);
	}
	
	public void push(char item) {
		System.out.println("push(" + item + ")");
		if (this.tos < this.charStack.length - 1) {
			this.charStack[++this.tos] = item;
		} else {
			System.out.println("Stack Full");
		}
	}
		
	public char pop() {
		if (this.tos > -1) {
			char item = this.charStack[this.tos];
			System.out.println("pop => " + item);
			this.charStack[this.tos] = 'x';
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
	
	public void displayCharStack() {
		for (int i = 0; i<10; i++) {
			System.out.print(this.charStack[i] + " ");
		}
		System.out.println();
	}
	
	public void fillCharStack() {
		for (int i=0; i<10; i++) {
			this.charStack[i] = 'o';
		}
	}
	
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		
//		CharStack testCharStack = new CharStack();
//		
//		
//		System.out.println("Empty: " + testCharStack.isEmpty());
//		
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		System.out.println(testCharStack.pop());
//		testCharStack.push('0');
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		testCharStack.push('9');
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		testCharStack.push('8');
//		testCharStack.push('7');
//		testCharStack.push('6');
//		testCharStack.push('5');
//		testCharStack.push('4');
//		testCharStack.push('3');
//		testCharStack.push('2');
//		testCharStack.push('1');
//		testCharStack.push('0');
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		testCharStack.pop();
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		testCharStack.pop();
//		testCharStack.displayCharStack();
//		testCharStack.size();
//
//		testCharStack.pop();
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		testCharStack.pop();
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		testCharStack.pop();
//		testCharStack.displayCharStack();
//		testCharStack.size();
//
//		testCharStack.pop();
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		testCharStack.pop();
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		testCharStack.pop();
//		testCharStack.displayCharStack();
//		testCharStack.size();
//
//		testCharStack.pop();
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		testCharStack.pop();
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		testCharStack.pop();
//		testCharStack.displayCharStack();
//		testCharStack.size();
//		
//		System.out.println(testCharStack.isEmpty());
//	}

}
