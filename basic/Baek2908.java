package basic;

import java.util.Collections;
import java.util.Scanner;

public class Baek2908 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = String.valueOf(in.nextInt());
		String b = String.valueOf(in.nextInt());
		
		String reva = "";
		String revb = "";
		
		for(int i=2; i>=0; i--){
			reva += a.charAt(i);
			revb += b.charAt(i);
		}
		
		int ra = Integer.valueOf(reva);
		int rb = Integer.valueOf(revb);
		
		System.out.println(Math.max(ra, rb));

	}

}
