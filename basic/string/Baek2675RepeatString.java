package basic.string;

import java.util.Scanner;

public class Baek2675RepeatString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sampleNum = in.nextInt();
		String[] samples = new String[sampleNum];
		int[] repeats = new int[sampleNum];
		
		for(int i=0; i<sampleNum; i++){
			repeats[i] = in.nextInt();
			samples[i] = in.next();
		}
		
		for(int i=0; i<sampleNum; i++){
			String str = samples[i];
			int rptime = repeats[i];
			for(int j=0; j<str.length(); j++){
				for(int k=0; k<rptime; k++){
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
		}
	}

}
