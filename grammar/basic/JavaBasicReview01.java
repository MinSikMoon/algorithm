package grammar.basic;


class SutdaCard{
	//member
	int num;
	boolean isKwang;
	//constructor 2개
	public SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	public SutdaCard(){  //오버로딩된 생성자 콜
		this(1, true);
	}
	
	//toString 오버라이딩
	public String toString(){
		return "num: " + num + ", isKwang ? : " + (isKwang? "yes": "no");
	}
}


public class JavaBasicReview01 {
	public static void main(String[] args){
		SutdaCard s1 = new SutdaCard(77, false);
		SutdaCard s2 = new SutdaCard();
		
		System.out.println(s1);
		System.out.println(s2);
	}
}
