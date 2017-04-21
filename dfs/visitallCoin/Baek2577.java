package dfs.visitallCoin;
import java.util.Scanner;

public class Baek2577 {
	//static members
	static int[] check = new int[10];
	//method
	static void recur(long sample){
		long a = sample/10;
		int b = (int)sample%10;
		
		if(a == 0){
			check[b]++;
			return;
		}
		
		check[b]++;
		recur(a);
	}
	
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		long multied = a*b*c;
		recur(multied);
		for(int i : check)
			System.out.println(i);
		
	}
}
