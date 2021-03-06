import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * class: MachineLanguageGenerator
 * @author Joanne Hayashi (EN.605.202.84.SP19) 
 * Ref: Materials provided in EN.605.202.84.SP19 
 *      Code Sample - File Reading/Writing Project0.java
 * 
 * class: MachineLanguageGenerator - converts postfix expressions
 *         provided in a text file into machine language and writes to stdout
 *         and an output file. input: text file containing postfix 1 expression
 *         per line where the legal values are alpha for operands and +, -, *,
 *         /, and $ for operators, and whitespace (spaces and tabs) are ignored
 * process: procession is terminated per expression if an error is
 *         encountered. processing continues with next expression until the end
 *         of file. 
 * output: given expression, machine language equivalent of
 *         specified postfix expressions, error messages for invalid
 *         expressions.
 */
public class MachineLanguageGenerator {

    /**
     * method: MachineLanguageGenerator() constructor
     * @param none
     * @return instance of self
     */
    public MachineLanguageGenerator() {
        // for use of private methods
    }

    public static void main(String[] args) {

        BufferedReader input = null;
        BufferedWriter output = null;

        MachineLanguageGenerator mlgen;
        OperandStack operandStack = new OperandStack();

        String expression = "";       // input expression (line of text)
        int numChars = 0;             // number of characters in expression
        char currChar;                // current character being processed
        String operand1 = "";         // next popped from operand stack
        String operand2 = "";         // first popped from operand stack
        String operator = "";         // holds operator command
        int tempCount = 0;            // tracks TEMP[n] storage
        String tempItem = "TEMP0";    // holds operation result
        String instruction = "";      // holds instruction to display or save
        String errorMsg = "";         // stores error for display and output
        boolean errorFlag = false;    // holds error condition

        mlgen = new MachineLanguageGenerator();

        // Verifies command line arguments
        // Ref: Project0.java
        if (args.length != 2) {
            System.out.println(
                "Usage: java MachineLanguageGenerator" 
              + " [input file pathname" + "]" 
              + " [output file pathname]");
            System.exit(1);
        }

        // Opens the files that will be used for input and output
        // Ref: Project0.java
        try {
            input = new BufferedReader(new FileReader(args[0]));
            output = new BufferedWriter(new FileWriter(args[1]));
        } catch (Exception ioFileOpenError) {
            System.err.println(ioFileOpenError.toString());
            return;
        }

        // input expressions - line of text from input file is an expression
        expression = mlgen.readInput(input);

        System.out.println();
        mlgen.writeOutput("", output);

        // evaluate expressions in input file
        while (expression != null) {

            numChars = expression.length();
            System.out.println("EXPRESSION: " + expression);
            mlgen.writeOutput("EXPRESSION: " + expression, output);

            // evaluate each expression (one line per expression)
            for (int i = 0; i < numChars; i++) {
                currChar = expression.charAt(i);

                // ignore spaces and tabs
                if (mlgen.isWhitespace(currChar)) {
                    continue;
                }

                // if lower case alpha, convert to upper case
                if (mlgen.isLowercaseAlpha(currChar)) {
                    currChar = mlgen.convertToUppercaseAlpha(currChar);
                }

                // if upper case alpha, store into operand stack
                if (mlgen.isUppercaseAlpha(currChar)) {
                    if (!operandStack.isFull()) {
                        operandStack.push(Character.toString(currChar));
                    } else {
                        errorFlag = true;
                        errorMsg = 
                            "\nEvaluation Terminated Due to Insufficient"
                          + " Resources: \n"
                          + "*** Stack is FULL ***";
                        System.out.println(errorMsg);
                        mlgen.writeOutput(errorMsg, output);
                        break;
                    }

                    // generates machine language instruction
                    // if operator is +, =, *, /, or $
                } else if (mlgen.isOperator(currChar)) {

                    operator = mlgen.generateOperatorCmd(currChar);

                    // operand stack requires at least 2 operands
                    if (operandStack.size() >= 2) {
                        operand2 = operandStack.pop();
                        operand1 = operandStack.pop();
                        tempItem = "TEMP" + ++tempCount;
                        operandStack.push(tempItem);

                        // display and save instructions
                        instruction = "    LD " + operand1;
                        System.out.println(instruction);
                        mlgen.writeOutput(instruction, output);

                        instruction = "    " + operator + " " + operand2;
                        System.out.println(instruction);
                        mlgen.writeOutput(instruction, output);

                        instruction = "    ST " + tempItem;
                        System.out.println(instruction);
                        mlgen.writeOutput(instruction, output);

                    } else { // error: insufficient number of operands
                        errorFlag = true;
                        errorMsg = 
                            "\nEvaluation Terminated Due to Error in "
                          + "Expression: \n"
                          + "Insufficient number of operands, or excess "
                          + "operators";
                        System.out.println(errorMsg);
                        mlgen.writeOutput(errorMsg, output);
                        break;
                    }

                // otherwise, error: if not operand or operator, 
                // must be illegal type
                } else {
                    errorFlag = true;
                    errorMsg = 
                        "\nEvaluation Terminated Due to Error in Expression:\n"
                      + "Invalid input character: " + currChar;
                    System.out.println(errorMsg);
                    mlgen.writeOutput(errorMsg, output);
                    break; // skip expression
                }

            } // end for

            // error: leftover operands, insufficient operators
            if ((operandStack.size() > 1) && (errorFlag == false)) {
                errorMsg = 
                    "\nEvaluation Terminated Due to Error in Expression: \n"
                  + "Insufficient operators - leftover operands";
                System.out.println(errorMsg);
                mlgen.writeOutput(errorMsg, output);
            }

            System.out.println("\n=================================\n");
            mlgen.writeOutput("\n=================================\n", output);

            // reset for next expression
            operandStack.reset();
            tempCount = 0;
            errorFlag = false;
            errorMsg = "";

            // next expression
            expression = mlgen.readInput(input);

        } // end while

        // closes io streams and returns to the operating system
        // Ref: Project 0.java
        try {
            input.close();
            output.close();
        } catch (Exception ioFileCloseError) {
            System.err.println(ioFileCloseError.toString());
        }

    } // end main()

    /**
     * method: readInput() reads the next line from the input file
     * @param input - A buffered stream from a file that contains postfix
     *                expressions
     * @return the next postfix expression from the input file 
     * Ref: Project0.java
     */
    private String readInput(BufferedReader input) {
        String text = "";
        try {
            text = input.readLine();
        } catch (IOException ioReadError) {
            System.err.println(ioReadError.toString());
            System.exit(3);
        }
        return text;
    }

    /**
     * method: writeOutput() - writes expression to output file
     * @param text - The text to write
     * @param output - The output stream to write the text to
     * @return nothing ref: Project0.java
     */
    private void writeOutput(String text, BufferedWriter output) {
        try {
            output.write(text, 0, text.length());
            output.newLine();
        } catch (IOException ioWriteError) {
            System.err.println(ioWriteError.toString());
            System.exit(4);
        }
        return;
    }

    /**
     * method: isWhitespace() - tests for spaces and tabs
     * @param asciiChar - The character to test
     * @return true if c is space or tab character, false otherwise
     */
    private boolean isWhitespace(char asciiChar) {
        if ((asciiChar == 32) || (asciiChar == 9)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * method: isLowercaseAlpha() - tests for a-z
     * @param asciiChar - The character to test
     * @return true if c is alpha, false otherwise
     */
    private boolean isLowercaseAlpha(char asciiChar) {
        // test for lower case (a-z)
        if ((asciiChar >= 97) && (asciiChar <= 122)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * method: isUppercaseAlpha() - tests for A-Z
     * @param asciiChar - The character to test
     * @return true if c is alpha, false otherwise
     */
    private boolean isUppercaseAlpha(char asciiChar) {
        // test for upper case alpha character (A-Z)
        if ((asciiChar >= 65) && (asciiChar <= 90)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * method: convertToUppercaseAlpha() - converts lower case 
     *         alpha a-z to upper case alpha A-Z
     * @param asciiChar - The character to convert
     * @return upper case character asciiChar
     */
    private char convertToUppercaseAlpha(char asciiChar) {
        if (this.isLowercaseAlpha(asciiChar)) {
            asciiChar = Character.toUpperCase(asciiChar);
        }
        return asciiChar;
    }

    /**
     * method: isOperator() - verifies character is an operator
     * @param asciiChar - the character to check
     * @return true if the character is +, - ,* ,/ , or $
     */
    private boolean isOperator(char asciiChar) {
        int asciiInt;
        asciiInt = (int) asciiChar;
        if ((asciiInt == (int) '+') || 
            (asciiInt == (int) '-') || 
            (asciiInt == (int) '*') || 
            (asciiInt == (int) '/') || 
            (asciiInt == (int) '$')) 
        {
            return true;
        } else {
            return false;
        }
    } // end isOperator()

    /**
     * method: generateOperatorCmd() - converts operator symbol to machine
     *         language command
     * @param asciiChar - the symbol to convert + => AD, - => SB, 
     *                                          * => ML, / => DV,
     *                                      and $ => EX
     * @return machine language command
     */
    private String generateOperatorCmd(char asciiChar) {
        String command = "";
        int asciiInt = (int) asciiChar;
        switch (asciiInt) {
        case 43: {
            command = "AD";
            break;
        }
        case 45: {
            command = "SB";
            break;
        }
        case 42: {
            command = "ML";
            break;
        }
        case 47: {
            command = "DV";
            break;
        }
        case 36: {
            command = "EX";
            break;
        }
        default: {
            break;
        }
        } // end switch
        return command;
    } // end generateOperatorCmd()

} // end class
