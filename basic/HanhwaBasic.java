package basic;

import java.util.Scanner;

public class HanhwaBasic {
	//member
	static int sampleNum;
	static int[][] sampleArr = null;


	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		
		sampleNum = keyboard.nextInt();
		sampleArr = new int[sampleNum][2];
		for(int i=0; i<sampleNum; i++){
			sampleArr[i][0] = keyboard.nextInt();
			sampleArr[i][1] = keyboard.nextInt();
		}

		for(int i=0; i<sampleNum; i++){
			System.out.println("Case #" + (i+1));
			System.out.println(sampleArr[i][0] + sampleArr[i][1]);
		}



	}

}
