package basic;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.Iterator;
//큐, 스택, 해쉬맵, 링크드 리스트, 리플레이스, 삽입, 삭제, 정렬, 검색, collections, arrays
public class MapPractice {
	//main
	public static void main(String[] args){
		//생성
		int[] arr = new int[10];
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<Integer>();
		Map<Character, Integer> map = new HashMap<>();
		List<Integer> list = new LinkedList<>();

		//삽입 
		queue.add(1); queue.add(2); queue.add(3);
		stack.add(1); stack.add(2); stack.push(3); //stack은 add도 되고 push도 된다.
		map.put('a', 1); map.put('b', 2); map.put('c', 3); //map은 put으로 넣는다!
		list.add(1); list.add(2); list.add(3);
		for(int i=0; i<10; i++){
			arr[i] = i+1;
		}

		//조회
		System.out.println("queue====");

		while(queue.size() != 0) //queue는 poll을 한다. fifo
			System.out.println(queue.poll());
		System.out.println("stack delete ====");
		//stack은 remove로 인덱스 지정 삭제가 가능하다. //큐는 안된다. 
		while(stack.size() != 0) //stack은 pop으로 빼낸다. lifo, 그냥 보려면 peek
			System.out.println(stack.pop()); 
		System.out.println();

		System.out.println("map====");
		System.out.print(map.get('c')); //get으로 key값을 넘겨준다. 그러면 value얻음.
		//삭제
		//stack은 pop으로 삭제가능, 그리고 remove도 된다. 기본적으로 vector라서.
		//queue는 복잡함. 안된다. 그냥 poll 써라.
		//map 순회해보기 //Set로 받는다. 
		map.remove('b');
		System.out.println("map 순회 ======");
		Set<Character> keys = map.keySet();
		for(char c : keys){
			System.out.println(map.get(c));
		}
		Iterator<Character> itr = keys.iterator(); //set에서 iterator를 받아온다. 
		while(itr.hasNext()){
			System.out.println(map.get(itr.next()));
		}
		


	}
}
