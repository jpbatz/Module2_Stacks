File: README.txt

Name:       Joanne Hayashi
Course:     EN.605.202.84.SP19	
Assignment: Lab 1

Followed format of Project0.java


Java Version:

java version "1.8.0_172"
Java(TM) SE Runtime Environment (build 1.8.0_172-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.172-b11, mixed mode)

(base) jMBP:Project Files jph$ date
Tue Mar  5 22:01:09 HST 2019

(base) jMBP:Project Files jph$ ls -ltr *.java
-rw-r--r--  1 jph  staff  2527 Mar  5 21:23 OperandStack.java
-rw-r--r--  1 jph  staff  9673 Mar  5 21:58 MachineLanguageGenerator.java

(base) jMBP:Project Files jph$ rm *.class
(base) jMBP:Project Files jph$ ls -ltr *.class
ls: *.class: No such file or directory

Compile:
(base) jMBP:Project Files jph$ javac MachineLanguageGenerator.java 
(base) jMBP:Project Files jph$ ls -ltr *.class
-rw-r--r--  1 jph  staff  4272 Mar  5 22:01 MachineLanguageGenerator.class
-rw-r--r--  1 jph  staff  1478 Mar  5 22:01 OperandStack.class


Usage:

java MachineLanguageGenerator <input file> <output file>


Test Files (command line outputs):

0) no command line arguments => Usage: error

(base) jMBP:Project Files jph$ java MachineLanguageGenerator
Usage: java MachineLanguageGenerator [input filespec] [output filespec]


1) one command line argument => Usage: error

(base) jMBP:Project Files jph$ java MachineLanguageGenerator input.txt
Usage: java MachineLanguageGenerator [input filespec] [output filespec]


2) Blank file => blank output file

(base) jMBP:Project Files jph$ java MachineLanguageGenerator TestBlankInput.txt TestBlankOutput.txt


3) Simple example in Lab 1 Instructions

(base) jMBP:Project Files jph$ java MachineLanguageGenerator TestExampleInput.txt TestExampleOutput.txt

EXPRESSION: ABC*+DE-/
    LD B
    ML C
    ST TEMP1
    LD A
    AD TEMP1
    ST TEMP2
    LD D
    SB E
    ST TEMP3
    LD TEMP2
    DV TEMP3
    ST TEMP4

=================================


4) Given Baseline

(base) jMBP:Project Files jph$ java MachineLanguageGenerator PostfixMachineLangInput.txt PostfixMachineLangOutput.txt

EXPRESSION: AB+C-
    LD A
    AD B
    ST TEMP1
    LD TEMP1
    SB C
    ST TEMP2

=================================

EXPRESSION: ABC+-
    LD B
    AD C
    ST TEMP1
    LD A
    SB TEMP1
    ST TEMP2

=================================

EXPRESSION: AB-C+DEF-+$
    LD A
    SB B
    ST TEMP1
    LD TEMP1
    AD C
    ST TEMP2
    LD E
    SB F
    ST TEMP3
    LD D
    AD TEMP3
    ST TEMP4
    LD TEMP2
    EX TEMP4
    ST TEMP5

=================================

EXPRESSION: ABCDE-+$*EF*-
    LD D
    SB E
    ST TEMP1
    LD C
    AD TEMP1
    ST TEMP2
    LD B
    EX TEMP2
    ST TEMP3
    LD A
    ML TEMP3
    ST TEMP4
    LD E
    ML F
    ST TEMP5
    LD TEMP4
    SB TEMP5
    ST TEMP6

=================================

EXPRESSION: ABC+*CBA-+*
    LD B
    AD C
    ST TEMP1
    LD A
    ML TEMP1
    ST TEMP2
    LD B
    SB A
    ST TEMP3
    LD C
    AD TEMP3
    ST TEMP4
    LD TEMP2
    ML TEMP4
    ST TEMP5

=================================

EXPRESSION: ABC+/CBA*+
    LD B
    AD C
    ST TEMP1
    LD A
    DV TEMP1
    ST TEMP2
    LD B
    ML A
    ST TEMP3
    LD C
    AD TEMP3
    ST TEMP4

Evaluation Terminated Due to Error in Expression: 
Insufficient operators - leftover operands

=================================

EXPRESSION: AB-*CBA+-*
    LD A
    SB B
    ST TEMP1

Evaluation Terminated Due to Error in Expression: 
Insufficient number of operands, or excess operators

=================================

EXPRESSION: ABC-/BA-+/
    LD B
    SB C
    ST TEMP1
    LD A
    DV TEMP1
    ST TEMP2
    LD B
    SB A
    ST TEMP3
    LD TEMP2
    AD TEMP3
    ST TEMP4

Evaluation Terminated Due to Error in Expression: 
Insufficient number of operands, or excess operators

=================================

EXPRESSION: ABC+$CBA-+*
    LD B
    AD C
    ST TEMP1
    LD A
    EX TEMP1
    ST TEMP2
    LD B
    SB A
    ST TEMP3
    LD C
    AD TEMP3
    ST TEMP4
    LD TEMP2
    ML TEMP4
    ST TEMP5

=================================

EXPRESSION: AB0+/CBA+-/

Evaluation Terminated Due to Error in Expression:
Invalid input character: 0

=================================


5) Additional test expressions for 
	ignoring whitespace (spaces an tabs), with and without errors, 
	multiple whitespaces and combination of whitespaces per line,
	lower case alpha ignored
	blank line
	Program continues with next expression after errors.

(base) jMBP:Project Files jph$ java MachineLanguageGenerator TestAdditionalInput.txt TestAdditionalOutput.txt

EXPRESSION: A   B	+ C-  
    LD A
    AD B
    ST TEMP1
    LD TEMP1
    SB C
    ST TEMP2

=================================

EXPRESSION: AB     C	+-
    LD B
    AD C
    ST TEMP1
    LD A
    SB TEMP1
    ST TEMP2

=================================

EXPRESSION: 	AB-C+ DEF-+a	$
    LD A
    SB B
    ST TEMP1
    LD TEMP1
    AD C
    ST TEMP2
    LD E
    SB F
    ST TEMP3
    LD D
    AD TEMP3
    ST TEMP4
    LD TEMP4
    EX A
    ST TEMP5

Evaluation Terminated Due to Error in Expression: 
Insufficient operators - leftover operands

=================================

EXPRESSION: abcde-+$*ef*-
    LD D
    SB E
    ST TEMP1
    LD C
    AD TEMP1
    ST TEMP2
    LD B
    EX TEMP2
    ST TEMP3
    LD A
    ML TEMP3
    ST TEMP4
    LD E
    ML F
    ST TEMP5
    LD TEMP4
    SB TEMP5
    ST TEMP6

=================================

EXPRESSION: ABC+*CBA-+*
    LD B
    AD C
    ST TEMP1
    LD A
    ML TEMP1
    ST TEMP2
    LD B
    SB A
    ST TEMP3
    LD C
    AD TEMP3
    ST TEMP4
    LD TEMP2
    ML TEMP4
    ST TEMP5

=================================

EXPRESSION:  AbC+/	CB A* +
    LD B
    AD C
    ST TEMP1
    LD A
    DV TEMP1
    ST TEMP2
    LD B
    ML A
    ST TEMP3
    LD C
    AD TEMP3
    ST TEMP4

Evaluation Terminated Due to Error in Expression: 
Insufficient operators - leftover operands

=================================

EXPRESSION: AB-*C8A+-*
    LD A
    SB B
    ST TEMP1

Evaluation Terminated Due to Error in Expression: 
Insufficient number of operands, or excess operators

=================================

EXPRESSION: A B C - / B A - + /
    LD B
    SB C
    ST TEMP1
    LD A
    DV TEMP1
    ST TEMP2
    LD B
    SB A
    ST TEMP3
    LD TEMP2
    AD TEMP3
    ST TEMP4

Evaluation Terminated Due to Error in Expression: 
Insufficient number of operands, or excess operators

=================================

EXPRESSION: 

=================================

EXPRESSION: 	BLANK LINE

Evaluation Terminated Due to Error in Expression: 
Insufficient operators - leftover operands

=================================

EXPRESSION: 		$

Evaluation Terminated Due to Error in Expression: 
Insufficient number of operands, or excess operators

=================================

EXPRESSION: A BC+$	CBA-+*
    LD B
    AD C
    ST TEMP1
    LD A
    EX TEMP1
    ST TEMP2
    LD B
    SB A
    ST TEMP3
    LD C
    AD TEMP3
    ST TEMP4
    LD TEMP2
    ML TEMP4
    ST TEMP5

=================================

EXPRESSION: 	AB0+/CBA+-/

Evaluation Terminated Due to Error in Expression:
Invalid input character: 0

=================================


6) array size = 8 => stack overflow

...
=================================

EXPRESSION: 	BLANK LINE

Evaluation Terminated Due to Insufficient Resources: 
*** Stack is FULL ***

=================================
...


(base) jMBP:Project Files jph$ date
Tue Mar  5 22:12:18 HST 2019
