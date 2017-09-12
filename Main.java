import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		stack();

//		hashSet();
//
//		hashMap();
//		
//		hashTable();
//		
//		treeSet();
//		
//		treeSet2();
//		
//		treeSet3();
//		
//		treeSet4();
//		
//		treeMap();
		
		
	}
	/**
	 * 스택
	 */
	public static void stack() {
		Stack<Person> stack = new Stack<>();
		stack.push(new Person("홍", 10));
		stack.push(new Person("김", 11));
		stack.push(new Person("신", 12));
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().name);
		}
	}
	
	/**
	 * hashSet
	 */
	public static void hashSet() {
		// HashSet
		Set<Member> set = new HashSet<>();
		set.add(new Member("홍길동", 10));
		set.add(new Member("홍길동", 10));
		set.add(new Member("홍길동", 11));
		Iterator<Member> memberIter = set.iterator();
		while(memberIter.hasNext()) {
			Member member = memberIter.next();
			System.out.println(member.name +":"+member.age);
		}
	}
	
	/**
	 * hashMap
	 */
	public static void hashMap() {
		Map<Student, Integer> map = new HashMap<>();
		map.put(new Student("홍길동", 10), 1);
		// 키 값이 같으면 map에서는 기존 값을 오버라이드 한다.
		map.put(new Student("홍길동", 10), 10);
		
		// keySet()으로 꺼내기
		Set<Student> keySet = map.keySet();
		Iterator<Student> stuIter = keySet.iterator();
		while(stuIter.hasNext()) {
			Student student = stuIter.next();
			System.out.println(student.name);
		}
		
		// Map.Entry<K,V> 로 꺼내기
		Set<Map.Entry<Student, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<Student, Integer>> studentIter = entrySet.iterator();
		while(studentIter.hasNext()) {
			Map.Entry<Student, Integer> entry = studentIter.next();
			Student key = entry.getKey();
			int num = entry.getValue();
			System.out.println(key.name+":"+num);
		}
	}
	
	/**
	 * hashtable
	 */
	public static void hashTable() {
		Map<String, Integer> table = new Hashtable<>();
		table.put("spring", 1);
		table.put("winter", 2);
		table.put("fall", 3);
		table.put("summer", 4);
		
		if(table.containsKey("spring")) {
			if(table.get("spring") == 1){
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패");
			}
		}
	}
	
	/**
	 * treeSet
	 */
	public static void treeSet() {
		TreeSet<Integer> tree = new TreeSet<>();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(10);
		tree.add(9);
		tree.add(5);
		tree.add(4);
		tree.add(8);
		tree.add(7);
		
		System.out.println(tree.first());
		System.out.println(tree.last());
		System.out.println(tree.lower(5));
		System.out.println(tree.higher(5));
		System.out.println(tree.floor(11));
		System.out.println(tree.ceiling(0));
		
		NavigableSet<Integer> navigableSet = tree.descendingSet();
		for(Integer num : navigableSet) {
			System.out.println(num);
		}
		NavigableSet<Integer> navigableDesSet = navigableSet.descendingSet();
		for(Integer num : navigableDesSet
				) {
			System.out.println(num);
		}
		
		while(!tree.isEmpty()) {
			System.out.println(tree.pollFirst());
		}
	}
	
	/**
	 * treeSet2
	 */
	public static void treeSet2() {
		TreeSet<String> tree = new TreeSet<>();
		tree.add("abcde");
		tree.add("bcdef");
		tree.add("cdefg");
		tree.add("defgh");
		tree.add("efghi");
		
		NavigableSet<String> set1 = tree.subSet("a", true, "e", true);
		
		for(String str : set1) {
			System.out.println(str);
		}	
	}
	
	/**
	 * treeSet-Comparable<T>
	 */
	public static void treeSet3() {
		TreeSet<Person> tree = new TreeSet<>();
		tree.add(new Person("홍길동", 45));
		tree.add(new Person("김자바", 25));
		tree.add(new Person("박지원", 31));
		
		Iterator<Person> iterator = tree.iterator();
		while(iterator.hasNext()) {
			// 아하 iterator는 next()가 호출될 때마다 하나씩 다른 값을 리턴해 주는군!. 객체에 넣어서 꺼내 사용해야 한다.
			Person person = iterator.next();
			System.out.println(person.name+":"+person.age);
		}
		
	}
	
	/**
	 * treeSet4 - Comparator<T>
	 */
	public static void treeSet4() {
		// DescendingComparator()을 안 해주면 런타임 오류가 생긴다.(바로 오류가 뜨지는 않음)
		TreeSet<Fruit> tree = new TreeSet<>(new DescendingComparator());
		tree.add(new Fruit("홍길동", 45));
		tree.add(new Fruit("김자바", 25));
		tree.add(new Fruit("박지원", 31));
		
		Iterator<Fruit> iterator = tree.iterator();
		while(iterator.hasNext()) {
			Fruit fruit = iterator.next();
			System.out.println(fruit.name+":"+fruit.age);
		}
		
		NavigableSet<Fruit> navigable = tree.descendingSet();
		for(Fruit fruit : navigable) {
			System.out.println(fruit.name+":"+fruit.age);
		}
	}
	
	/**
	 * treeMap
	 */
	public static void treeMap() {
		TreeMap<Integer, String> tree = new TreeMap<>();
		tree.put(new Integer(87), "바울");
		tree.put(new Integer(98), "마태");
		tree.put(new Integer(75), "요한");
		tree.put(new Integer(95), "마가");
		tree.put(new Integer(80), "베드로");
		tree.put(new Integer(82), "도마");
		
		System.out.println(tree.firstEntry().getKey()+":"+tree.firstEntry().getValue());
		System.out.println(tree.lastEntry().getKey()+":"+tree.lastEntry().getValue());
		System.out.println(tree.lowerEntry(80).getKey()+":"+tree.lowerEntry(80).getValue());
		System.out.println(tree.higherEntry(90).getKey()+":"+tree.higherEntry(90).getValue());
			
		NavigableMap<Integer, String> map = tree.descendingMap();
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		for(Map.Entry<Integer, String> entry : set) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		NavigableMap<Integer, String> map2 = map.descendingMap();
		Set<Map.Entry<Integer, String>> set2 = map2.entrySet();
		Iterator<Map.Entry<Integer, String>> iterator = set2.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getKey()+":"+iterator.next().getValue());
		}
	}
}

