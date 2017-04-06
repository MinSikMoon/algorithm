package heap.basic;
import java.util.TreeSet;
import java.util.Scanner;


class GameCase implements Comparable<GameCase>{
	//member
	public int a,b,sum;
	
	//constructor
	public GameCase(int a, int b){
		this.a = a;
		this.b = b;
		this.sum = a+b;
	}
	
	@Override
	public int compareTo(GameCase in){

		return 1;
		
	}
}

public class DiceGame2 {
	//members
	static Scanner keyboard = new Scanner(System.in);
	static int a1min, a1max, a2min, a2max, b1min, b1max, b2min, b2max;
	static TreeSet<GameCase> aCases = new TreeSet<>();
	static TreeSet<GameCase> bCases = new TreeSet<>();
	static int aWinCnt = 0, bWinCnt = 0;
	
	public static void main(String[] args) {
		// input
		a1min = keyboard.nextInt();
		a1max = keyboard.nextInt();
		a2min = keyboard.nextInt();
		a2max = keyboard.nextInt();
		b1min = keyboard.nextInt();
		b1max = keyboard.nextInt();
		b2min = keyboard.nextInt();
		b2max = keyboard.nextInt();
		
		//case 만큼 넣기
		for(int i=a1min; i<=a1max; i++){
			for(int j=a2min; j<=a2max; j++){
				aCases.add(new GameCase(i,j));
			}
		}
		for(int i=b1min; i<=b1max; i++){
			for(int j=b2min; j<=b2max; j++){
				bCases.add(new GameCase(i,j));
			}
		}
		
		//숫자세기
		for(GameCase agc : aCases){
			for(GameCase bgc : bCases){
				if(agc.sum > bgc.sum)
					aWinCnt++;
				else if(bgc.sum > agc.sum)
					bWinCnt++;
			}
		}
		
		//출력
		if(aWinCnt == bWinCnt)
			System.out.println("Tie");
		else if(aWinCnt > bWinCnt)
			System.out.println("Gunnar");
		else
			System.out.println("Emma");
	}

}
