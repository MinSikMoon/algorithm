package grammar.basic;



class Student{
	//members
	String name;
	int classNum;
	int no;
	int scoreKor, scoreEng, scoreMath;
	
	//constructor
	public Student(String name, int classNum, int no, int scoreKor, int scoreEng, int scoreMath){
		this.name = name;
		this.classNum = classNum;
		this.no = no;
		this.scoreKor = scoreKor;
		this.scoreEng = scoreEng;
		this.scoreMath = scoreMath;
	}
	
	//methods
	public int getTotal(){
		return scoreKor + scoreEng + scoreMath;
	}
	
	public float getAverage(){
		return (int)(getTotal()/3f*10+0.5f)/10f;
	}
}



public class UsingFloat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("minsik", 1, 1, 100, 100, 100);
		System.out.println(s1.getAverage());
		
		
		

	}

}
