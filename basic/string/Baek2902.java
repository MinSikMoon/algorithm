package basic.string;

import java.util.Scanner;

public class Baek2902 {
		
	//main
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		String result = "";
		String[] arr = str.split("-");
		
		for(String t : arr){
			t = t.toUpperCase();
			result += t.charAt(0);
		}
		
		System.out.println(result);
		
	}

}
