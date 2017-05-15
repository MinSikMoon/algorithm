package basic.string;

import java.util.Scanner;

public class Baek1316 {
	
	//method
	static int toI(char ch){
		return (int)(ch) - 96;
	}
	
	static boolean isContinuous(String str){
		//local members
		str = str.toLowerCase();
		int[] arr = new int[27];
		boolean[] isVisited = new boolean[27];
		
		for(int i=0; i<str.length(); i++){
			char tch = str.charAt(i);
			int chIdx = toI(tch);
			if(!isVisited[chIdx]){
				arr[chIdx] = i;
				isVisited[chIdx] = true;
				continue;
			}
			if(i-arr[chIdx] == 1 || i-arr[chIdx] == 0){
				arr[chIdx] = i;
			}else
				return false;
		}
		return true;
	}
	
	//main
	public static void main(String[] args) {
		//members
		Scanner in = new Scanner(System.in);
		
		//input
		int sampleNum = in.nextInt();
		int cnt = 0;
		for(int i=0; i<sampleNum; i++){
			String str = in.next();
			if(isContinuous(str))
				cnt++;
		}
		System.out.println(cnt);
		

	}

}
