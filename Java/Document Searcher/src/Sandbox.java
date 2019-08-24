import java.io.*;
import java.util.*;

public class Sandbox 
{
	static PrintStream jOut = System.out;
	static Scanner jIn = new Scanner(System.in);
	
	static Case readFile(File f)
	{
		Scanner s = new Scanner(f);
		Case ret = new Case
				(
					s.nextLine(), // judge
					s.nextLine(), //summary
				);
		return ret;
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
