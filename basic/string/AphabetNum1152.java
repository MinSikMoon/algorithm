package basic.string;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//map 사용법 익히기
public class AphabetNum1152 {
	//members
	static Scanner in = new Scanner(System.in);
	static HashMap<Character, Integer> map = new HashMap<>();
	static HashMap<Integer, Integer> cntMap = new HashMap<>();
	
	
	public static void main(String[] args){
		//0. input
		String sample = in.next().toLowerCase();
		//1. map에 넣기
		for(int i=0; i<sample.length(); i++){
			char tempChar = sample.charAt(i);
			//map에서 있는지 없는지 조사
			if(map.containsKey(tempChar)){ //있다면
				map.replace(tempChar, map.get(tempChar)+1);
			}else{ //없다면
				map.put(tempChar, 1);
			}
		}
		//2. value 중에서 max구하기 없다면 ?출력
		Set<Character> keySet = map.keySet();
		int maxNum = 0;
		char maxChar = 'a';
		boolean isFirst = true;
				
		for(char ch : keySet){
			if(isFirst){
				maxChar = ch;
				maxNum = map.get(ch);
				isFirst = false;
			}
			int curNum = map.get(ch);
			if(curNum > maxNum){
				maxChar = ch;
				maxNum = curNum;
			}
			if(cntMap.containsKey(curNum)){
				cntMap.replace(curNum, cntMap.get(curNum) + 1);
			}else{
				cntMap.put(curNum, 1);
			}
			
		}
		
		//print
		if(cntMap.get(maxNum) == 1){
			System.out.print((maxChar + "").toUpperCase());
		}else{
			System.out.print("?");
		}
		
	}
}
