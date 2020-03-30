package fxtest;

import java.io.PrintWriter;

public class doOCR {

	String performOCR(String ip)
	{
		String input_file=ip;
		String output_file="C:\\Users\\Shreyash\\Desktop\\a";	
		String tesseract_install_path="C:\\Tesseract-OCR";
		String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command);
		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
	                stdin.println("\""+"tesseract"+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
	        	    stdin.close();
	                p.waitFor();
	                System.out.println();
	                System.out.println();
	                System.out.println();
	                System.out.println();
	                return Read_File.read_a_file(output_file+".txt");
	    	} catch (Exception e) {
	 		e.printStackTrace();
		}
		return Read_File.read_a_file(output_file+".txt");
	}
}
