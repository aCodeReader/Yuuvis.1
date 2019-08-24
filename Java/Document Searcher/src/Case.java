import java.util.ArrayList;

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
			String s0,
			String s1,
			String s2,
			String s3,
			String s4,
			String s5,
			String s6,
			String s7
			)
	{
		setJudge(s0);
		setSummary(s1);
		setPlantiff(s2);
		setDefendant(s3);
		setArguedDate(s4);
		setDecidedDate(s5);
		setKey(s6);
		setCourtsInvolved(s7);
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
	public void setPlantiff(String plantiff) {
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

	
	//toString
	public String toString()
	{
		return summary+"\n";
	}
}
