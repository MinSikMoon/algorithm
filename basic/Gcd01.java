package basic;
import java.util.Scanner;

//유클리드 호제법 테스트 : 최대공약수, 최소공배수
public class Gcd01 {
	//members
	static Scanner in = new Scanner(System.in);
	static int sampleNum;
	static int[][] sampleArr;
	
	//methods
	static int gcd(int a, int b){
		int bigger, smaller;
		if(a > b){
			bigger = a;
			smaller = b;
		}else{
			bigger = b;
			smaller = a;
		}
		while(bigger % smaller != 0){
			int rest = bigger % smaller;
			bigger = smaller;
			smaller = rest;
		}
		return smaller;
	}
	
	static int lcm(int a, int b){
		int gcd = gcd(a,b);
		return gcd * (a/gcd) * (b/gcd);
	}
	
	public static void main(String[] args){
		sampleNum = in.nextInt();
		sampleArr = new int[sampleNum][2];
		for(int i=0; i<sampleNum; i++){
			sampleArr[i][0] = in.nextInt();
			sampleArr[i][1] = in.nextInt();
		}
		for(int i=0; i<sampleNum; i++){
			System.out.println(lcm(sampleArr[i][0], sampleArr[i][1]));
		}
		
	}
}
