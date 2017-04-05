package stack.basic;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class ParenthesisBasic {
	//members
	static Scanner keyboard = new Scanner(System.in);
	static int inputNum;
	static String[] sourceArr;
	
	//method //char비교해서 true, false 판별
	static boolean isReversed(char in, char stacked){
		if(in == stacked)
			return false;
		else if(in == '(' && stacked == ')')
			return false;
		else
			return true;
	}
	
	
	public static void main(String[] args){
		//input
		inputNum = keyboard.nextInt();
		sourceArr = new String[inputNum];
		for(int i=0; i<inputNum; i++){
			sourceArr[i] = keyboard.next();
		}
		
		//logic
		//한개씩 꺼내서 검사한다. 
		for(int i=0; i<inputNum; i++){
			String curString = sourceArr[i];
			List<Character> stack = new LinkedList<>();
			
			for(int j=0; j<curString.length(); j++){
				char curChar = curString.charAt(j);
				if(j == 0){
					stack.add(curChar);
					continue;
				}
				//현재 stack의 최상단 괄호랑 비교해본다. 
				if(stack.size() != 0 &&isReversed(curChar, stack.get(stack.size()-1))){ //합이 맞으면 넣지않고 삭제
					stack.remove(stack.size()-1); //최상단것을 삭제//그리고 새로운 것도 넣어주지 않는다.
				}else{ //같은 거라면 그냥 쌓아준다.
					stack.add(curChar);
				}
				
			}
			//한개 수행을 다했는데 stacksize가 0이 아니면 false이다. 
			if(stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
