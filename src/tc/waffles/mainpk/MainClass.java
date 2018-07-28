package tc.waffles.mainpk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// Gets the input file path from the user.
		System.out.print("Input file path: ");
		String ipath = s.nextLine();
		
		// Gets the input file path from the user.
		System.out.print("Output file path (e.g. /home/user/output.txt): ");		
		String opath = s.nextLine();
		
		// Gets the reader and writer
		BufferedReader br = getReader(ipath);
		PrintWriter pw = getWriter(opath);
		
		// Calculates all cases and generate the output
		processCases(br, pw);
		
		// Closes input and output streams
		closeStreams(br, pw);
		
		System.out.println("Results has been generated successfully!");
	}
	
	
	/** Create a new reader to read the input */
	public static BufferedReader getReader(String path) {
		// Create the file reader
		FileReader fr;
		try {
			fr = new FileReader(new File(path));
		} catch (FileNotFoundException e1) {
			// Check if the file exists, if not, finish the program safely
			System.out.println("File does not exist.");
			e1.printStackTrace();
			return null;
		}	

		return new BufferedReader(fr);	
	}
	
	
	/** Create a writer to write the output */
	public static PrintWriter getWriter(String path) {
		// Create the file writer
		FileWriter fw;
		try {
			fw = new FileWriter(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return new PrintWriter(fw);
	}
	
	
	/** Close opened streams */
	public static void closeStreams(BufferedReader br, PrintWriter pw) {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.close();
	}
	
	
	/** Process all cases and write the output */
	public static void processCases(BufferedReader br, PrintWriter pw) {
		try{
			int ncases = Integer.parseInt(br.readLine());

			// Iterate every case
			for(int i=0; i<ncases; i++) {
				// Gets the rows and cols from the readed line (case)
				String[] line = br.readLine().split(" ");
				int rows = Integer.parseInt(line[0]);
				int cols = Integer.parseInt(line[1]);
				
				/* Every n vertical lines we will have n-1 holes high and 
				 * every m horizontal lines we will have m-1 holes wide. 
				 * We just need to multiply them to get the total number 
				 * of holes. */
				int holes = (rows-1)*(cols-1);
				pw.println("Case #"+(i+1)+": "+holes);
			}
	    }catch(NumberFormatException e){
	        System.out.println("Input file hasn't got a right format.");
	        e.printStackTrace();
	    } catch (IOException e) {
			e.printStackTrace();
		}
	}

}
