import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class CaseHandler 
{
	private HashMap<Integer, Case> database; //ID, Case
	
	public CaseHandler() //constructor
	{
		database = new HashMap<Integer, Case>();
	}
	
	//helper functions
	private Case readFile(File f) throws IOException
	{
		Scanner s = new Scanner(f);
		ArrayList<String> headers = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>();
		String line = s.nextLine();
		while (!line.equalsIgnoreCase("syllabus")) 
		{
			headers.add(line);
			if (s.hasNextLine()) 
			{
				line = s.nextLine();
			}
			else 
			{
				break;
			}
			if (line.equalsIgnoreCase("syllabus"))
			{
				do
				{
					line= s.nextLine();
					data.add(line);
				}
				while (s.hasNextLine());
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
		for (String x: data)
		{
			ret.readCase(x);
		}
		return ret;
	}
	private int generateID()
	{
		int id = 0;
		for (int i =100000000; i>=0; i--)
		{
			if (!database.containsKey(new Integer(i)))
			{
				id =i;
			}
		}
		
		return id;
	}
	
	//public functions
	/**
	 * TODO
	 * searchBySubstring(String exp)->List<Case>
	 * searchByJudge(String exp)->List<Case> DONE
	 * 
	 * */
	public Case getCase(Integer id)
	{
		return database.get(id);
	}
	public ArrayList<Case>searchByJudge(String str)
	{
		ArrayList<Case>ret = new ArrayList<Case>();
		for (Entry<Integer, Case> entry: database.entrySet())
		{
			Case c = entry.getValue();
			if (c.getJudge().contains(str))
			{
				ret.add(c);
			}
		}
		return ret;
		
	}
	public void loadCases(String fileName) throws IOException
	{
		File fi = new File(fileName);
		Case tmp = null;
		int id = 0;
		if (fi.isDirectory())
		{
			File[] files = fi.listFiles();
			for (int i =0; i<files.length; i++)
			{
				id = generateID();
				tmp = readFile(files[i]);
				database.put(new Integer(id), tmp);
			}
		}
		else
		{
			id = generateID();
			tmp=readFile(fi);
			database.put(new Integer(id), tmp);
		}
	}
	public void dumpData(String fileName) throws IOException
	{
		FileWriter w = new FileWriter(fileName);
		for (Entry<Integer, Case> entry: database.entrySet())
		{
			w.write("____________________________________\n");
			w.write("ID: "+entry.getKey()+"\n");
			w.write("Title: "+entry.getValue().getSummary()+"\n");
			w.write("Defendant: "+entry.getValue().getDefendant()+"\n");
			w.write("Plaintiff: "+entry.getValue().getPlantiff()+"\n");
			w.write("Judge: "+entry.getValue().getJudge()+"\n");
			w.write("Argued Date: "+entry.getValue().getArguedDate()+"\n");
			w.write("Decided Date: "+entry.getValue().getDecidedDate()+"\n");
			w.write("Courts Involved: "+entry.getValue().getCourtsInvolved()+"\n");
			w.write("Comments: "+entry.getValue().getKeyWords()+"\n");
			w.write("____________________________________\n");
		}
		w.close();
	}

}
