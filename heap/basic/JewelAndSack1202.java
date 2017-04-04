package heap.basic;
import java.util.Scanner;
import java.util.TreeSet;

class Jewel implements Comparable<Jewel>{
	public int weight;
	public int price;
	public int index; //구별용
	
	public Jewel(int index, int weight, int price){
		this.index = index;
		this.weight = weight;
		this.price = price;
	}
	
	@Override //가격으로만 정리한다. //set은 중복을 허용하지 않으니 index를 하나 더 넣어준다. 
	public int compareTo(Jewel j){
		if(this.price == j.price && this.weight == j.weight && this.index == j.index){
			return 0;
		}else if(this.price < j.price){
			return 1;
		}else if(this.price == j.price && this.weight < j.weight){
			return 1;
		}
		
		return -1;
	}
}

public class JewelAndSack1202 {
	//members
	static Scanner keyboard = new Scanner(System.in);
	static int sackNum, jewelNum;
	static TreeSet<Jewel> jewelHeap = new TreeSet<>();
	static TreeSet<Integer> sackWeightHeap = new TreeSet<>();
	static int resultPriceSum = 0;
	
	//main
	public static void main(String[] args){
		//1. 보석갯수, 가방 갯수 입력받기
		jewelNum = keyboard.nextInt();
		sackNum = keyboard.nextInt();
		//2. 보석 무게와 가격 입력받기
		for(int i=0; i<jewelNum; i++){
			int tempWeight = keyboard.nextInt();
			int tempPrice = keyboard.nextInt();
			jewelHeap.add(new Jewel(i, tempWeight, tempPrice));
		}
		
	/*	for(Jewel j:jewelHeap){
			System.out.println(j.index + ", " + j.weight + ", " + j.price);
		}*/
		//3. 가방 한계 무게 입력받기
		for(int i=0; i<sackNum; i++){
			sackWeightHeap.add(keyboard.nextInt());
		}
		
		
		//4. 로직
		//내림 차순 가격으로 정리되었으므로 하나씩 내려가면서 무게를 대조한다.
		for(int sackWeight : sackWeightHeap){
			for(Jewel j : jewelHeap){
				if(j.weight <= sackWeight){
					resultPriceSum += j.price;
					jewelHeap.remove(j);
					break;
				}
			}
		}
		
	
		
		System.out.println(resultPriceSum);
		
	}
}
