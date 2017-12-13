package basic;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;

public class BiggestNumber1422 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sampleNum = in.nextInt();
		int selectNum = in.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=0; i<sampleNum; i++){
			list.add(in.nextInt());
		}
		
		Collections.sort(list);
		Collections.reverse(list);
		
		try{
			String result = "";
			//만약 selectNum이 sampleNum 초과라면
			if(selectNum > sampleNum){
				for(int i=0; i<(selectNum-sampleNum); i++){
					result += String.valueOf(list.get(0));
				}
			}
			for(int i=0; i<sampleNum; i++){
				result += String.valueOf(list.get(i));
				
			}
			System.out.print(Integer.valueOf(result));
		}catch(Exception e){
			
		}
		
		

	}

}
