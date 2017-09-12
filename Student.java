
public class Student {
	
	public String name;
	public int sno;
	
	public Student(String name, int sno) {
		this.name = name;
		this.sno = sno;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student) obj;
			return student.name.equals(name) && student.sno == sno;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+sno;
	}

}
