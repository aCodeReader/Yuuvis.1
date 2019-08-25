import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Case 
{
	private String judge;
	private String summary;
	private String plantiff;
	private String defendant;
	private String arguedDate;
	private String decidedDate;
	private String key;
	private String courtsInvolved;
	private ArrayList<String> caseData; //regex check
	
	public Case(
			String judge,
			String summary,
			String plaintiff,
			String defendant,
			String pageNumbers,
			String argued,
			String decided,
			String key,
			String courtsInvolved
			)
	{
		setJudge(judge);
		setSummary(summary);
		setPlaintiff(plaintiff);
		setDefendant(defendant);
		setArguedDate(argued);
		setDecidedDate(decided);
		setKey(key);
		setCourtsInvolved(courtsInvolved);
		caseData = new ArrayList<String>();
	}
	//getters and setters
	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	public String getDefendant() {
		return defendant;
	}
	public void setDefendant(String defendant) {
		this.defendant = defendant;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPlantiff() {
		return plantiff;
	}
	public void setPlaintiff(String plantiff) {
		this.plantiff = plantiff;
	}
	public String getArguedDate() {
		return arguedDate;
	}
	public void setArguedDate(String arguedDate) {
		this.arguedDate = arguedDate;
	}
	public String getDecidedDate() {
		return decidedDate;
	}
	public void setDecidedDate(String decidedDate) {
		this.decidedDate = decidedDate;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getCourtsInvolved() {
		return courtsInvolved;
	}
	public void setCourtsInvolved(String courtsInvolved) {
		this.courtsInvolved = courtsInvolved;
	}

	public void readCase(String s)
	{
		caseData.add(s);
	}
	public ArrayList<String>getKeyWords()
	{
		ArrayList<String> ret = new ArrayList<String>();
		for (int i =0; i<20; i++)
		{
			if (caseData.get(i).startsWith("\""))
			{
				ret.add(caseData.get(i));
			}
		}
		return ret;
	}
	private void writeTo(String x, Collection<String> c) throws IOException
	{
		FileWriter w = new FileWriter(x);
		int i =0;
		for (String s: c)
		{
			w.write(i+": "+s+"\n");
			i++;
		}
		w.close();
	}
	public void printData() throws IOException
	{
		writeTo("CaseDetails.txt", caseData);
		writeTo("CaseKeywords.txt", getKeyWords());
	}
	//toString
	public String toString()
	{
		return summary+"\n";
	}
}
