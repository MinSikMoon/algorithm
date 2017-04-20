package basic.string;


//자바에서 상수 define 하는 법 연습
interface operators{
	int PLUS = 1;
	int MINUS = 2;
	int MULTI = 3;
	int DIVIDE = 4;
}

public class JavaDefine {
	public static void main(String[] args) {
		System.out.println(operators.DIVIDE);
	}

}
