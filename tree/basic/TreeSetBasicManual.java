package tree.basic;

import java.util.NavigableSet;
import java.util.TreeSet;

//TreeSet의 기본 사용법을 익혀본다. 
public class TreeSetBasicManual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<PersonNameSort> nameTreeSet = new TreeSet<>();
		TreeSet<PersonAgeSort> ageTreeSet = new TreeSet<>();
		
		//set에 원소 넣기
		nameTreeSet.add(new PersonNameSort(29, "minsik moon"));
		nameTreeSet.add(new PersonNameSort(59, "jongho moon"));
		nameTreeSet.add(new PersonNameSort(31, "youngseob moon"));
		nameTreeSet.add(new PersonNameSort(57, "boonja lee"));
		
		ageTreeSet.add(new PersonAgeSort(29, "minsik moon"));
		ageTreeSet.add(new PersonAgeSort(59, "jongho moon"));
		ageTreeSet.add(new PersonAgeSort(31, "youngseob moon"));
		ageTreeSet.add(new PersonAgeSort(57, "boonja lee"));
		
		//정렬하기 : Integer, Double과 같은 숫자타입과 String은 Comparable이 구현되어있다. 
		//내가 만든 User defined 객체도 Comparable을 구현하면 얼마든지 가능하다.
		//만약에 comparable을 구현하지 않은 객체의 경우 생성자로 comparator 객체를 만들어서 던져준다. 
		System.out.println("==========Name sort==========");
		for(PersonNameSort person : nameTreeSet){
			System.out.println(person.name + ": " + person.age + "세");
		}
		System.out.println("========Age sort=========");
		for(PersonAgeSort person : ageTreeSet){
			System.out.println(person.name + ": " + person.age + "세");
		}
		
		//정렬 순서를 바꿔서 출력하고 싶다면 descendingSet을 만든다.
		NavigableSet<PersonNameSort> reversedNameTreeSet = nameTreeSet.descendingSet();
		System.out.println("==========reversed Name sort==========");
		for(PersonNameSort person : reversedNameTreeSet){
			System.out.println(person.name + ": " + person.age + "세");
		}
		
		//lower(), higher() : 파라미터로 주어진 객체보다 바로 아래, 위 객체 리턴해준다. //boonja lee가 나옴// 즉 tree level이 낮은 쪽 리턴 -> 부모 노드 리턴
		System.out.println("jongho moon 바로 아래 객체(정렬상 앞쪽, 부모 노드): " + nameTreeSet.lower(new PersonNameSort(59, "jongho moon")).name);
		System.out.println("jongho moon 바로 아래 객체(정렬상 뒷쪽, 자식 노드): " + nameTreeSet.higher(new PersonNameSort(59, "jongho moon")).name);
	}

}


//tree에 넣을 객체 선언 : 이름 순 정렬
class PersonNameSort implements Comparable<PersonNameSort>{
	//properties
	public int age;
	public String name;
	
	//constructor
	public PersonNameSort(int age, String name){
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(PersonNameSort inPerson) {
		int compareNum = this.name.compareTo(inPerson.name);
		
		if(compareNum < 0) return -1;
		if(compareNum == 0) return 0;
		
		return 1;
	}
}
//: 나이순 정렬
class PersonAgeSort implements Comparable<PersonAgeSort>{
	//properties
	public int age;
	public String name;
	
	//constructor
	public PersonAgeSort(int age, String name){
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(PersonAgeSort inPerson) {
		if(this.age < inPerson.age) return -1;
		if(this.age == inPerson.age) return 0;
		
		return 1;
	}
}
