package dp.Basic;
import java.util.Scanner;
import java.util.Arrays;

//기본적으로 몇 가지가 있느냐는 말단 노드의 갯수를 세는 것임// 동전뒤집기와 같다. 
public class KnapSackBaekjoon3{
	static int resultCnt = 0;
	static int objNum, maxWeight;
	static int[] objWeightArr;
	public static void recur(int index, int sumWeight){
		if(sumWeight > maxWeight ){
			return;
		}
		if(index == objNum){
			resultCnt++;
			return;
		}
		
		//recursive call
		recur(index+1, sumWeight + objWeightArr[index+1]);
		recur(index+1, sumWeight);
	}
	
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		
		objNum = keyboard.nextInt();
		objWeightArr = new int[objNum+1];
		maxWeight = keyboard.nextInt();
		for(int i=1; i<objNum+1; i++){
			objWeightArr[i] = keyboard.nextInt();
		}
		
		recur(0,0);
		System.out.println(resultCnt);
		
		
		
	}
}