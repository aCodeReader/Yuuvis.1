
import java.util.*;
import java.io.*;
public class Main 
{
	static PrintStream jOut = System.out;
	static Scanner jIn = new Scanner(System.in);
	private static void readWords(Scanner s, HashSet<String> set)
	{
		while (s.hasNextLine())
		{
			set.add(s.nextLine());
		}
	}
	public static HashSet<String> read(File f) throws IOException
	{
		if (f.isDirectory())
		{
			jOut.println("directory");
		}
		HashSet<String> ret = new HashSet<String>();
		
		if (f.isDirectory())
		{
			File [] list = f.listFiles();
			for (File fi: list)
			{
				Scanner sc = new Scanner(fi);
				readWords(sc, ret);
				sc.close();
			}
			return ret;
		}
		Scanner s = new Scanner(f);
		readWords(s, ret);
		s.close();
		return ret;
	}
	public static void writeToFile(Object o, String dst) throws IOException
	{
		FileWriter w = new FileWriter(dst);
		w.write(o.toString()+"\n");
		w.close();
	}
	public static void main(String[] args) 
	{
		try
		{
			File fi = new File("Samples");
			HashSet<String> words = read(fi);
			writeToFile(words, "test.out");
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

}
