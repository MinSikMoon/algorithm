package heap.basic;
//백준 1202번 : 힙 문제였음.
import java.util.Scanner;
import java.util.TreeSet;

public class JewelAndSack {
	//inner class
	class jewel implements Comparable<jewel>{
		public int weight;
		public int price;
		
		public jewel(int weight, int price){
			this.weight = weight;
			this.price = price;
		}
		
		@Override
		public int compareTo(jewel j){
			if(this.weight < j.weight){
				return -1;
			}else if(this.weight == j.weight && this.price < j.price){
				return -1;
			}else if(this.weight == j.weight && this.price == j.price){
				return 0; //완전히 같은 객체라 보면 됨.
			}else{
				return 1;
			}
		}
	}
	
	//members
	static Scanner keyboard = new Scanner(System.in);
	static int limitWeight, jewelNum;
	static TreeSet<jewel> jewelHeap;
	
	//method
	static int logic(int inWeight){
		int beforeWeight = -1;
		int beforePrice = -1;
		//inWeight 전까지 찾는다.
		for(jewel j : jewelHeap){
			if(j.weight > inWeight)
				break;
			
			beforeWeight = j.weight;
			beforePrice = j.price;
		}
		return beforePrice;
	}
	
	public static void main(String[] args){
		//입력받기
		jewelHeap = new TreeSet<>();
		jewelNum = keyboard.nextInt();
		JewelAndSack temp = new JewelAndSack();
		for(int i=0; i<jewelNum; i++){
			int tweight = keyboard.nextInt();
			int tprice = keyboard.nextInt();
			jewelHeap.add(temp.new jewel(tweight, tprice));
		}
		limitWeight = keyboard.nextInt();
		
		for(jewel j : jewelHeap){
			System.out.println(j.weight + ", " + j.price);
		}
		//로직
		System.out.println(logic(limitWeight));
	}
}
