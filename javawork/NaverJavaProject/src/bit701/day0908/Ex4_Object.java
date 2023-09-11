package bit701.day0908;

public class Ex4_Object {
	//인스턴스 멤버 변수
	private int score;
	//클래스 멤버변수
	static public String message;
	
	//인스턴스 멤버 메소드
	//score에 값을 넣는 메서드 (setter method)
	public void setScore(int score)
	{
		//멤버변수 score에 인자로 받은 score를 전달
		//매개변수명이 멤버변수명이랑 같을경우 멤버변수앞에 this를 붙인다
		this.score=score;
	}
	
	//점수를 반환하는 getter method
	public int getScore() 
	{
		return score;//this.score에서 this가 생략 가능
	}
	
	//static 메서드는 static 멤버변수만 접근가능
	public static void setMessage(String message)
	{
		Ex4_Object.message=message;
	}
	
	//static 매소드는 this가 없다
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// main 매서드는 static이므로 new로 생성을 해야 멤버 접근이 가능하다
		// 단 static은 호출 가능
		
		Ex4_Object.setMessage("Hello World!");
		//public 이므로 바로 출력 가능
		System.out.println(Ex4_Object.message);
		
		//static 매소드가,변수가 아닌 것들은 main에서 호출이 안됨 this가 없어서 그래서 this 역할을 하는 ex4를 생성
		Ex4_Object ex4=new Ex4_Object();
		ex4.setScore(89);
		System.out.println("점수:"+ex4.score);
	}

}
