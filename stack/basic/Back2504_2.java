package stack.basic;
import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

interface mop{
	int PLUS = 1;
	int MULTI = 2;
}

/* 여기서 틀림/
input
([()(())](())([[]]()))()[()]
answer
96
*/

public class Back2504_2 {
	
	//method
	static int change(char ch){
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
	static int getResult(Stack<Integer> ps,Stack<Integer> ns,Stack<Integer> os){
		int num = ns.pop();
		while(!ns.isEmpty()){
			int opr = os.pop();
			if(opr == mop.PLUS)
				num += ns.pop();
			else
				num *= ns.pop();
		}
		return num;
	}
	
	//main
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Stack<Integer> pStk = new Stack<>();
		Stack<Integer> numStk = new Stack<>();
		Stack<Integer> opStk = new Stack<>();
		List<Integer> resultList = new LinkedList<>();
		//input
		String str = in.next();
		//logic
		boolean isClosed = false;
		//1.===================한 문자당 검사한다. 
		for(int i=0; i<str.length(); i++){
			//1.5 ====== i가 2이상일때 pstk이 비워져 있응면 결과 리스트에 저장한다. 
			if(i>0 && pStk.isEmpty()){
				resultList.add(getResult(pStk, numStk, opStk));
				pStk = new Stack<>();
				numStk = new Stack<>();
				opStk = new Stack<>();
			}
			int ch = change(str.charAt(i));
			//2. ====== 열린 괄호라면
			if(ch > 0){
				pStk.add(ch);
				numStk.add(ch);
				//3.====== 첫번째가 아니면 피연산자 계산 해준다. 
				if(i!=0 && !pStk.isEmpty()){
					//4. ====== 전에게 닫힌 괄호였다면
					if(isClosed){
						opStk.add(mop.PLUS);
						//4. ====== 전에게 열린 괄호였다면
					}else
						opStk.add(mop.MULTI);
				}
				isClosed = false;
			//2. ====== 닫힌 괄호라면
			}else{
				//3. ====== 첫번째로 닫힌 괄호가 오면 err
				if(pStk.isEmpty()){
					System.out.print(0);
					return;
				//3. ====== 아니라면 : pstk에서 peek해서 비교 후 삭제여부판단
				}else{
					int temp = pStk.peek();
					//4. ====== 합이 맞다면 : 삭제해줌
					if(ch + temp == 0){
						pStk.pop();
					//4. ====== 합이 안맞다면 : 그냥 add해준다. 
					}else{
						pStk.add(ch);
					}
				}
				isClosed = true;
			}
		}
		
		//1. ====== 이제 다 돌았으니 pstk이 비었으면 정상이 맞고 아니면 err
		resultList.add(getResult(pStk, numStk, opStk));
		if(!pStk.isEmpty()){
			System.out.print(0);
		}else{
			int result = 0;
			for(int i : resultList){
				result += i;
			}
			
			System.out.print(result);
		}
		
		
	}
}
