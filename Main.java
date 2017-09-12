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
	 * ����
	 */
	public static void stack() {
		Stack<Person> stack = new Stack<>();
		stack.push(new Person("ȫ", 10));
		stack.push(new Person("��", 11));
		stack.push(new Person("��", 12));
		
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
		set.add(new Member("ȫ�浿", 10));
		set.add(new Member("ȫ�浿", 10));
		set.add(new Member("ȫ�浿", 11));
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
		map.put(new Student("ȫ�浿", 10), 1);
		// Ű ���� ������ map������ ���� ���� �������̵� �Ѵ�.
		map.put(new Student("ȫ�浿", 10), 10);
		
		// keySet()���� ������
		Set<Student> keySet = map.keySet();
		Iterator<Student> stuIter = keySet.iterator();
		while(stuIter.hasNext()) {
			Student student = stuIter.next();
			System.out.println(student.name);
		}
		
		// Map.Entry<K,V> �� ������
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
				System.out.println("�α��� ����");
			} else {
				System.out.println("�α��� ����");
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
		tree.add(new Person("ȫ�浿", 45));
		tree.add(new Person("���ڹ�", 25));
		tree.add(new Person("������", 31));
		
		Iterator<Person> iterator = tree.iterator();
		while(iterator.hasNext()) {
			// ���� iterator�� next()�� ȣ��� ������ �ϳ��� �ٸ� ���� ������ �ִ±�!. ��ü�� �־ ���� ����ؾ� �Ѵ�.
			Person person = iterator.next();
			System.out.println(person.name+":"+person.age);
		}
		
	}
	
	/**
	 * treeSet4 - Comparator<T>
	 */
	public static void treeSet4() {
		// DescendingComparator()�� �� ���ָ� ��Ÿ�� ������ �����.(�ٷ� ������ ������ ����)
		TreeSet<Fruit> tree = new TreeSet<>(new DescendingComparator());
		tree.add(new Fruit("ȫ�浿", 45));
		tree.add(new Fruit("���ڹ�", 25));
		tree.add(new Fruit("������", 31));
		
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
		tree.put(new Integer(87), "�ٿ�");
		tree.put(new Integer(98), "����");
		tree.put(new Integer(75), "����");
		tree.put(new Integer(95), "����");
		tree.put(new Integer(80), "�����");
		tree.put(new Integer(82), "����");
		
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

