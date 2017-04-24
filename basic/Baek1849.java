package basic;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class Baek1849 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sampleNum = in.nextInt();
		int[] samples = new int[sampleNum+1];
		List<Integer> list = new LinkedList<>();
		for(int i=1; i<=sampleNum; i++){
			samples[i] = in.nextInt();
		}
		
		//1. 인덱스 거꾸로 내려오면서 list에 넣는다.
		for(int i=sampleNum; i>=0; i--){
			//2. 마지막 인덱스라면
			if(i == sampleNum){
				list.add(i);
				continue;
			}
			//2. 아니라면 
			list.add(samples[i],i);
				
		}
		
		//1. print
		for(int i=1; i<=sampleNum; i++)
			System.out.println(list.get(i));

	}

}
