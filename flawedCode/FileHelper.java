//Jon Hendrickson
//Flawed Code with three major erros that need fixed
//1/21/2020
package flawedCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHelper {


	// 3
	// https://wiki.sei.cmu.edu/confluence/display/java/FIO04-J.+Release+resources+when+they+are+no+longer+needed
	// FIO04-J. Release resources when they are no longer needed
	public static String ReadFileContents(File f) throws FileNotFoundException
	{
		try(FileInputStream stream = new FileInputStream(f.getPath());
			 BufferedReader bufRead =
			     new BufferedReader(new InputStreamReader(stream))) {
			 StringBuilder builder = new StringBuilder();
			 String line;
			 while ((line = bufRead.readLine()) != null) {
			   builder.append(line);
			 }
		}catch(IOException e) {
			  
			 
		}
		return null;
	}
	
}
