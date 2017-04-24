package basic;
import java.util.Scanner;


public class Baek9469 {


	//method
	static double getFly(double l, double a, double b, double f){
		//1. 시간을 구한다. 
		double time = l/(a+b);
		//2. 파리 이동거리를 구한다.
		double flyLength = time * f;

		return flyLength;
	}

	public static void main(String[] args){
		//input
		Scanner in = new Scanner(System.in);
		int sampleNum = in.nextInt();
		double[] lengths = new double[sampleNum];
		double[] as = new double[sampleNum];
		double[] bs = new double[sampleNum];
		double[] fs = new double[sampleNum];

		//for input
		for(int i=0; i<sampleNum; i++){
			lengths[i] = in.nextDouble();
			as[i] = in.nextDouble();
			bs[i] = in.nextDouble();
			fs[i] = in.nextDouble();
		}

		//print
		for(int i=0; i<sampleNum; i++){
			System.out.printf("%d %.2f \n", i+1, getFly(lengths[i], as[i], bs[i], fs[i]));
		}



	}
}
