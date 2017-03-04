package dfs.visitallCoin;

import java.util.Scanner;
import java.util.Vector;

public class Coin {
	//문제 : 동전의 갯수를 입력받고, recursive한 메소드로, 모든 경우의 수를 출력하는 프로그램
	
	//members : algorithm 풀이용이니까 public static으로 만든다.
	public static int coinNum = 0;
	public static Vector<String> resultVector = new Vector<String>();
	
	//==================================================inner Method
	public static void recursiveCoin(int curIndex, int coinNum){
		//0. member
		resultVector.setSize(coinNum); //Vector가 계속 새로 만들어져서 public static으로 하나로 만들고 공유시켜야함.
		
		//1. recursive니까 break 조건을 걸어준다. => 얘가 중요 -> 말단 노드에서 무슨 일이 벌어져야 하는지 구현하는 것임.
		if(curIndex == coinNum){
			for(String str : resultVector){
				System.out.print(str);
			}
			System.out.println();
			return;
		}
		
		//2. 그렇다면 말단 노드 까지 가기전의 로직은 vector를 채워주는 로직이어야 한다. 즉 중간로직
		//1. 먼저 앞을 채워주는 로직
		resultVector.add(curIndex, "앞");
		recursiveCoin(curIndex + 1, coinNum); //한번 리턴해서 부모노드로 이동하는 과정
		resultVector.add(curIndex, "뒤");
		recursiveCoin(curIndex + 1, coinNum);
	}
		
	//=============================Main===============================
	public static void main(String[] args) {
	//1. 입력부 - Scanner 만들기
		Scanner keyboard = new Scanner(System.in);
	//2. 입력받는다.
		System.out.printf("동전 갯수를 입력하세요:");
		coinNum = Integer.parseInt(keyboard.nextLine());
	//3. coin() 실행
		recursiveCoin(0, coinNum);
	}
}
