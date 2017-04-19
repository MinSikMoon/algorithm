package bfs.basic;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class point{
	public int r,c;
	public point(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class Tomato7576 {
	//members

	//main
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		//미로 만들기, 행렬 입력
		int col = in.nextInt();
		int row = in.nextInt();
		int[][] maze = new int[row][col];
		boolean isAllZero = true;
		boolean isAllOne = true;
		Queue<point> savedList = new LinkedList<>();
		Queue<point> startList = new LinkedList<>();
		int cnt = 0;
		//미로 입력받으면서 1과 0에 대한 처리 해준다. 
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				int temp = in.nextInt();
				if(temp == 0){
					if(isAllOne)
						isAllOne = false;
				}
				if(temp == 1){
					if(isAllZero)
						isAllZero = false;
					savedList.add(new point(i,j));
				}
				maze[i][j] = temp;
			}
		}
	
		//필터 : 모두 0이거나 1인 경우
		if(isAllOne){
			System.out.println(0);
			return;
		}
		if(isAllZero){
			System.out.println(-1);
			return;
		}
		boolean check = true; //더 나아갈 곳이 없는 상태일 때를 체크
		//본 로직 : bfs
		while(check){
			check = false; //일단 이걸로 초기화 //하나라도 들어가면 true가 된다. 
			//1. startList에 옮겨 담는다.
			while(savedList.size() != 0)
				startList.add(savedList.poll());
			//2. 이제 startList에서 한개씩 꺼내서 savedList로 동서남북 체크한다. 
			while(startList.size() != 0){
				point curPoint = startList.poll(); //하나 빼본다. //이제 동서남북
				int cRow = curPoint.r;
				int cCol = curPoint.c; 
				//상
				if(cRow > 0 && maze[cRow-1][cCol] == 0){
					savedList.add(new point(cRow-1, cCol));
					maze[cRow-1][cCol] = 1;
					check = true;
				}

				//하
				if(cRow < (row-1) && maze[cRow+1][cCol] == 0){
					savedList.add(new point(cRow+1, cCol));
					maze[cRow+1][cCol] = 1;
					check = true;
				}

				//좌
				if(cCol > 0 && maze[cRow][cCol-1] == 0){
					savedList.add(new point(cRow, cCol-1));
					maze[cRow][cCol-1] = 1;
					check = true;
				}

				//우
				if(cCol < (col-1) && maze[cRow][cCol+1] == 0){
					savedList.add(new point(cRow, cCol+1));
					maze[cRow][cCol+1] = 1;
					check = true;
				}

			}
		
			//다 끝나면 카운트 올려준다. 
			if(check)
				cnt++;
		}
		//카운트 출력
		System.out.println(cnt);

	}
}
