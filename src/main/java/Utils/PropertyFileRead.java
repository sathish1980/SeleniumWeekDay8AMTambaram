package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileRead {

	String filename = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumWeekDay8AMTambaram\\Input\\env.properties";
	
	/*
	 * 
	 */
	public void Readproperty() throws IOException
	{

		File F = new File(filename);
		FileInputStream FI = new FileInputStream(F);
		Properties p = new Properties();
		p.load(FI);
		System.out.println(p.getProperty("url"));
		
		System.out.println(p.getProperty("username"));
		String a = p.getProperty("dob");
		int a1 = Integer.parseInt(a);
		String b =p.getProperty("mark");
		int b1 = Integer.parseInt(b);
		System.out.println(a+b);
		System.out.println(a1+b1);
		
		System.out.println(p.getProperty("dob"));
		System.out.println(p.getProperty("lastname"));
		p.setProperty("year", "2000");
		System.out.println(p.getProperty("year"));
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyFileRead P = new PropertyFileRead();
		P.Readproperty();
	}

}
