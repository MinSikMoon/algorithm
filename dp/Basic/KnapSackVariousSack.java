package dp.Basic;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;


public class KnapSackVariousSack {
	static Scanner keyboard = new Scanner(System.in);
	//members
	static int[] sackWeightArr; //가방 한계 무게 배열 // 오름차순 정렬해야함.
	static List<Integer> jewelWeightArr, jewelPriceArr; // 보석별 무게와 가격 배열
	static int jewelNum, sackNum; //보석 갯수랑 가방 갯수
	
	//methods //해당 무게에서 최대 가격 추출 함수
	static void recur(int index, int inWeight){
		
	}
	
	
	
	
	
	//main
	public static void main(String[] args){
		//보석갯수, 가방갯수 입력받고 보석 무게, 가격, 가방 무게 배열 초기화
		jewelNum = keyboard.nextInt();
		sackNum = keyboard.nextInt();
		jewelWeightArr = new LinkedList<>();
		jewelPriceArr = new LinkedList<>();
		sackWeightArr = new int[sackNum+1];
		//보석 무게와 가격 입력받기
		for(int i=1; i<jewelNum+1; i++){
			jewelWeightArr.add(keyboard.nextInt());
			jewelPriceArr.add(keyboard.nextInt());
		}
		//가방 한계 무게 입력받고 정렬하기 (오름차순)
		for(int i=1; i<sackNum+1; i++){
			sackWeightArr[i] = keyboard.nextInt();
		}
		Arrays.sort(sackWeightArr);
		
		
		
	}
}
