package basic;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
public class PrimeBasic1978 {
	
	
	
	//main
	public static void main(String[] args){
		//input : sampleNum, samples
		Scanner in = new Scanner(System.in);
		int sampleNum = in.nextInt();
		List<Integer> samples = new LinkedList<>();
		for(int i=0; i<sampleNum; i++){
			samples.add(in.nextInt());
		}
		//sample list 정렬 오름차순
		Collections.sort(samples); //오름차순 정렬
		//maxNum구해서 
		int maxNum = samples.get(samples.size()-1);
		
		boolean[] isPrime = new boolean[maxNum+1];	
		Arrays.fill(isPrime, true); //모두 true로 채운다. 
		isPrime[0] = false;
		isPrime[1] = false;
		//logic //
		for(int i=2; i<=maxNum; i++){
			boolean flag = false;
			if(isPrime[i]){ //일단 true라고 판별된 것들만 선택한다. 
				for(int j=2; j<= Math.floor(Math.sqrt(i)); j++){
					if(i % j == 0){
						flag = true; //소수가 아니라는 것
					}
				}
				if(!flag){ //소수 라는 것
					isPrime[i] = true; //소수가 아니라는 것
					for(int k=2*i; k<=maxNum; k+=i){
						if(isPrime[k])
							isPrime[k] = false;
					}
				}
			}
		}
		
		//
		int cnt = 0;
		for(int i : samples){
			if(isPrime[i]){
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}
