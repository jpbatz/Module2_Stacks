/**
 * class: OperandStack
 * @author Joanne Hayashi (EN.605.202.84.SP19) 
 * Ref: Project0.java, and based on common implementation of stacks: 
 *      Lecture Slides Module 2 - Stacks, test book, etc.
 */
public class OperandStack {

    private String[] operandStack;
    private int tos;
    private int maxSize = 256;  // set > expected consecutive operands
                                // to prevent stack overflow

    /**
     * method: OperandStack() constructor
     * @param none
     * @return nothing
     */
    public OperandStack() {
        this.operandStack = new String[maxSize];
        tos = -1;
    }

    /**
     * method: isEmpty() - checks if stack is empty
     * @param none
     * @return true if empty, false if item(s) exist(s)
     */
    public boolean isEmpty() {
        if (this.tos <= -1) {
//            System.out.println("*** Insufficient Data: Stack is EMPTY! ***");
            return true;
        } else {
            return false;
        }
    }

    /**
     * method: isFull() - checks for stack full
     * @param none
     * @return true if full, false if not full
     */
    public boolean isFull() {
        if (this.tos >= maxSize - 1) {
//          System.out.println("** Insufficient Resources: Stack is FULL! **");
            return true;
        } else {
            return false;
        }
    }

    /**
     * method: push() - adds item to top of stack
     * @param item - element to add to top of stack
     * @return nothing
     */
    public void push(String item) {
        // System.out.println("push(" + item + ")");
        if (!isFull()) {
            this.operandStack[++this.tos] = item;
        } else {
//          System.out.println("** Insufficient Resources: Stack is FULL! **");
            return;
        }
    }

    /**
     * method: pop() - removes item from top of stack
     * @param none
     * @return item removed from the stack
     */
    public String pop() {
        if (!isEmpty()) {
            String item = this.operandStack[this.tos];
            // System.out.println("pop => " + item);
            this.operandStack[this.tos] = null;
            this.tos--;
            return item;
        } else {
//          System.out.println("** Insufficient Resources: Stack is EMPTY! **");
            return null;
        }
    }

    /**
     * method: reset() - clears items from stack
     * @param none
     * @return nothing
     */
    public void reset() {
        this.fillOperandStack();
        this.tos = -1;
    }

    /**
     * method: size() - determines stack size
     * @param none
     * @return number of items on stack
     */
    public int size() {
        int stackSize = this.tos + 1;
        // System.out.println("Size = " + stackSize);
        return stackSize;
    }

    /**
     * method: displayOperandStack() - displays items on stack
     * @param none
     * @return nothing
     */
    public void displayOperandStack() {
        for (int i = 0; i < maxSize; i++) {
            System.out.print(this.operandStack[i] + " ");
        }
        System.out.println("\n-------------------\n");
    }

    /**
     * method: fillOperandStack() - clear items from stack
     * @param none
     * @return nothing
     */
    public void fillOperandStack() {
        for (int i = 0; i < maxSize; i++) {
            this.operandStack[i] = null;
        }
    }

}
