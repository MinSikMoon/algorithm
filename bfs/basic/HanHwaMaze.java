package bfs.basic;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


class point{
	public int r,c;
	public point(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class HanHwaMaze {
	static int row,col;
	static String[][] maze = {
			{"0","1","1","1","1"},
			{"0","a","b","a","b"},
			{"0","0","c","0","0"},
			{"0","0","0","0","0"}
	};
	
	//method
	static void bfs(int startR, int startC){
		int cnt = 0;
		Queue<point> q= new LinkedList<>();
		//1. 시작점을 큐에 넣는다.
		q.add(new point(startR, startC));
		//1. 글자체크 배열을 리셋한다. 
		
		
		//1. 큐가 빌때까지 돌린다.
		while(q.size() != 0){
			int[] check = {1,1,1}; //순서대로 a,b,c
			point cur = q.poll();
			//2. 좌표 받아온다. 
			int r = cur.r; 
			int c = cur.c;
			//2.2 팔방으로 돌면서 체크한다. 
			//상// 일단 맞으면 q에 넣어주고 ㅇ
			if(r> 0){ //갈수 있는지 체크 
				String temp = maze[r-1][c];
				if(temp.equals("0")){ //갈수 있는것 q에 넣고
					q.add(new point(r-1, c));
				}else if(temp.equals("a")){
					check[0] = 0;
				}else if(temp.equals("b")){
					check[1] = 0;
				}else if(temp.equals("c")){
					check[2] = 0;
				}
				
			}
			//우상//
			if(r> 0 && c<col-1){ //갈수 있는지 체크 
				String temp = maze[r-1][c+1];
				if(temp.equals("0")){ //갈수 있는것 q에 넣고
					q.add(new point(r-1, c+1));
				}else if(temp.equals("a")){
					check[0] = 0;
				}else if(temp.equals("b")){
					check[1] = 0;
				}else if(temp.equals("c")){
					check[2] = 0;
				}
				
			}
			//우//
			if( c<col-1){ //갈수 있는지 체크 
				String temp = maze[r][c+1];
				if(temp.equals("0")){ //갈수 있는것 q에 넣고
					q.add(new point(r, c+1));
				}else if(temp.equals("a")){
					check[0] = 0;
				}else if(temp.equals("b")){
					check[1] = 0;
				}else if(temp.equals("c")){
					check[2] = 0;
				}
				
			}
			//우하//
			if(r< row-1 && c<col-1){ //갈수 있는지 체크 
				String temp = maze[r+1][c+1];
				if(temp.equals("0")){ //갈수 있는것 q에 넣고
					q.add(new point(r+1, c+1));
				}else if(temp.equals("a")){
					check[0] = 0;
				}else if(temp.equals("b")){
					check[1] = 0;
				}else if(temp.equals("c")){
					check[2] = 0;
				}
				
			}
			//하//
			if(r< row-1){ //갈수 있는지 체크 
				String temp = maze[r+1][c];
				if(temp.equals("0")){ //갈수 있는것 q에 넣고
					q.add(new point(r+1, c));
				}else if(temp.equals("a")){
					check[0] = 0;
				}else if(temp.equals("b")){
					check[1] = 0;
				}else if(temp.equals("c")){
					check[2] = 0;
				}
				
			}
			//좌하//
			if(r < row-1 && c>0){ //갈수 있는지 체크 
				String temp = maze[r-1][c-1];
				if(temp.equals("0")){ //갈수 있는것 q에 넣고
					q.add(new point(r-1, c-1));
				}else if(temp.equals("a")){
					check[0] = 0;
				}else if(temp.equals("b")){
					check[1] = 0;
				}else if(temp.equals("c")){
					check[2] = 0;
				}
				
			}
			//좌//
			if( c>0){ //갈수 있는지 체크 
				String temp = maze[r][c-1];
				if(temp.equals("0")){ //갈수 있는것 q에 넣고
					q.add(new point(r, c-1));
				}else if(temp.equals("a")){
					check[0] = 0;
				}else if(temp.equals("b")){
					check[1] = 0;
				}else if(temp.equals("c")){
					check[2] = 0;
				}
				
			}
			//좌상
			if(r> 0 && c>0){ //갈수 있는지 체크 
				String temp = maze[r-1][c-1];
				if(temp.equals("0")){ //갈수 있는것 q에 넣고
					q.add(new point(r-1, c-1));
				}else if(temp.equals("a")){
					check[0] = 0;
				}else if(temp.equals("b")){
					check[1] = 0;
				}else if(temp.equals("c")){
					check[2] = 0;
				}
				
			}
			System.out.println("["+r + "," +c+"]에서 " + check[0] + "," + check[1] + ","+ check[2]);
			int test = 0;
			for(int i=0; i<3; i++){
				test += check[i];
			}
			if(test == 0)
				cnt++;
			
			maze[r][c] = "1";
		}
		
		System.out.println(cnt);
	}
	
	
	//main
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		row = in.nextInt();
		col = in.nextInt();
		bfs(0,0);
	}

}
