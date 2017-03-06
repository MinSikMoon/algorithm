package dfs.backTracking;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class SubSet {
	//1. static properties
	static Stack<Integer> subSetStack = new Stack<>(); //subSet들의 조합을 보여줄 스택
	static int sum = 0;
	
	//2. inner Method - DFS recursive
	static void subSet(int index,boolean sumFlag, Vector<Integer> elemVector, int targetNum){
		//0. member
		int lastVectorIdx = elemVector.size() - 1;
		
		//1. 모두 실행되어야 로직 - none
		//2. 말단 최종로직 : subSetStack에 있는 숫자들의 합이 targetNum과 같다면 출력
 		if(index > lastVectorIdx){
			if(sum == targetNum){
				for(Integer elem : subSetStack){
					System.out.print(elem + ", ");
				}
				System.out.println();
			}
			return;
		}
		//3. 중간 로직이라면 - none
		//4. call을 몇 단계로 나눠서 해줘야 하는가/ 그리고 call 해주자.
			//1. 더해주는 경우
		if(sumFlag){
			subSetStack.push(elemVector.get(index));
			sum += elemVector.get(index);
		}
		subSet(index+1, true, elemVector, targetNum);
		subSet(index+1, false, elemVector, targetNum);
		
		//5. 모든 게 끝나고 돌아온다면
		if(subSetStack.size() > 0){
			if(sumFlag){
				//true인 경우는 sum에서 자기만큼 빼준다. 
				subSetStack.pop(); //가장 최근 스택요소를 삭제해준다. 
				sum -= elemVector.get(index);
			}
		}
		
	}
	
	
	
	/////////////////////MAIN/////////////////////
	public static void main(String[] args) {
		//0. members
		int elemNum; //몇 개의 재료 숫자들이 입력 될 것인가
		int targetNum;
		Vector<Integer> elemVector; //재료 숫자들을 담을 벡터	
		
		// 개요 : 숫자 묶음의 조합으로 주어진 숫자를 만들 수 있는가? 있다면 몇가지 경우가 생기는가?
		//0. 입력부 만들기
		Scanner keyboard = new Scanner(System.in);
		//	elemNum 입력 & elemVector 초기화
		elemNum = Integer.parseInt(keyboard.nextLine());
		elemVector = new Vector<>(elemNum);
		//  elemNum만큼 벡터에 재료 숫자 입력 받기
		for(int i=0; i<elemNum; i++){
			elemVector.add(Integer.parseInt(keyboard.nextLine()));
		}
		// 목표 숫자 입력받기
		targetNum = Integer.parseInt(keyboard.nextLine());
		
		//1. subSet()호출
		subSet(0, true, elemVector, targetNum);
		subSet(0, false, elemVector, targetNum);

	}

}
