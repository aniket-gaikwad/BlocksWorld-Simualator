package HelperClass;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;


public class FileUtilities {

	public static void write2File(String str, String fileName){
 		try{
			//Create file 
			File file = new File(fileName);
			//write to this file
			FileUtils.writeStringToFile(file, str+"\n");
		}catch (IOException e){ //Catch exception if any
			System.err.println("IO Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public static void write2File(String str, String fileName, boolean append){
 		try{
			//Create file 
			File file = new File(fileName);
			//write to this file
			FileUtils.writeStringToFile(file, str+"\n", append);
		}catch (IOException e){ //Catch exception if any
			System.err.println("IO Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public static int countLines(String filename){
	// Count number of lines in an ascii file
		int cnt = 0;
		try {
			LineNumberReader reader  = new LineNumberReader(new FileReader(filename));
			String lineRead = "";
			while ((lineRead = reader.readLine()) != null) {}
			cnt = reader.getLineNumber(); 
			reader.close();
		} catch (IOException ex) {
			System.out.println("Problem counting file.\n" + ex.getMessage());
		}
		return cnt;
	}
	public static ArrayList<String> readLines(String fileName, int startLine, int endLine)  {
	// read from the startLine to endLine from an ascii file
		String line = null;
		int currentLineNo = 0;
		ArrayList<String> lines = new ArrayList<String>();
		BufferedReader in = null;
		try {
			in = new BufferedReader (new FileReader(fileName));
			//read to startLine
			while(currentLineNo<startLine) {
				if (in.readLine()==null) {
					// oops, early end of file
					throw new IOException("File too small");
				}
				currentLineNo++;
			}
			//read until endLine
			while(currentLineNo<=endLine) {
				line = in.readLine();
				if (line==null) {
					return lines;
				}
				lines.add(line);
				currentLineNo++;
			}
		} catch (IOException ex) {
			System.out.println("Problem reading file.\n" + ex.getMessage());
		} finally {
			try { if (in!=null) in.close(); } catch(IOException ignore) {}
		}
		return lines;
	}
	public static ArrayList<String[]> readCSVDoubleFile(String filename){
	// Read in a comma separated file
		ArrayList<String[]> data = new ArrayList<String[]>();
		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(filename));
			String line = null;

			while ((line = br.readLine()) != null) {
				String[] values = line.split(", |,");
				data.add(values);
			}
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if (br != null)
					br.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return data;
	}
	public static void moveAllFiles(String sourceDir, String destDir, String suffix){
		File dest = new File(destDir);
		File dir = new File(sourceDir);
		String[] files = dir.list( new SuffixFileFilter(suffix) );
		for (int i = 0; i < files.length; i++) {
			//System.out.println(files[i]);
			File src1 = new File(files[i]);
			try {
				FileUtils.moveFileToDirectory(src1, dest, true);
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	public static void copyAllFiles(String sourceDir, String destDir, String suffix){
		File dest = new File(destDir);
		File dir = new File(sourceDir);
		String[] files = dir.list( new SuffixFileFilter(suffix) );
		for (int i = 0; i < files.length; i++) {
			//System.out.println(files[i]);
			File src1 = new File(files[i]);
			try {
				FileUtils.copyFileToDirectory(src1, dest, false);
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}

}
