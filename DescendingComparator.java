import java.util.Comparator;

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
