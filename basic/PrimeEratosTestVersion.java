package basic;

import java.util.Scanner;

public class PrimeEratosTestVersion {
	//members
	static Scanner keyboard = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 입력받기
		int sampleNum = keyboard.nextInt();
		//2. 자료구조 생성 및 초기화
		int primeCount = 0;
		boolean[] isPrime = new boolean[sampleNum+1];
		for(int i=0; i<sampleNum+1; i++){
			isPrime[i] = true;
		}
		//3. 0,1 예외처리
		isPrime[0] = false;
		isPrime[1] = false;
		//4. 로직시작
		for(int i=2; i<sampleNum+1; i++){
			if(isPrime[i]){ //true라고 적히면 일단 판별 대상임// 판별시작
				for(int j=2; j<=i/2; j++){ //소수 판별
					if(i % j == 0){ //소수가 아님
						continue; //다음으로 넘어간다. 						
					}
				}
				//소수 판별이 끝났는데도 안걸리면 소수임
				primeCount++; //일단 소수갯수 하나 올려주고 //배수는 다 false화 시킨다.
				for(int k = i; k < sampleNum+1; k+=i){
					isPrime[k] = false;
				}
			}
		}
		//5. 소수갯수 출력
		System.out.println(primeCount);
		
	}

}
