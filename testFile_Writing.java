import java.io.*;

public class testFile_Writing{

  // This is the testFacebook class


  public static void main (String[] argc){

	 PrintWriter testFile_out=null;
	 try{
     	FileWriter fileout=new FileWriter("TotallyNewFile.txt", true);
	 	BufferedWriter bufout=new BufferedWriter(fileout);
	 	testFile_out=new PrintWriter(bufout);
	 } catch (IOException e){
		 System.out.println("File exception!");
		 System.exit(-1);
	 }

	 String fileContentString = "This is the CSC2310 class of GSU!";
	 testFile_out.println("The first line of file");
	 testFile_out.println(fileContentString);
	 testFile_out.println("The line above has "+fileContentString.length()+" characters");
	 testFile_out.close();

  }

}