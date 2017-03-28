package basic;

import java.util.Scanner;

public class PrimeEratosCustom {
static Scanner keyboard = new Scanner(System.in);
	
	static boolean isPrime(int n){
		if(n == 0 || n == 1)
			return false;
		if(n == 2)
			return true;
		
		for(int i=2; i<=n/2; i++){
			if(n % i == 0)
				return false;
		}
		
		return true;
	}


	public static void main(String[] args) {
		//1. 입력
		int sampleNum = keyboard.nextInt();
		int targetCount = keyboard.nextInt();
		int targetChecker = 0;
		int primeNumCount = 0;
		//2. 배열 생성 및 초기화
		boolean[] isPrimeArr = new boolean[sampleNum+1];
		isPrimeArr[0] = false;
		isPrimeArr[1] = false;
		for(int i=2; i<sampleNum+1; i++)
			isPrimeArr[i] = true;
		
		//3. 본격 로직
		for(int i=2; i<sampleNum+1; i++){
			if(isPrimeArr[i]){
				if(isPrime(i)){ //만약 이게 솟수면
					targetChecker++;
					if(targetChecker == targetCount){
						System.out.println(i);
						return;
					}
					primeNumCount++;
					for(int j=i*2; j<sampleNum+1; j+=i){
						if(isPrimeArr[j]){
							isPrimeArr[j] = false;
							targetChecker++;
							if(targetChecker == targetCount){
								System.out.println(j);
								return;
						}
						
						}
					}
				}
			}
		}
		
		
		
	}
}
