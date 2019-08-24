import java.io.*;
import java.util.*;

public class Sandbox 
{
	static PrintStream jOut = System.out;
	static Scanner jIn = new Scanner(System.in);
	
	static Case readFile(File f) throws FileNotFoundException
	{
		Scanner s = new Scanner(f);
		ArrayList<String> headers = new ArrayList<>();
		String line = s.nextLine();
		while (!line.equalsIgnoreCase("syllabus")) {
			headers.add(line);
			if (s.hasNextLine()) {
				line = s.nextLine();
			}
			else {
				break;
			}
		}
				
		String judge = headers.get(0);
		String summary = headers.get(1);
		// plaintiff v. defendant, document
		String[] parts = summary.split(", ");
		// plaintiff v. defendant
		String[] partsPlaintiffAndDefendant = parts[0].split("v.");
		String plaintiff = partsPlaintiffAndDefendant[0];
		String defendant = partsPlaintiffAndDefendant[1];
		String volume = parts[1];
		String pageNumbers = headers.get(3);
		String argued = headers.get(4);
		String decided = headers.get(5);
		String courtsInvolved = headers.get(7) + "; " + headers.get(8);
		
		ArrayList<String> details = new ArrayList<String>();
		
		s.close();
				
		
		Case ret = new Case
				(
					judge, // judge
					summary,
					plaintiff,
					defendant,
					pageNumbers,
					argued,
					decided,
					volume,
					courtsInvolved
				);
		return ret;
	}
	public static void main(String[] args) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub
		Case a_case = readFile(new File("case_1.txt"));
		System.out.println(a_case);
	}

}
