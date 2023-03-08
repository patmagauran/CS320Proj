package cs320proj.loading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    static void Loadermethod(String[] args) 
	        throws IOException
	    {
	        
	        List<String> listOfStrings
	            = new ArrayList<String>();
	       
	        
	        BufferedReader bf = new BufferedReader(
	            new FileReader("textFile.txt"));
	       
	        // read entire line as string
	        String line = bf.readLine();
	       
	        // checking for end of file
	        while (line != null) {
	            listOfStrings.add(line);
	            line = bf.readLine();
	        }
	        bf.close();
	        
	        // storing the data in arraylist to array
	        String[] array
	            = listOfStrings.toArray(new String[0]);
	       
	        // printing each line of file
	        // which is stored in array
	        for (String str : array) {
	            System.out.println(str);
	        }
	    }//Should load in Task list
}
