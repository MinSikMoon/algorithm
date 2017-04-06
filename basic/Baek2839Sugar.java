package basic;
import java.util.Scanner;

public class Baek2839Sugar {
	
	public static void main(String[] args){
		//input
		Scanner keyboard = new Scanner(System.in);
		int limitW = keyboard.nextInt();
		int resultCnt;
		//logic
		if(limitW % 5 == 0){
			resultCnt = limitW/5;
			System.out.println(resultCnt);
			return;
		}else{
			int maxFiveCnt = limitW/5;
			for(int i = maxFiveCnt; i>=0; i--){
				int restWeight = limitW-(5*i);
				if(restWeight % 3 == 0){
					resultCnt = i + restWeight/3;
					System.out.println(resultCnt);
					return;
				}else
					continue;
			}
		}
		
		//다 못통과하면 -1
		System.out.println(-1);
		
	}
	
}
