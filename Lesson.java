package bd1;

public class Lesson {
	public Subject learned;
	public int score;
	public Lesson(Subject l,int sc)
	{
		learned = new  Subject(l);
		score = sc;
	}
	
	public float unelgeeOnoo()
	{
		if(96 <= score && score <=100) 
			 return 4.0f;
		 else  if(91 <= score && score <=95) 
			 return 3.7f;
		 else  if(88 <= score && score <=90) 
			 return 3.4f;
		 else  if(84 <= score && score <=87) 
			 return 3.0f;
		 else  if(81 <= score && score <=83) 
			 return 2.7f;
		 else  if(78 <= score && score <=80) 
			 return 2.3f;
		 else  if(74 <= score && score <=77) 
			 return 2.0f;
		 else  if(71 <= score && score <=73) 
			 return 1.7f;
		 else  if(68 <= score && score <=70) 
			 return 1.4f;
		 else  if(64 <= score && score <=67) 
			 return 1.0f;
		 else  if(60 <= score && score <=63) 
			return 0.7f;
		 else 
			return 0.0f;
	}

}
