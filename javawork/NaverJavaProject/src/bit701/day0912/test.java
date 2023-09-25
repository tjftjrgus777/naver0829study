package bit701.day0912;

import java.io.FileWriter;
import java.io.IOException;

public class test {

	static final String FILE ="";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw= null;
		fw=new FileWriter(FILE);
		fw.write("유재석");
	}

}
