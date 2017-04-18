package basic;
import java.util.Scanner;
import java.util.TreeSet;

public class Gcd2981 {
	//members
	static Scanner in = new Scanner(System.in);
	static int sampleNum;
	static TreeSet<Long> sampleSet = new TreeSet<>();
	static TreeSet<Long> resultSet = new TreeSet<>();	
	//main
	public static void main(String[] args){
		sampleNum = in.nextInt();
		for(int i=0; i<sampleNum; i++)
			sampleSet.add(in.nextLong());

		//logic
		long minSample = sampleSet.first();
		long maxSample = sampleSet.last();
		long diff = maxSample - minSample;
		long diffSqrt = (long)Math.floor(Math.sqrt(diff));
		long minimumLimit = Math.max(minSample, diffSqrt); //약수 구하기의 limit
		System.out.println("min : " + minimumLimit);
		for(long i = 2; i<=minimumLimit; i++){
			if(diff%i == 0){
				resultSet.add(i);
				long divisor = diff/i;
				if(divisor <= minSample)
					resultSet.add(divisor);
			}
		}

		for(long divider : resultSet){
			boolean isFirst = true;
			boolean flag = true;
			long curRest = minSample%divider;

			for(long sample : sampleSet){
				if(sample%divider != curRest){
					flag = false;
					break;
				}
			}
			if(flag)
				System.out.print(divider + " ");
		}
	}

}


