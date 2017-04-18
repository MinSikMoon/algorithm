package basic;

import java.util.Scanner;

public class LcmBasic {
	//members
	static Scanner in = new Scanner(System.in);
	
	//methods
	static long gcd(long a, long b){
		long bigger, smaller;
		if(a > b){
			bigger = a;
			smaller = b;
		}else{
			bigger = b;
			smaller = a;
		}
		while(bigger % smaller != 0){
			long rest = bigger % smaller;
			bigger = smaller;
			smaller = rest;
		}
		return smaller;
	}

	static long lcm(int a, int b){
		long gcd = gcd(a,b);
		return gcd * (a/gcd) * (b/gcd);
	}
	
	public static void main(String[] args) {
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println(lcm(a,b));

	}

}
