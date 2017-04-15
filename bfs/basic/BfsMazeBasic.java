package bfs.basic;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BfsMazeBasic {
	//members
	static Scanner in = new Scanner(System.in);
	static int length;
	static int[][] maze = {
			{1,1,1,0,0},
			{0,0,1,1,1},
			{1,1,1,0,1},
			{1,0,0,0,1},
			{1,1,1,1,1}
	};	
	
	//method
	static int recur(){
		Queue<Integer> rowQ = new LinkedList<>();
		Queue<Integer> colQ = new LinkedList<>();
		Queue<Integer> levelQ = new LinkedList<>();
		//1. queue에 넣어주기
		rowQ.add(0);
		colQ.add(0);
		levelQ.add(0);
		//2. loop		
		while(true){
			//1. 맨 앞에서 꺼내온다(큐에서는 삭제)
			int row = rowQ.poll();
			int col = colQ.poll();
			int curLevel = levelQ.poll();
			maze[row][col] = 0;
			//2. break filter
			if(row == length-1 && col == length-1){
				return curLevel+1;
			}
			
			//3. logic: 동서남북 넣기
			//3-1. 상
			if(row>0 && maze[row-1][col] != 0){
				rowQ.add(row-1);
				colQ.add(col);
				levelQ.add(curLevel+1);
			}
			//3-2. 하
			if(row<length-1 && maze[row+1][col] != 0){
				rowQ.add(row+1);
				colQ.add(col);
				levelQ.add(curLevel+1);
			}
			//3-3. 좌
			if(col>0 && maze[row][col-1] != 0){
				rowQ.add(row);
				colQ.add(col-1);
				levelQ.add(curLevel+1);
			}
			//3-3. 우
			if(col<length-1 && maze[row][col+1] != 0){
				rowQ.add(row);
				colQ.add(col+1);
				levelQ.add(curLevel+1);
			}
		}
	}
	
	
	
	//main
	public static void main(String[] args){
		length = in.nextInt();
		System.out.println(recur());
		
		
	}
}
