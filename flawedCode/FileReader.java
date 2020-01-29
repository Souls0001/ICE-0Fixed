//Jon Hendrickson
//Flawed Code with three major erros that need fixed
//1/21/2020
package flawedCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileReader {
	 
		public static void main(String[] args) throws FileNotFoundException, IOException {
			try
			{
				System.out.println("Getting file ...");
				String fPath = GetFilePath(args);
				System.out.print(GetContents(new File(fPath)));
			}catch(ArrayIndexOutOfBoundsException arrayOut)
			{
				System.out.println("No arguments were passed to the file searcher");
			}
	    }
	    
		// 1
	    // https://wiki.sei.cmu.edu/confluence/display/java/FIO16-J.+Canonicalize+path+names+before+validating+them
	    // FIO16-J. Canonicalize path names before validating them
	    private static String GetFilePath(String[] args) throws IOException
	    {
	        File file = new File("/img/" + args[0]);
	        if (!isInSecureDir(file)) {
	        	  throw new IllegalArgumentException();
	        	}
	        	String canonicalPath = file.getCanonicalPath();
	        	if (!canonicalPath.equals("/img/java/file1.txt") &&
	        	    !canonicalPath.equals("/img/java/file2.txt")) {
	        	   // Invalid file; handle error
	        	}
	        	 
	        	FileInputStream fis = new FileInputStream(canonicalPath);
	        return file.getPath();
	    }
	    
	    private static boolean isInSecureDir(File file) {
			// TODO Auto-generated method stub
			return false;
		}

		// 2
	    // https://wiki.sei.cmu.edu/confluence/display/java/FIO02-J.+Detect+and+handle+file-related+errors
	    // FIO02-J. Detect and handle file-related errors (Exceptions)
	    private static String GetContents(File f) throws FileNotFoundException, IOException
	    {
	    	File file = new File("file");
	    	if (!file.delete()) {
	    	  System.out.println("Deletion failed");
	    	}
	    	return FileHelper.ReadFileContents(f);
	    }
	}