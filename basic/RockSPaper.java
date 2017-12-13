package basic;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class RockSPaper {
	static char win(char p1){
		char result = 0;
		switch(p1){
		case 'R':
			result = 'S';
			break;
		case 'P':
			result = 'R';
			break;
		case 'S':
			result = 'P';
			break;
		}
		return result;
	}
	
	//method
	static int game(char p1, char p2){
		int result = 0;
		if(p1 == p2) //같으면 0출력
			return result;
		
		if(p2 == win(p1))
			result = 1;
		else
			result = -1;
		
		return result;
	}
	
	
	
	//main
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sampleNum = in.nextInt();
		int[] resultArr = new int[sampleNum]; //최종결과 기록
		
		for(int i=0; i<sampleNum; i++){
			int gameNum = in.nextInt();
			int aWin = 0;
			int bWin = 0;
			for(int j=0; j<gameNum; j++){
				char a = in.next().charAt(0); //결과 입력받고
				char b = in.next().charAt(0);
				int result = game(a,b);
				if(result == 1)
					aWin++;
				if(result == -1)
					bWin++;
			}
			if(aWin == bWin)
				resultArr[i] = 0;
			else if(aWin > bWin)
				resultArr[i] = -1;
			else
				resultArr[i] = 1;
		}
		
		for(int i=0; i<sampleNum; i++){
			int result = resultArr[i];
			String str;
			if(result== 0)
				str = "Tie";
			else if(result == -1)
				str = "Player 1";
			else
				str = "Player 2";
			System.out.println(str);
		}
	}

}
