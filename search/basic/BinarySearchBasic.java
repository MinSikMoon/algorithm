package search.basic;

import java.util.Scanner;
import java.util.Vector;

//회고 : Binary Search는 필수적으로 sorting이 필요하다. sorting과 중복제거? -> treeSet이지.ㅎㅎ
public class BinarySearchBasic {

	public static void main(String[] args) {
		//목표: 기본적인 바이너리 서치를 구현해본다.
		//재귀버전이 아닌 while(true)버전

		//0. members
		int headIdx = 0;
		int tailIdx = 0;
		int curIdx;
		
		int targetNumber; //찾으려는 숫자
		Vector<Integer> sourceNumbers = new Vector<>(); //재료 숫자들, 배열대신 벡터로 구현해본다.
		Scanner keyboard = new Scanner(System.in);
		targetNumber = keyboard.nextInt();
		while(true){
			int tempSourceNum = keyboard.nextInt();
			sourceNumbers.add(tempSourceNum);
			if(tempSourceNum == -1)
				break;
		}
		tailIdx = sourceNumbers.size()-1;
		
		//1. method
		while(true){
			if(tailIdx < headIdx || headIdx > tailIdx)
				break;
						
			//1. headIdx와 tailIdx의 중간 Idx를 구한다. : curIdx
			curIdx = (headIdx+tailIdx)/2;
			//2. vector에서 꺼내와서 target인지 아닌지 판별
			int tempNumber = sourceNumbers.get(curIdx);
			
			if(tempNumber == targetNumber){
				System.out.println("target founded in " + curIdx);
				return;
			}else if(tempNumber < targetNumber){ //head를 옮겨야지.
				headIdx = curIdx+1;
			}else{
				tailIdx = curIdx-1;
			}
		}
		
		//2. 못찾았을때 : while을 다돌고도 return이 안된건 못찾았다는 뜻
		System.out.println("target Number is not exist.");

	}

}
