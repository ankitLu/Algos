
/**
Student Name: Ankit Luthra.
Below program invokes insertion sort on input file with numbers

**/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Isort {

	private static ArrayList<Integer> numberList = new ArrayList<Integer>();
/**
 * main method: invokes methods for reading input file, sorting, writing to output file.
 * @param args
 */
	public static void main(String[] args) {
		try {
			// Making sure the file path is not empty or null
			if (args == null || args.length == 0) {
				System.out.println("Please provide file path argument");
				return;
			}
			// Going to read file
			System.out.println("Reading file from argument 1");
			readFileAtPath(args[0]);
			// Converting ArrayList to array and pass this array to sorting method
			Integer[] array = numberList.toArray(new Integer[numberList.size()]);
			System.out.println("Given array" + Arrays.toString(array));
			runInsertionSort(array);
			System.out.println("Sorted Array is" + Arrays.toString(array));
			System.out.println("Writing to answer.txt file");
			writeFile(array);
		}catch(Exception ex) {
			System.out.println("Failure in main method");
			ex.printStackTrace();
		}
	}

	/**
	 * readFileAtPath method: used to read an input file
	 * @param filePath
	 */
	public static void readFileAtPath(String filePath) {
		BufferedReader br = null;
		String lineContent = null;
		boolean readingFlag = false;
		try {
			try {
				br = new BufferedReader(new FileReader(filePath));
				// Iterate for each new line found in the file until no new line is found.
				while ((lineContent = br.readLine()) != null) {
					System.out.println("Found the line: " + lineContent);
					readingFlag = true;
					String[] stringArray = lineContent.split(";");
					for (String str : stringArray) {
						try {
							numberList.add(Integer.parseInt(str));
						} catch (NumberFormatException nfx) {
							System.out.println("Failure in converting input to number format");
							System.out.println(nfx.getMessage());
							System.exit(0);
						}
					}
				}
				if (!readingFlag) {
					System.out.println("oops! there is nothing to read in file");
					System.exit(0);
				}
					
			} catch (IOException e) {
				e.printStackTrace();
			} // Make sure we close the buffered resources.
			finally {
				if (br != null)
					br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end of method

	/**
	 * runInsertionSort method: used to sort the input numbers
	 * @param array
	 */
	private static void runInsertionSort(Integer[] array) {
		try{
			System.out.println("Running Insertion sort");
			for (int j = 1; j < array.length; j++) {
				// Current key value
				int key = array[j];
				int i = j - 1;
				// keep swapping until the key is at correct position
				while (i >= 0 && array[i] > key) {
					array[i + 1] = array[i];
					i -= 1;
				}
				array[i + 1] = key;
			}
		}catch(Exception ex) {
			System.out.println("Failure in runInsertionSort method");
			ex.printStackTrace();
			System.exit(0);
		}
		
	}// end of method

	/**
	 * writeFile method : used to write answer.txt file
	 * @param array
	 */
	public static void writeFile(Integer[] array) {
		BufferedWriter br = null;
		try {
			try {
				br = new BufferedWriter(new FileWriter("answer.txt"));
				// Iterate for each new line found in the file until no new line is found.
				br.write(Arrays.toString(array));
			} catch (IOException e) {
				e.printStackTrace();
			} // Make sure we close the buffered resources.
			finally {
				if (br != null)
					br.close();
			}
		} catch (IOException e) {
			System.out.println("Failure in writeFile method");
			e.printStackTrace();
		}
	}// end of method
}
