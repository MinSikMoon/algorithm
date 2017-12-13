package basic;

import java.util.*;

//0999같은 경우도 고려해줘야함.
public class Baek9047BiggestNumber {
	//members
	static int sampleNum;

	public static int getAnswer(int sample){
		//0. 리스트에 넣어주기
		LinkedList<Integer> sortedList = new LinkedList();
		int divisor = 1000;
		while(divisor > 0){
			sortedList.add(sample/divisor);
			sample %= divisor;
			divisor/=10;
		}
		
		//1. 가장 큰수 구하기
		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		int maximum, minimum;
		maximum = 1000*sortedList.get(0) + 100*sortedList.get(1) + 10*sortedList.get(2) + sortedList.getLast();
		//2. 가장 작은 수 구하기
		Collections.sort(sortedList);
		minimum = 1000*sortedList.get(0) + 100*sortedList.get(1) + 10*sortedList.get(2) + sortedList.getLast();
		return maximum-minimum;
	}
	
	public static int getCnt(int sample){
		int cnt = 0;
		
		while(true){
			if(getAnswer(sample) == 6174)
				break;
			cnt++;
			sample = getAnswer(sample);
		}
			
		if(cnt != 0){
			return cnt+1;
		}else
			return cnt;
	}

	//main
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		sampleNum = in.nextInt();
		int[] sampleArr = new int[sampleNum];
		for(int i=0; i<sampleNum; i++){
			sampleArr[i] = in.nextInt();
		}
		for(int i=0; i<sampleNum; i++){
			System.out.println(getCnt(sampleArr[i]));
		}
		
	}
}
