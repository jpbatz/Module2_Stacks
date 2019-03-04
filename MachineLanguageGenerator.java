//package Module2_Stacks;

//import java.io.*;				// for character upper case conversion
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MachineLanguageGenerator {

	public static boolean isOperator(int asciiInt) {
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
	} // isOperator()
	
	public static String generateOperatorCmd(int asciiInt) {
		
		String command = "XX";
		char operator = (char) asciiInt;
		
//		System.out.println("generateOperatorCmd(asciiInt): " + operator);
		
		switch (asciiInt) {
			case 43 : {
				command = "AD";
				break;
			}
			case 45 : {
				command = "SB";
				break;
			}
			case 42 : {
				command = "ML";
				break;
			}
			case 47 : {
				command = "DV";
				break;
			}
			case 36 : {
				command = "EX";
				break;
			}
			default :
			{
				break;
			}
		
		} // switch
		
//		System.out.println("generateOperatorCmd(): command is " + command);
		return command;
		
	} // generateOperatorCmd()
	
	
	// Code Sample - File Reading 
	// Provided by EN.605.202.84.SP19
	// Processes one character at a time from a named input file
	public static void main(String[] args) {

		FileReader inputStream = null;
		FileWriter outputStream = null;
		OperandStack operandStack = new OperandStack();
		
		int tempCount = 0;			// tracks TEMP[n] storage
		String operand1 = "";		// next popped from operand stack
		String operand2 = "";		// first popped from operand stack
		String register = "";		// holds register reference
		String cmd = "";				// holds machine language command
		String instruction = "";		// holds "cmd register" instruction format
		String operator = "";		// holds operator command
		String inputLine = "";  		// stores an input line of symbols for display
		String [] instrArr = new String[100]; // stores instructions for display
		int index = 0;				// holds index for instructions array
		int i = 0;					// holds index for displaying instructions array
		
		try {
			
			inputStream = new FileReader(args[0]);	// input file
			outputStream = new FileWriter(args[1]);	// output file
			
			int c;
			
			// read and process one char at a time from input file
			while ((c = inputStream.read()) != -1) {
				
				// non-newline character input
				if ((c != 10)) {
					
					System.out.println("  char is " + (char) c);
//					outputStream.write(c);
					inputLine += Character.toString((char) c);
							
					// if input is an operand, push it to the operand stack
					
					// need to convert a to z to upper case
					if ((c >= 97) && (c <= 122)) {
						c = Character.toUpperCase(c);
					}
					
					// accepts upper case A to Z
					if ((c >= 65) && (c <= 90)) {
						operandStack.push(Character.toString((char) c));
					}
					
					// if operator: +, =, *, /, $
					else if(isOperator(c)) {
						
						operator = generateOperatorCmd(c);
						
						System.out.println("    OPERATOR: " + operator);
						
						// generates machine language instruction
						 
						 // operand stack has at least 2 operands
						if (operandStack.size() >= 2) {
							cmd = operator;
							operand2 = operandStack.pop();
							operand1 = operandStack.pop();
						 }
						 						 
						 else { 
							System.out.println("Empty operand stack or insufficient operands");
						 }
						 
						 // Load Register
						 cmd = "LD";
						 instruction = cmd + " " + operand1;
						 instrArr[index] = instruction;
						 index++;
						 System.out.println("                      " + instruction);	
//						 outputStream.write("                      " + instruction + "\n");
						
						// Operation
						cmd = operator;
						instruction = cmd + " " + operand2;
						instrArr[index] = instruction;
						index++;
						System.out.println("                      " + instruction);
//						outputStream.write("                      " + instruction + "\n");
						 
						// Store Result
						cmd = "ST";
						tempCount++;
						register = "TEMP" + tempCount;
						operandStack.push(register);
						instruction = cmd + " " + register;
						instrArr[index] = instruction;
						index++;
						System.out.println("                      " + instruction);
//						outputStream.write("                      " + instruction + "\n");
						 
					 }

					
					// otherwise, report invalid input
					 else {
						 System.out.println("    Invalid input character: " + (char) c + "\n Skipping...\n");
						 outputStream.write(" Invalid input character: " + (char) c + "\n Skipping...\n\n");
//						 break; // skip expression, stop processing
						 continue; // skip expression, next expression
					 }

				} else { // process newline
					System.out.println("  char is a EOL");
					operandStack.reset();
					tempCount = 0;
					instrArr[index] = "\n";
					index = 0;
					outputStream.write(inputLine + "\n");
					
					i = 0;
					inputLine = "";
					while(!instrArr[i].equals("\n")) {
						if (instrArr[i] != null) {
							outputStream.write(instrArr[i] + "\n");
						}
						i++;
					}  // while
					outputStream.write("\n\n");
				}

			} // while
			
			outputStream.write(inputLine + "\n\n");
			
			i=0;
			while(!instrArr[i].equals("\n")) {
				if (instrArr[i] != null) {
					outputStream.write(instrArr[i] + "\n");
				}
				i++;
			}  // while
			
			outputStream.write("\n\n");
			
			if (inputStream != null) inputStream.close();
			if (outputStream != null) outputStream.close();

		} catch (IOException e) {
			//
		} // try/catch
		
		// if no operators, but still operands, insufficient operators error
		
	} // main()
	
} // class
				
