package basic.string;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlphabetOrd10809 {
	static Scanner in = new Scanner(System.in);
	static Map<Character, Integer> map = new HashMap<>();
	
	public static void main(String[] args){
		//map초기화
		for(char c = 'a' ; c <= 'z'; c++){
			map.put(c, -1);
		}
		//input
		String str = (in.next()).toLowerCase();
		//str 분석
		for(int i=0; i<str.length(); i++){
			char curCh = str.charAt(i);
			if(map.get(curCh) == -1){ //아직 기록되지 않았다면
				map.replace(curCh, i); //현재 걸로 바꾼다. 
			}
		}
		//print
		for(char i='a'; i<='z'; i++){
			System.out.print(map.get(i) + " ");
		}
	}
}
