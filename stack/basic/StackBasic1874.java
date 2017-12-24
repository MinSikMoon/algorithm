package stack.basic;

import java.util.Scanner;
import java.util.Stack;

public class StackBasic1874 {

	public static void main(String[] args) {
		// properties
		Scanner in = new Scanner(System.in);
		int arrLen = in.nextInt(); // 총 입력 갯수, 배열 길이
		int[] sArr = new int[arrLen];
		int[] tArr = new int[arrLen];
		int[] tArrClone = new int[arrLen];
		char[] resultArr = new char[arrLen];

		int sIdx = 0;
		int tIdx = 0;
		int checkIdx = 0;
		int resultIdx = 0;
		int s, t;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arrLen; i++) {
			sArr[i] = i + 1;
			int temp = in.nextInt();
			tArr[i] = temp;
			tArrClone[i] = temp;
		}

		// logic
		while (sIdx < arrLen) {
			s = sArr[sIdx];
			t = tArr[tIdx];

			if (s <= t) {
				stack.push(s);
				sIdx++;
				resultArr[resultIdx++] = '+';
			} else {
				int poped = stack.pop();
				if (poped == tArrClone[checkIdx]) {
					resultArr[resultIdx++] = '-';
					checkIdx++;
					tIdx++;
				} else {
					System.out.println("NO");
					return;
				}

			}
		}

		while (checkIdx < arrLen) {
			int poped = stack.pop();
			if (poped == tArrClone[checkIdx]) {
				resultArr[resultIdx++] = '-';
			} else {
				System.out.println("NO");
				return;
			}
		}
		
		for(char c : resultArr){
			System.out.println(c);
		}

	}

}
