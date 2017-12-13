package dp.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Square4095 {
	
	public static int min(int a, int b, int c){
		int min = (a>b)?b:a;
		min = (min>c)?c:min;
		return min;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> result = new ArrayList<>();
		
		while(true){
			int r = sc.nextInt();
			int c = sc.nextInt();
			if(r == 0 && c == 0)
				break;
			
			//1. 입력부
			int max = 0;
			int[][] arr = new int[r][c];
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					arr[i][j] = sc.nextInt();
				}
			}
			
			//2. 
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					int cur = arr[i][j];
					if(i == 0 || j == 0){
						max = (cur>max)?cur:max;
						continue;
					}
					if(cur == 1){
						arr[i][j] = min(arr[i-1][j-1],arr[i][j-1],arr[i-1][j])+1;
						cur = arr[i][j];
					}
					max = (cur>max)?cur:max; 
				}
			}
			result.add(max);
		}
		
		for(int i : result)
			System.out.println(i);
		
		
	}

}
