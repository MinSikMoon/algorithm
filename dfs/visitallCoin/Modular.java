package dfs.visitallCoin;

public class Modular {
	static int[] check = new int[10];
	
	//recur : 각 자리 숫자 합 구하기
	static int recur(int sample){
		int a = sample/10;
		int b = sample%10;
		
		if(a == 0){
			return b;
		}
		
		return b + recur(a);
	}
	
	//recur2 : 각 자리 숫자들이 몇 개 나온지 기록하기
	static void recur2(int sample){
		int a = sample/10;
		int b = sample%10;
		
		if(a == 0){
			check[b]++;
			return;
		}
		check[b]++;
		recur2(a);
	}
	public static void main(String[] args){
		System.out.println(recur(10101010));
		recur2(17037300);
		for(int i : check)
			System.out.println(i);
	}
}
