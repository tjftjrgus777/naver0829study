package bit701.day0830;

public class DataEx1 {

	public static void main(String[] args) {
		System.out.println("apple\n");
		System.out.println("banana");
		System.out.println("orange\n");
		
		//printf: 변환기호에 의한 출력, 정수 :%d,실수:%f,문자:%c,문자열:%S
		// \n:줄넘김,\t:다음탭위치로 이동
		int age=23;
		double weight=56.7;
		char blood='A';
		String name="캐서린";
		System.out.printf("이름:%s\n\n",name);
		System.out.printf("나이:%d세\n",age);
		System.out.printf("몸무게:%fkg\n",weight);
		System.out.printf("몸무게:%5.1fkg\n",weight); //%5.1f:전체자리수5, 소수점자리수:1
		System.out.printf("혈액형:%c형\n",blood);
		System.out.println("===========================");
		System.out.printf("이름:%s\n혈액형:%c형\n나이:%d세\n", name,blood,age);
		
	}

}
