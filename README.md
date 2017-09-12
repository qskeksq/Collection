# Collection
자바 컬렉션 프레임워크 이해

## 1. List 인터페이스

- 순차 구조이기 때문에 항목의 위치를 찾아 접근하는 것은 좋으나 재배치를 도와주는 것일 뿐 빈번한 삭제, 추가는 좋지 않다.
빈번한 추가, 삭제는 LinkedList 를 사용하는 것이 좋다. 다만 끝에 삭제하고 추가하는 것은 순차구조방식이 빠르다.

#### Stack
```java
public static void stack() {
	Stack<Person> stack = new Stack<>();
	stack.push(new Person("홍", 10));
	stack.push(new Person("김", 11));
	stack.push(new Person("신", 12));

	while(!stack.isEmpty()) {
		System.out.println(stack.pop().name);
	}
}
```

## 2. Set 인터페이스

#### hashCode() / equals() 오버라이드
```java
// equals() 오버라이드
@Override
public boolean equals(Object obj) {
	if(obj instanceof Student) {
		Student student = (Student) obj;
		return student.name.equals(name) && student.sno == sno;
	} else {
		return false;
	}
}

// hashCode() 오버라이드
@Override
public int hashCode() {
	return name.hashCode()+sno;
}
```

#### HashSet<>

```java
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
```

#### TreeSet<>
```java
public static void treeSet() {
	TreeSet<Integer> tree = new TreeSet<>();
	tree.add(1); tree.add(2); tree.add(3);
	tree.add(10); tree.add(9); tree.add(5);
	tree.add(4); tree.add(8); tree.add(7);

	System.out.println(tree.first());
	System.out.println(tree.last());
	System.out.println(tree.lower(5));
	System.out.println(tree.higher(5));
	System.out.println(tree.floor(11));
	System.out.println(tree.ceiling(0));

  // 오름, 내림차순 정렬된 값을 NavigableSet으로 리턴
	NavigableSet<Integer> navigableSet = tree.descendingSet();
	for(Integer num : navigableSet) {
		System.out.println(num);
	}
  // 오름, 내림차순 정렬된 값을 NavigableSet으로 리턴
	NavigableSet<Integer> navigableDesSet = navigableSet.descendingSet();
	for(Integer num : navigableDesSet
			) {
		System.out.println(num);
	}

	while(!tree.isEmpty()) {
		System.out.println(tree.pollFirst());
	}
}
```

#### TreeSet Comparator<> 구현
```java
public class DescendingComparator implements Comparator<Fruit> {

	@Override
	public int compare(Fruit p1, Fruit p2) {
		if(p1.age < p2.age) {
			return 1;
		} else if(p1.age == p2.age) {
			return 0;
		} else {
			return -1;
		}
	}
}
```
```java
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
```

#### TreeSet Comparable<> 구현
```java
public class Person implements Comparable<Person>{

	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person person) {
		if(age < person.age) {
			return -1;
		} else if(age == person.age) {
			return 0;
		} else {
			return 1;
		}
	}
}
```



## 3. Map 인터페이스

#### HashMap<>
```java
Map<Student, Integer> map = new HashMap<>();
map.put(new Student("홍길동", 10), 1);
// 키 값이 같으면 map에서는 기존 값을 오버라이드 한다.
map.put(new Student("홍길동", 10), 10);
```
```java
// keySet()으로 꺼내기
Set<Student> keySet = map.keySet();
Iterator<Student> stuIter = keySet.iterator();
while(stuIter.hasNext()) {
	Student student = stuIter.next();
	System.out.println(student.name);
}
```
```java
// Map.Entry<K,V> 로 꺼내기
Set<Map.Entry<Student, Integer>> entrySet = map.entrySet();
Iterator<Map.Entry<Student, Integer>> studentIter = entrySet.iterator();
while(studentIter.hasNext()) {
	Map.Entry<Student, Integer> entry = studentIter.next();
	Student key = entry.getKey();
	int num = entry.getValue();
	System.out.println(key.name+":"+num);
}
```

#### Hashtable
```java
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
```

#### TreeMap
```java
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

  // 키 값오름, 내림차순의  Map.Entry 객체를 NavigableSet 으로 리턴
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
```
