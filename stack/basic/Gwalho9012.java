package stack.basic;

import java.util.Scanner;
import java.util.Stack;

public class Gwalho9012 {
	
	static void check(String ps){
		//member
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<ps.length(); i++){
			char curChar = ps.charAt(i); //현재 캐릭터
			
			//대조작업
			if(stack.isEmpty() || stack.peek() == curChar){
				stack.push(curChar);
			}else{
				stack.pop();
			}
		}
		
		//다 했는데 stack에 남아있다면 no, 없다면 yes
		if(stack.isEmpty()){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		String[] strArr = new String[cnt];
		for(int i=0; i<cnt; i++){
			strArr[i] = sc.nextLine();
		}
		System.out.println();
		for(String str : strArr){
			check(str);
		}
	}

}
