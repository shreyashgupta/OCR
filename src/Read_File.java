
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
public class Read_File {
	public static String read_a_file(String file_name) {
		BufferedReader reader;
		String ret="";
		try {
			reader = new BufferedReader(new FileReader(
					file_name));
			String line = reader.readLine();
			while (line != null) {
				ret+=line;
				ret+="\n";
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
}