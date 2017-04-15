package dfs.backTracking;
import java.util.Scanner;


public class MazeRetryDfs {
	//members
	static Scanner in = new Scanner(System.in); 
	static int length;
	static int wayCnt = 0;
	static int[][] maze = {
			{1,1,1,0,0},
			{0,0,1,1,1},
			{1,1,1,0,1},
			{1,0,0,0,1},
			{1,1,1,1,1}
	};
	
	//method
	static void recur(int rowIdx, int colIdx){
		//terminal filter
		if(rowIdx == length-1 && colIdx == length-1){
			wayCnt++; //경로 숫자 증가
			maze[rowIdx][colIdx] = 1; //다시 제자리로 돌려놓음.
			return;
		}
		
		//preLogic
		maze[rowIdx][colIdx] = 0; //방문 막아놓기
		
		//body logic
		//상하좌우
		//상 //주의사항 : &&의 연산순서가 왼->오 이므로 순서를 잘지킬것!
		if( rowIdx > 0 && maze[rowIdx-1][colIdx] != 0){
			recur(rowIdx-1, colIdx);
		}
		//하
		if(rowIdx < length-1 && maze[rowIdx+1][colIdx] != 0 ){
			recur(rowIdx+1, colIdx);
		}
		//좌
		if(colIdx > 0 &&  maze[rowIdx][colIdx-1] != 0){
			recur(rowIdx, colIdx-1);
		}
		//우
		if(colIdx < length-1 && maze[rowIdx][colIdx+1] != 0){
			recur(rowIdx, colIdx+1);
		}
		
		//after logic
		maze[rowIdx][colIdx] = 1;
	}
	
	//main
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		length = in.nextInt();
		recur(0,0);
		System.out.println(wayCnt);

	}

}
