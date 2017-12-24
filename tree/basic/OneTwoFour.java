package tree.basic;

import java.util.Stack;

class OneTwoFour {
	// property
	String resultStr = "";
	boolean isEnd = false;
	Stack<Integer> stack = new Stack<>();

	void recur(int num, int tri, int opt) {
		int cur = num - (tri * opt);
		if (isEnd || cur < 0)
			return;
		if (opt != 0)
			stack.push(opt);
		if (cur == 0) {
			for (int i = stack.size() - 1; i >= 0; i--) {
				if (stack.elementAt(i) == 3) {
					resultStr += "4";
				} else {
					resultStr += stack.elementAt(i);
				}
			}

			isEnd = true;
			return;
		}
		int nextTri = tri * 3;
		if (opt == 0)
			nextTri = 1;
		recur(cur, nextTri, 1);
		recur(cur, nextTri, 2);
		recur(cur, nextTri, 3);
		stack.pop();
	}

	public String change124(int n) {
		recur(n, 1, 0);
		return resultStr;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		OneTwoFour oneTwoFour = new OneTwoFour();
		System.out.println(oneTwoFour.change124(10));
	}
}