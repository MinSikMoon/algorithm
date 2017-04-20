package basic.string;
import java.util.Scanner;

public class WordNum1152 {
	static Scanner in = new Scanner(System.in);
	
	//main
	public static void main(String[] args){
		int cnt = 0;
		String str = in.nextLine();
		String[] arr = str.split(" "); //split 예외 처리를 해줘야함 빈문자는 ""이 들어감
		for(String s : arr){
			if(!s.equals(""))
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
