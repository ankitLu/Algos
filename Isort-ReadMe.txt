Insertion Sort ReadMe file - Written by  ********** Ankit Luthra ************
-------------------------------
What is the Program?
-------------------------------
This is Insertion sort program written in java. This will sort the numbers in an input file and write sorted output to answer.txt file.
To run the program, you need to compile and run through below commands on command prompt.

>javac Isort.java

>java Isort <inputfile.txt>


-------------------------------
What is the Program Design?
-------------------------------
Program has four methods namely main(), readAtFilePath(), runInsertionSort(), writeFile
Main method invokes rest of the three methods to read input file, run an insertion sort on the input and write answer.txt file respectively.


-------------------------------
What is the Algorithm breakdown?
-------------------------------

for (int j = 1; j < array.length; j++) {								// assume test condition runs n times
				// Current key value							// zero cost comment
				int key = array[j];							// n-1 times
				int i = j - 1;								// n-1 times
				// keep swapping until the key is at correct position			// zero cost comment
				while (i >= 0 && array[i] > key) {					// assume test condition runs t times for each iteration from i=2 -> input size
					array[i + 1] = array[i];					// t-1 times for each iteration from i=2 -> input size
					i -= 1;								// t-1 times for each iteration from i=2 -> input size
				}									//
				array[i + 1] = key;							//
			}										// n-1 times
		}


Two assumptions: input size is K and Cost of each step is C
Then total cost is:

C*[n + (n-1) + (n-1) + tK + tK-1 + tK-1 + (n-1)]

This would come out as a linear expression, and discarding simpler terms
The worst case complexity will be Theta n(square)



-------------------------------
What is the compiler and platform used?
-------------------------------
Program is written on Java platform. Compiler tool jGrasp: http://www.jgrasp.org/ using JDK 8


-------------------------------
What are the program fails and works?
-------------------------------
Following fails have been corrected post unit testing
1. Number format exception is handled when there is input other than number
2. Check enabled for empty input file
3. proper program exit after exception
4. If the input file is not provided or argument is blank

Program fail:
This program works on java int primitive type and so far is not using long data type. so if the number is larger than the scope of int,
it will result into number format exception.


-------------------------------
What is the data structure design?
-------------------------------
Following data structures have been primarily used:
1. String array [] argument to main method where first argument is considered input file
2. Insertion sort has been supported through int array[]
3. Static arrayList to maintain input and output of numbers through out the program
4. Buffered Read Write and File Read Write streams as br and fr respectively 
