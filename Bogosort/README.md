## COSC 251 Group 7: BogoSort

This project implements Bogo Sort in Java and compares its performance against Bubble Sort, Selection Sort, and Insertion Sort across different dataset sizes.

## Prerequisites
Make sure you have the Java Development Kit (JDK) installed on your system. 

Project Structure
Because the source code uses the package Bogosort; declaration, your Java files must be placed inside a directory named exactly Bogosort.
- Bogosort/Main.java
- Bogosort/BogoSort.java

## How to Compile
1. Open your terminal or command prompt.
2. Navigate to the root directory that contains the Bogosort folder. Do not navigate inside the Bogosort folder itself.
3. Run the following command to compile all Java files:

   	javac Bogosort/*.java


## How to Run & Test
After successfully compiling the code, run the main program using this command:

	java Bogosort.Main

The program will execute and print the performance metrics (attempts, comparisons, swaps, and runtime) directly to your console.

The program will automatically generate a performance.txt file in your current directory containing the sorted arrays and performance data.

## How to Change Dataset Sizes


By default, the program runs the small dataset (n = 5). To test the medium (n = 1,000) or large (n = 1,000,000) datasets as required by the rubric:

Open Bogosort/Main.java in any text editor.

Locate line 16: int size = 5;

Change the value to 1000 or 1000000.

Save the file, recompile using the instructions above, and run it again.

(Warning: BogoSort is O(n x n!) and mathematically cannot finish sorting 1,000 or 1,000,000 elements. You will need to press Ctrl + C in your terminal to force quit the program when testing these larger sizes).