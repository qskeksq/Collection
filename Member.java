
public class Member {
	
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	

	@Override
	public boolean equals(Object obj) {
		// obj�� Ÿ���� Member��� �˻��Ѵ�
		if(obj instanceof Member) {
			Member member = (Member) obj;
			// �̸��� ���̰� ������ true�� ����
			return member.name.equals(name) && member.age == age;
		} else {
			return false;
		}
	}
	
	/**
	 * name�� age�� ������ ���� ��ü�� �ǵ��� �Ѵ�.
	 */
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
	

}
