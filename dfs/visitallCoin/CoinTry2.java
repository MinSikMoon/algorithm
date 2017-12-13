package dfs.visitallCoin;
import java.util.Scanner;



public class CoinTry2 {
	//member
	static int[] arr;
	static int sampleNum;
	
	//method
	static void recur(int index){
		//terminal filter
		if(index == sampleNum){
			for(int i : arr){
				if(i == 0)
					System.out.print("앞");
				else
					System.out.print("뒤");
			}
			System.out.println();
			return;
		}
		
		//terminal이 아니라면 배열에 넣고 call하는 작업
		for(int i=0; i<2; i++){
			arr[index] = i;
			recur(index + 1);
		}
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		sampleNum = in.nextInt();
		arr = new int[sampleNum];
		recur(0);
		
	}
}
