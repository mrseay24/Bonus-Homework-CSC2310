import java.io.*;

public class testFile_Reading{

  // This is the testFacebook class


  public static void main (String[] argc){

	BufferedReader in=null;
	try{
		FileReader fileread = new FileReader ("testFile_Reading.java");
		in = new BufferedReader(fileread);
		String line = in.readLine();
		while (line != null)
		{
		    System.out.println(line);
			line = in.readLine();
		}
		in.close();
	}catch (IOException e){
		 System.out.println("File exception! "+e);
		 System.exit(-1);
	}


  }

}