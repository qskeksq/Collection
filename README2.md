# Collection
자바 컬렉션 프레임워크 이해

## 정의
- #### 자료구조  
데이터를 효율적으로 사용하도록 구조적으로 저장하고 관리하는 것. 즉, 데이터 추가, 삭제, 검색, 업뎃에 자료를 보다 효율적으로 관리한다는 말이다.

- #### 알고리즘  
표현되거나 저장된 데이터를 대상으로 문제를 해결하는 방법

- #### 컬렉션
자료 관리 기술. java.util. 패키지에 자료구조에 사용하는 1.인터페이스 2. 인터페이스 구현 클래스 3. 관련 알고리즘을 정의해 놓은 것, 이것을 컬렉션 프레임워크라고 한다.

    - 인터페이스 : 공통으로 제공해야 하는 연산 정의. 구체적인 구현은 구현 클래스에 위임. 즉, 구현 클래스가 지켜야 하는 최소한의 공통된 기능을 정의. 구현 클래스를 사용할 수 있는데도 굳이 인터페이스로 정의하는 의미를 잘 파악할 것!

    - 알고리즘 : 메소드

- #### 프레임워크
구체적이로 체계화된 API 를 제공한다는 의미. 즉, 자료구조에 상관없이 추가는 add(), 삭제는 remove() 같이 표준화된 접근 방식을 제공하는 것을 프레임워크라 한다. 즉, 내부의 구체적인 기술을 모르더라도 사용할 수 있다는 말.

## List 인터페이스

### 1. ArrayList - 순차 구조 방식

- #### 언제 사용하는가
순차 구조이기 때문에 항목의 위치를 찾아 접근하는 것은 좋으나 재배치를 도와주는 것일 뿐 빈번한 삭제, 추가는 좋지 않다.
빈번한 추가, 삭제는 LinkedList 를 사용하는 것이 좋다. 다만 끝에 삭제하고 추가하는 것은 순차구조방식이 빠르다.

- ### 반복자(iterator 패턴) 사용
  1. 객체 내부 표현 방식을 모르고도 객체 집합의 각 항목에 접근할 수 있다.
  2. 객체 집합을 순회하는 다양한 방법을 지원한다.
  3. 전체 객체를 대상으로 '한 번씩' 반복해서 가져오는 반복자를 리턴한다.


### 2. Vector - ThreadSafe(Synchronized) ArrayList

- #### 언제 사용하는가?
동기화된 ArrayList 를 사용할 경우

- #### 구현 방식
List<E> list = new Vector<>();

### 3. LinkedList - 연결 구조 방식

- #### 언제 사용하는가?
ArrayList 인데 중간에서 추가와 삭제가 빈번하게 발생하는 경우. 다만 순차 구조나 이진검색보다 검색에 오래 걸린다.

- #### 구현 방식
List<E> list = new LinkedList<>();

- #### 결론
위치를 이용하여 적븐하는 경우가 많으면 ArrayList, 항목의 삽입과 삭제가 많다면 LinkedList 사용

### 4. Stack
- LIFO
- peek, pop, push, empty, search
- Stack<> stack = new Stack<>();

### 5. Queue
- FIFO
- offer, peek, poll
- Queue<> q = new LikedList<>();


## Set 인터페이스(Collection 인터페이스)

- 해시 테이블을 이용해 구현한다. 해싱은 키 값을 비교하여 찾는 검색이 아니라 산술 연산을 이용해 키가 있는 위치를 계산하여 바로 찾아가는 검색 방법. 키 값을 항목의 위치로 변환하는 함수를 해싱 함수라고 한다. 데이터를 저장할 테이블을 준비하고, 해싱 함수에 의해 계산된 주소의 위치에 항목을 저앙한다. 이 값을 해시테이블이라고 한다.
- 해싱은 문자열을 원래보다 짧고 상징적인 값이나 키로 변환해 검색할 때 사용한다. 원래 값보다 빠르기 때문. 데이터베이스가 대표적이다
- "abc" 를 찾는다면 먼저 객체의 해시 코드를 계산하고 테이블의 크기에 맞추어 나머지 연산을 수행한 후 결과로 나오는 값을 테이블의 인덱스로 사용

### 1. HashSet
- hashCode() 오버라이딩이 핵심이다 : 객체를 비교할 때 해시코드를 사용하기 때문
- 구현 : Set<> set = new HashSet<>();
- 원리 : hashCode() 비교 - >equals() 비교 -> 저장 안 함
- hashCode(), eqauls() 오버라이딩 연습

### 2. LinkedHashSet
- 중복처리+순서

### 3. TreeSet
- 검색에 특화된 Set 인터페이스 구현하기 위해 존재한다.
- Comparable이나 Comparator 인터페이스를 구현하는 클래스의 객체를 생성자의 매개변수로 주어 TreeSet 객체 생성
- 객체를 저장하면 자동으로 부모값과 비교해서 낮은 것은 왼쪽 자식 노드에 높은 것은 오른족 자식 노드에 저장한다.
- TreeSet<E> tree = new TreeSet<>();
- first(), last(), lower(E e), higher(E e), floor(E e), Ceiling(E e), pollFirst(), pollLast();
- #### 꺼내는 방법
1. Iterator
2. NavigableSet<>

- #### Comparator<T>
DescendingComparator, AscendingComparator 클래스에 구현. TreeSet<>(....) 인자로 넣어줌
- #### Comparable<T>
데이터 객체에 구현

## Map 인터페이스

- Map<키, 값> map = new HashMap<>();
- 객채 꺼내는 방법1 : map.get(k);
- 객체 꺼내는 방법2 : keySet(), entrySet() -> Iterator<K>, Iterator<Map.Entry<K, V>>
Set<K> keySet = map.keySet();
Iterator iterator = keySet.iterator();
iterator.next();
- 키, 값 전체 꺼내는 방법
Set<Map.Entry<k, v>> entrySet = map.entrySet();
Iterator iterator = entrySet.iterator();
iterator.next();


### 1. HashMap
- 키 값을 해시코스로 사용하기 때문에 hashCode()를 잘 구현할수록 더 좋은 성능을 보인다.
- 키 값은 중복이 안 됨. set 저장방식처럼 hashCode() 와 equals() 를 통해 키 값 중복 검사

### 2. Hashtable
Vector 가 ArrayList를 동기화 시킨 것처럼 Hashtable 도 HashMap 의 동기화 버전이다. 동기화를 구현했다는 것은 Hashtable를 여러 객체에서 사용할 떄 문제가 생기지 않도록 동기화 한다는 것을 뜻한다. Thread Safe 하다고도 말한다.
- Map<K, V> table = new Hashtable<>():

### 3. LinkedHashMap
맵+순서

### 4. TreeMap
- 모든 항목이 자연율에 의해 정렬.
- Comparator, Comparable 인터페이스 구현
- 키 값을 이진트리로 저장
- TreeMap<k, v> tree = new TreeMap<>();
- firstEntry(), lastEntry(), lowerEntry(K key), higherEntry(K key), floorEntry(K key), ceilingEntry(K key), pollFirstEntry(), pollLastEntry()
- #### 꺼내는 방법
  1. Iterator
  2. NavigableSet<K>, NavigableMap<k,v>


### 5. Properties
- Hashtable과 기능은 동일한데, key, value를 String으로밖에 사용할 수 없다.
- 주로 application 의 옵션정보, 데이터베이스 연결 정보, 다국어 정보가 저장된 .properties 파일을 읽을 때 사용한다


## 컬렉션 동기화

- Vector(ArrayList), Hashtable(HashMap) 이외 컬렉션, 맵을 동기화시키고 싶은 경우
- List<T> list = Collections.synchronizedList(new ArrayList<>());
- Set<T> set = Collections.synchronizedSet(new HashSet<>());
- Map<k, v> map = Collections.synchronizedMap(new HashMap<>());


## 컬렉션 병렬 처리

- 자바는 멀티 스레드가 컬렉션의 요소를 병렬적으로 처리할 수 있도록 컬렉션 제공
- java.util.concurrent 패키지의 ConcurrentHashMap, ConcurrentLinkedQueue
