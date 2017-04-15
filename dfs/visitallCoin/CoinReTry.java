package dfs.visitallCoin;
import java.util.Scanner;


public class CoinReTry {
	static int coinNum;
	static Scanner in = new Scanner(System.in);
	static String[] result;
	
	
	
	static void recur(int index, String fb){
		result[index] = fb;
		//1. terminal filter
		if(index == coinNum-1){
			for(String str : result){
				System.out.print(str);
			}
			System.out.println();
			return;
		}
		//2. else
		recur(index + 1, "앞");
		recur(index + 1, "뒤");
		
	}
	
	public static void main(String[] args){
		coinNum = in.nextInt();
		result = new String[coinNum];
		recur(0,"앞");
		recur(0,"뒤");
	}
}
