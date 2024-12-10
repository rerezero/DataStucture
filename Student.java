package bd1;
import dataStructures.*;
public class Student {
	private String studentCode;
	private Major studentMajor;
	private float GPA;
	private Chain lessons;
	
	public Student()
	{
		studentCode = null;
		studentMajor = null;
		lessons = null;
	}
	// Одоо байгаа бүх функцуудынхаа доор дараах хэсгийг нэмнэ үү
	public Chain getLessons() {
	    return lessons;
	}

	public Student(String sCode,Major smajor)
	{
		studentCode = sCode;
		studentMajor = new Major(smajor);
		lessons = new Chain();
	}
	
	public String getCode()
	{
		return studentCode;
	}
	
	public float getGPA()
	{
		float sumcr=0;
		float sumch=0;
		for(int i=0;i<lessons.size();i++)
		{
			sumcr+=((Lesson)lessons.get(i)).learned.getCredit();
			sumch+=((Lesson)lessons.get(i)).unelgeeOnoo() * ((Lesson)lessons.get(i)).learned.getCredit();				
		}
		GPA = sumch/sumcr;
		return GPA;
	}
	
	public Major getMajor()
	{
		return studentMajor;
	}
	
	public void addLesson(Subject l,int sc)
	{
		Lesson al = new Lesson(l,sc);
		if(lessons.indexOf(al)==-1)
			lessons.add(lessons.size(), al);
	}
	
	public static void displayHeader()
	{
		String titleTemplate = "%-20s %10s %10s\n";
		System.out.println("**** Oyutnuudiin golch onoonii jagsaalt ****");
		System.out.printf(titleTemplate, "student code","uzsen h/too","golch onoo");
	}
	
	public void displayGPA()
	{
		String titleTemplate = "%-20s %10s %10.2f\n";
		System.out.printf(titleTemplate, this.studentCode,this.lessons.size(),this.getGPA());
	}
}
