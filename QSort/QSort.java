/**
* QSort.java
* QuickSort Program
* Ankit Luthra - 801019495
**/




import java.util.ArrayList;
import java.util.Arrays; 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QSort{

	static BufferedWriter br = null;
	static StringBuilder performance = null;
   
   
/**
* main()
* starts everything
**/
	
   public static void main(String args[]){
         
      try {
			// Making sure the file path is not empty or null
			if (args == null || args.length == 0) {
				System.out.println("Please provide file path argument");
				return;
			}else
				for(int i=0; i<args.length;i++)
					// Going to read file
					doEverything(args, i);
			doPerformanceAnalysis();                     
			// Close writer			
			if (br != null)
				br.close();		
		}catch(Exception ex) {
			System.out.println("Failure in main method");
			ex.printStackTrace();
		}
   }
   
   
/**
* doPerformanceAnalysis()
* Actually its just printing analysis
**/

private static void doPerformanceAnalysis() throws IOException {
	br.newLine();br.newLine();br.newLine();
	br.append("Performance Analysis:");
	br.newLine();
	br.append("input file | file size | sorting time");
	br.newLine();
	br.append(performance.toString());
	if (br != null)
				br.close();
}

/**
* doEverything()
* Running quickSort and then measuring sorting time
**/


private static void doEverything(String[] args, int i) throws IOException {
	System.out.println("Reading file from argument "+i);
	QSort qsort = new QSort();
	ArrayList<Double> numberList = qsort.readFileAtPath(args[i]);
	// Converting ArrayList to array and pass this array to sorting method
	Double[] array = numberList.toArray(new Double[numberList.size()]);
	System.out.println("Given array" + Arrays.toString(array));
	long startTime = System.currentTimeMillis();
	qsort.quickSort(array, 0, array.length-1);
	long endTime = System.currentTimeMillis();
	long totalTime = endTime - startTime;
	System.out.println("Sorted Array is" + Arrays.toString(array));
	System.out.println("Time consumption for "+ args[i]+ ":"+ totalTime);
	System.out.println("Writing to answer.txt file");
	qsort.writeFile(array, totalTime, args[i]);
	}




/**
* partition()
* Partitioning for recursion
**/

   private int partition(Double input[], int low, int high){
   
      double pivot = input[high];
      //System.out.println("Pivot is :"+pivot);
   
      int i = low-1;
      for(int j =low; j < high; j++){
         if (input[j] <= pivot){
            i++;
            double x = input[j];
            input[j] = input[i];
            input[i] = x;
         }else{
            // do nothing
         }     
      }
      input[high] = input[i+1];
      input[i+1]= pivot;
      //System.out.println("array is :"+Arrays.toString(input));  
      return i+1;
   
   }



/**
* quickSort - The algorithm
**/
   private Double[] quickSort(Double arr[], int low, int high)
   {
      if (low < high)
      {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
         int partition = partition(arr, low, high);
      
            // Recursively sort elements before
            // partition and after partition
         quickSort(arr, low, partition-1);
         quickSort(arr, partition+1, high);
      }
      return arr;
   }




 /**
	 * readFileAtPath method: used to read an input file
	 * @param filePath
	 */
	public ArrayList<Double> readFileAtPath(String filePath) {
   
      BufferedReader br = null;
		String lineContent = null;
		boolean readingFlag = false;
      ArrayList<Double> numberList = null;
   try{
   
		try{
			br = new BufferedReader(new FileReader(filePath));
			// Iterate for each new line found in the file until no new line is found.
			numberList = new ArrayList<Double>();
			while ((lineContent = br.readLine()) != null) {
				lineContent = lineContent.trim().replaceAll("\n", ";");
				//System.out.println("Found the line: " + lineContent);
				readingFlag = true;
				String[] stringArray = lineContent.split(";");
				for (String str : stringArray) {

					numberList.add(Double.parseDouble(str));
				} 
			}

			if (!readingFlag) {
				System.out.println("oops! the file at" +filePath+" is nothing to read in file");
				System.exit(0);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}catch (NumberFormatException nfx) {
			System.out.println("Failure in converting input to number format");
			System.out.println(nfx.getMessage());
			//System.exit(0);
		}// Make sure we close the buffered resources.
		finally {
			if (br != null)
				br.close();
		}
       
   }catch (IOException e) {
			e.printStackTrace();
		}   
   
    return numberList;
}

	
	

	/**
	 * writeFile method : used to write answer.txt file
	 * @param array
	 */
	public void writeFile(Double[] array, long time, String filename) {
		
		try {
			if (br!=null){
				br.newLine();
				br.newLine();
				br.append("Sorted array "+ filename + " " + Arrays.toString(array));
				performance.append("\n" + filename + "\t" + array.length + "\t \t" + time);
            			performance.append(System.getProperty("line.separator"));
			}else{
				br = new BufferedWriter(new FileWriter("answer.txt"));
				br.write("Sorted array "+ filename + " " +Arrays.toString(array));
				performance = new StringBuilder(filename + "\t" + array.length + "\t \t" + time);
            			performance.append(System.getProperty("line.separator"));
			}	
		} catch (IOException e) {
			e.printStackTrace();
		} // Make sure we close the buffered resources.
		finally {
         // nothing required here
         // because we are closing buffered reader just once in main method
         // after reading multiple files
					}
   }// end of method

}