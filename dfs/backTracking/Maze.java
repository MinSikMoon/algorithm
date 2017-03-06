package dfs.backTracking;

import java.util.Scanner;

public class Maze {
	//목적 : 주어진 미로에서 출구로 가는 경로를 모두 찾는다.
	//0. properties
	static int[][] maze = {
			{1,1,1,0,0},
			{0,0,1,1,1},
			{1,1,1,0,1},
			{1,0,0,0,1},
			{1,1,1,1,1}
	};
	static int wayCnt = 0;
		
	//1. inner Method
	public static void DfsMaze(int x, int y, int mazeLength){
		int terminalIndex = mazeLength-1;
		//1. 목표 로직/ 말단 로직/ 말단에서 무슨일을 하고 return 해주어야 하는가
		if(x == terminalIndex && y == terminalIndex){
			wayCnt++;
			return;
		}
		
		//2. 자식 call을 하기 전에 어떤 로직이 있어야 하는가?
		maze[x][y] = 0;  //일단 자신을 0으로 만들어 자식에서 검색 못하도록 만든다.
		
		//3. 말단 로직이 아니라면? -> 재귀적으로 다음 단계를 call 해야 한다. 
		//-> 몇가지 방향으로 call할수(뻗어나갈 수) 있는가? : 동서남북
		//-> call 하기 전에 어떤 처리를 해주어야 하는가?
		// 동
		if((x+1) < mazeLength && maze[x+1][y] != 0) DfsMaze(x+1, y, mazeLength);
		// 서
		if((x-1) > -1 && maze[x-1][y] != 0) DfsMaze(x-1, y, mazeLength);
		// 남
		if((y+1) < mazeLength && maze[x][y+1] != 0) DfsMaze(x, y+1, mazeLength);
		// 북
		if((y-1) > -1 && maze[x][y-1] != 0) DfsMaze(x, y-1, mazeLength);
		
		//4. 이제 자식 노드들이 끝나고 다시 자신으로 돌아왔을 때 어떤 일을 해줘야 하는가?
		maze[x][y] = 1; //다시 1로 되돌려 놓고 끝.
	}
		
	//////////////////////////MAIN//////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//0. members
		int mazeLength; //한변의 길이가 몇인 메이즈인가
		
		//1. 입력부
		Scanner keyboard = new Scanner(System.in);
		System.out.print("type mazeLength: ");
		mazeLength = Integer.parseInt(keyboard.nextLine());
		
		//2. DfsMaze() 호출
		DfsMaze(0,0, mazeLength);
		
		//3. 경로 수 출력
		System.out.println("경로 수: " + wayCnt);
		
	}

}
