package basic;

//import java.util.Scanner;
import java.util.Scanner;


public class PrimeBasic {
	//members
	static Scanner keyboard = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = keyboard.nextInt();
		if(target == 1){
			System.out.println("no");
			return;
		}
		if(target == 2){
			System.out.println("yes");
			return;
		}
			
		for(int i = 2; i <= target/2; i++){
			if(target % i == 0){
				System.out.println("no: " + i + " x " + target / i);
				return;
			}
		}
		
		System.out.println("yes");
	}

}
