package bit701.day0830;

public class ExamEx8 {

	public static void main(String[] args) {
		
		
		//money변수에 args[0] 값을 대입후{급여: 백만단위:5674321}
		/*
		 * 출력
		 * money:5674321 원
		 * 만원짜리 567장
		 * 천원짜리 4장
		 * 백원짜리 3개
		 * 십원짜리 2개
		 * 일원짜리 1개
		 * 
		 *  : 산술연산자를 사용해서 출력해보세요
		 *  
		 */
		
		//파라미터에서 월급여를 읽어서(문자열)정수 타입으로 변환한다
		int money = Integer.parseInt(args[0]);
		int m1 = money/10000;
		int m2 = money%10000/1000;
		int m3 =money%1000/100;
		int m4 = money%100/10;
		int m5 = money%10;
		System.out.println("월 급여:"+money);
		System.out.println("만원짜리"+ m1+"장");
		System.out.println("천원짜리"+ m2+"장");
		System.out.println("백원짜리"+ m3+"개");
		System.out.println("십원짜리"+ m4+"개");
		System.out.println("일원짜리"+ m5+"개");
		
		

	}

}
