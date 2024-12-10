package bd1;
import dataStructures.*;
public class Subject {
	private String subjectCode;
	private String subjectName;
	private float credit;
	
	public Subject()
	{
		subjectCode = null;
		subjectName = null;
		credit = 0.0f;
	}
	
	public Subject (String ss)
	{
		String [] strval;
		strval = ss.split("/");
		subjectCode = strval[0];
		subjectName = strval[1];
		credit = Float.parseFloat(strval[2]);
	}
	public Subject(Subject ll)
	{
		subjectCode = ll.subjectCode;
		subjectName = ll.subjectName;
		credit = ll.credit;
	}
	public void setCode(String sC)
	{
		subjectCode = sC;
	}
	public void setName(String sN)
	{
		subjectName = sN;
	}
	public void setCredit(float cr)
	{
		credit = cr;
	}
	public float getCredit()
	{
		return credit;
	}
	public String getSubjectCode()
	{
		return subjectCode;
	}
	public String getSubjectName()
	{
		return subjectName;
	}
	public static void displayHead()
	{
		String titleTemplate = "%-20s %-40s %10s\n";
		System.out.println("****Hicheeluudiin Jagsaalt****");
		System.out.printf(titleTemplate, "Hicheeliin Code","Hicheeliin ner","credit");
	}
	public void display()
	{
		String titleTemplate = "%-20s %-40s %10s\n";
		System.out.printf(titleTemplate, subjectCode,subjectName,credit);
	}

}
