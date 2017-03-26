package basic;

import java.util.Scanner;

public class TrainSpeed {
	static Scanner keyboard = new Scanner(System.in); 
	
	
	public static void main(String[] args) {
		int dataNum; 
		int[] testCaseNum = null;
		float[] length = null;
		float[] aSpeed = null;
		float[] bSpeed = null;
		float[] flySpeed = null;
		
		//1. 입력부
		dataNum = keyboard.nextInt();
		testCaseNum = new int[dataNum]; 
		length = new float [dataNum];
		aSpeed = new float[dataNum];
		bSpeed = new float[dataNum];
		flySpeed = new float[dataNum];
		
		for(int i=0; i<dataNum; i++){
			testCaseNum[i] = keyboard.nextInt();
			length[i] = keyboard.nextFloat();
			aSpeed[i] = keyboard.nextFloat();
			bSpeed[i] = keyboard.nextFloat();
			flySpeed[i] = keyboard.nextFloat();
		}
		
		//2. 로직
		//1. 시간을 구한다. 
		
		
		//2. 출력
		for(int i = 0; i<dataNum; i++){
			System.out.print(testCaseNum[i] + " ");
			double resultTime = length[i]/(aSpeed[i] + bSpeed[i]);
			double resultCount = resultTime*flySpeed[i];
			System.out.printf("%.2f", resultCount);
			System.out.println();
		}
		
		

	}

}
