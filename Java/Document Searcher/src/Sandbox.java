import java.io.*;
import java.util.*;

public class Sandbox 
{
	static PrintStream jOut = System.out;
	static Scanner jIn = new Scanner(System.in);
	
	
	public static void main(String[] args) throws IOException 
	{
		
		jOut.println("initializing");
		CaseHandler handler = new CaseHandler();
		handler.loadCases("Cases");
		Case tmp =handler.getCase(0);
		tmp.printData();
		handler.dumpData("CaseList.txt");
		jOut.println(handler.searchByJudge("U.S. Supreme Court"));
		jOut.println("done");
		//a_case.printData(jOut);
		
	}

}
