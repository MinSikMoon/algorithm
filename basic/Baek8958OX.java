package basic;

import java.util.Scanner;

public class Baek8958OX {
	
	
	//method
	public static int getScore(String str){
		int point = 0;
		int result = 0;
		
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			
			if(ch == 'O'){
				point++;
				result += point;
			}else{
				point = 0;
			}
		}
		
		return result;
		
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sampleNum = in.nextInt();
		String[] strings = new String[sampleNum];
		for(int i=0; i<sampleNum; i++)
			strings[i] = in.next();
		
		for(int i=0; i<sampleNum; i++)
			System.out.println(getScore(strings[i]));
		

	}

}
