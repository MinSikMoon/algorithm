package stack.basic;
import java.util.Scanner;
import java.util.Stack;



//operators
interface op{
	int PLUS = 1;
	int MULTI = 2;
}

public class Baek2504 {
	//method
	static int toNum(char ch){
		int result = 0;
		switch(ch){
		case '(':
			result = 2;
			break;
		case ')':
			result = -2;
			break;
		case '[':
			result = 3;
			break;
		case ']':
			result = -3;
			break;
		}
		return result;
	}
	
	
	//main
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String str = in.next();
		Stack<Integer> numStk = new Stack<>();
		Stack<Integer> opStk = new Stack<>();
		int recent = 0;
		int cnt = 0;
		//1. ==================ch하나 꺼내서 정수로 변환
		for(int i=0; i<str.length(); i++){
			int chNum = toNum(str.charAt(i));
			//2. 열린 괄호냐 닫힌 괄호냐 체크해본다. 
			if(chNum > 0){
				numStk.add(chNum);
				cnt++;
				//3. 열린관혼데, 지금 i가 두번째 이상이라면 이제 연산자도 봐야되는거
				if(i > 0){
					//4. recent랑 같은 방향이면 multi 아니면 plus
					if(recent*chNum > 0)
						opStk.add(op.MULTI);
					else
						opStk.add(op.PLUS);	
				}
			}else{
				//3. 닫힌 괄혼데, 지금 i가 첫번째면 그냥 에러,
				if(i == 0){
					System.out.print(0);
					return;
				//3. 닫힌 괄혼데, 지금 i가 두번째 이상이면 recent랑 관계 조사
				}else{
					//4. recent랑 chNum이랑 합쳐서 0이면 올바른것
					if(recent+chNum == 0){
						cnt--;
					}else{
						System.out.print(0);
						return;
					}
				}
			}
		//5. ==================다 돌면ch가 recent가 된다. 	
			recent = chNum;
		}
		
		//1. 계산하기
		if(cnt != 0){
			System.out.print(0);
			return;
		}
		
		int num = numStk.pop();
		while(numStk.size() != 0){
			int opr = opStk.pop();
			if(opr == op.MULTI){
				num *= numStk.pop();
			}else
				num += numStk.pop();
		}
		
		System.out.println(num);
		
		
	}
	
	
	
}
