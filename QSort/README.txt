QuickSort ReadMe file - Written by  ********** Ankit Luthra ************
-------------------------------
What is the Program?
-------------------------------
This is Quicksort program written in java. This will sort the numbers in any number of input files and write sorted output to answer.txt file.
Along with answers it will also calculate running time for performance analysis. To run the program, you need to compile and run through below commands on command prompt.

>javac QSort.java

>java QSort <inputfile_1> <inputfile_2> ...... <inputfile_n>

-------------------------------
What is the Program Design?
-------------------------------
Program has 7 methods namely:
main()
readAtFilePath()
doPerformanceAnalysis()
doEverything()
partition()
quickSort() 
writeFile()

Main method invokes rest of the methods to read input file, run an quiksort on the input and write answer.txt file respectively.


-------------------------------
What is the Algorithm breakdown?
-------------------------------

This algorithm works basis picking always the last element as pivot. This is divide and conquer strategy where division is through partition number.
And there are two parts of the algorithm

1. selecting the partition point
2. running quick sort on each of partition

Combining part is done by recursion strategy. Now Assume the pivot we has divided the array into two parts - one of size k and the other of size n − k. So complexity relation gives us:

T(n) = T(k) + T(n − k) + αn

where T(n) refers to the time taken by the algorithm to sort n elements, and αn is constant time for steps like combine or divide.

In an ideal case, partition point is middle of array
T(n) = 2T(n/2) + αn

or

= 2kT(n/2k) + kαn

Reducing (n/2k) to 1


T(n) = nT(1) + αn log n, which is O(n log n).

This is the best case for quicksort.

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
1. String array [] argument to main method where all arguments is considered input file
2. quiksort has been supported through double array[], i.e. supports decimal number sorting
3. Static arrayList to maintain input and output of numbers through out the program
4. Buffered Read Write and File Read Write streams as br and fr respectively 
