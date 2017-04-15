package dfs.visitallCoin;
import java.util.Scanner;

public class CoinFor {
	//members
	static int coinNum;
	static char[] coinArr;
	
	
	//method recursive
	static void recur(int index){
		//terminal filter
		if(index == coinNum){
			for(int i=0; i<coinNum; i++){
				if(coinArr[i] == 0){
					System.out.print("앞");
				}else{
					System.out.print("뒤");
				}
			}
			System.out.println();
			return;
		}
		
		//logic
		for(int i=0; i<2; i++){
			coinArr[index] = (char)i;
			recur(index+1);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		coinNum = in.nextInt();
		coinArr = new char[coinNum];
		recur(0);
	}

}
