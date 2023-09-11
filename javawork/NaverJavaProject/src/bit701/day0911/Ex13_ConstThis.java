package bit701.day0911;

class Kiwi
{
	String name;
	int age;
	
	Kiwi()
	{
		//System.out.println("생성자 호출");// this가 반드시 첫번째 줄에 잇어야 한다
		this("홍깅돌",20);//3번쨰 생성자가 호출된다
	}
	
	Kiwi(String name)
	{
		this(name,30);//3번째 생성자가 호출된다
	}
	Kiwi(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public void writeData()
	{
		System.out.println("name:"+name+"\"t age:"+age);
	}
	
}

public class Ex13_ConstThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kiwi [] karr= {
				new Kiwi(),
				new Kiwi("kim"),
				new Kiwi("Lee",35)
		};
		for(Kiwi k:karr)
			k.writeData();
		
	}

}
