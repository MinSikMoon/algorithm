package dfs.backTracking;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class DfsBfsGraphBasic1260 {
	//members: dfs
	static Scanner in = new Scanner(System.in);
	static int edgeNum, pathNum, startEdge;
	static int[][] pathArr, copiedArr;
	static boolean[] isVisited;
	//members: bfs
	static Queue<Integer> fromQ, toQ;
	//method1 : dfs
	static void dfs(int curEdge, int[][] pathArr){
		//1. 방문기록한다.
		isVisited[curEdge] = true;
		System.out.print(curEdge + " ");
		//2. curEdge와 연결된 간선살피기
		for(int to = 1; to<=edgeNum; to++){
			if(isVisited[to] == false && pathArr[curEdge][to] == 1){
				pathArr[curEdge][to] = 0;
				pathArr[to][curEdge] = 0;
				isVisited[to] = true;
				dfs(to, pathArr);
			}
		}
	}
	//method2 : bfs
	static void bfs(int startEdge, int[][] pathArr){
		toQ.add(startEdge);
		int visitCnt = 0;
		
		while(visitCnt != edgeNum){
			int curEdge;
			while(true){
				curEdge = toQ.poll();
				if(!isVisited[curEdge])
					break;
			}
			
			isVisited[curEdge] = true;
			System.out.print(curEdge + " ");
			for(int to=1; to<=edgeNum; to++){
				if(pathArr[curEdge][to] == 1 && isVisited[to] == false){
					toQ.add(to);
					pathArr[curEdge][to] = 0;
					pathArr[to][curEdge] = 0;
				}
			}
			visitCnt++;
		}
		
		
		
	}
	
	
	public static void main(String[] args){
		//input
		edgeNum = in.nextInt();
		pathNum = in.nextInt();
		startEdge = in.nextInt();
		pathArr = new int[edgeNum+1][edgeNum+1]; //0으로 자동초기화
		copiedArr = new int[edgeNum+1][edgeNum+1]; //0으로 자동초기화
		isVisited = new boolean[edgeNum+1]; //false로 자동초기화
		
		fromQ = new LinkedList<>();
		toQ = new LinkedList<>();
		
		for(int i=0; i<pathNum; i++){
			int from = in.nextInt();
			int to = in.nextInt();
			pathArr[from][to] = 1;
			pathArr[to][from] = 1;
			copiedArr[from][to] = 1;
			copiedArr[to][from] = 1;
		}
		
		dfs(startEdge, pathArr);
		System.out.println();
		isVisited = new boolean[edgeNum+1];
		bfs(startEdge, copiedArr);
		
	}
	
	
	
	
}
