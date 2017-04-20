package stack.basic;
import java.util.Stack;
import java.util.Scanner;

public class Paranthesis02 {
	
	//method
	static int change(char ch){
		int result = 0;
		
		switch(ch){
		case '[':
			result = 1;
			break;
		case ']':
			result = -1;
			break;
		case '(':
			result = 2;
			break;
		case ')':
			result = -2;
			break;
		}
		return result;
	}
	
	
	//main
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		Stack<Integer> stk = new Stack<>();
		//1.===============str 한개씩 꺼내서 보기
		for(int i=0; i<str.length(); i++){
			int cur = change(str.charAt(i));
			//2. =================i가 첫번째면 그냥 넣어두기
			if(i == 0){
				stk.add(cur);
				continue;
			}
			//2. =================열린거면 쌓고, 닫힌거면 하나빼서 비교
			if(cur > 0){
				stk.add(cur);
			}else{
				int temp = stk.peek();
				//3. ===================닫힌건데, 밑에거랑 합이 맞다면 삭제해주기
				if(temp + cur == 0){
					stk.pop();
				}else{
					stk.add(cur);
				}
			}
		}
		//1. ===============다 끝나고 나서 사이즈가 0이면 정상 아니면 비정상
		System.out.println(stk.size());
		if(stk.size() == 0){
			System.out.print("올바른 괄호");
		}else{
			System.out.print("괄호 올바르지 않음");
		}
		
	}

}
