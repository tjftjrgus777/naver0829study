package bit701.day0911;

public class Ex12_StudentCallBy {

	//주소가 넘어오르모 여기서 준 초기값은 main의 stu로 값이 전달된다!
	public static void dataInput(Student[] stu)
	{
		stu[0]=new Student("김씨");
		stu[1]=new Student("이씨",2000,90);
		stu[2]=new Student("박씨",1989,89);
	}

	public static void dataWrite(Student[] stu)
	{
		for(Student s:stu)
		{
			s.studnetInfo();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student []stu=new Student[3];
		dataInput(stu);
		dataWrite(stu);

		int a=100;
		int b=chahgeInt(a);//call by value로 값을 변경한경유 리턴으로 변경된값을 얻어야만 알수있다
		System.out.println();
		
	}

	private static int chahgeInt(int a) {
		// TODO Auto-generated method stub
		a=200;
		return a;
	}

}
