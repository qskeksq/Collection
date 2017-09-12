
public class Member {
	
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	

	@Override
	public boolean equals(Object obj) {
		// obj의 타입이 Member라면 검사한다
		if(obj instanceof Member) {
			Member member = (Member) obj;
			// 이름과 나이가 같으면 true를 리턴
			return member.name.equals(name) && member.age == age;
		} else {
			return false;
		}
	}
	
	/**
	 * name과 age가 같으면 같은 객체가 되도록 한다.
	 */
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
	

}
