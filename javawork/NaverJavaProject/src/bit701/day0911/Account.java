package bit701.day0911;
//교재 클래스부분 20번 문제
public class Account {
	private String accountName;//계좌주
	private String accountNo;
	private int money;//잔액
	
	//3개의 값을 전달받는 생성자
	public Account(String accountNo,String accountName,int money){
		this.accountName=accountName;
		this.accountNo=accountNo;
		this.money=money;
	}
	
	
	
	//계좌번호 맞을경우 true를 반환해주는 매서드
	// isAccount(String accountNo):맞을경우 true반환, 틀릴경우 false반환
	public boolean isAccount(String accountNo)
	{
		if(accountNo.equals(this.accountNo))
		{
			return true;
		}else {
			return false;
		}
			
	}
	
	//외부에서 입급시 money에 추가하는 매서드(addMoney)
	public void addMoney(int addMoney) {
		this.money+=addMoney;
	}
	//외부에서 출금시 money에서 빼는 매서드(subMoney)
	public void subMoney(int money) {
		this.money-=money;
	}
	//출력해주는 매서드 계좌번호 예금주 잔액(accountWrite)-+
	public void accountWrite()
	{
		System.out.println(accountNo+"\t"+accountName+"\t"+money);
	}



	
	//getter method
	public String getAccountName() {
		return accountName;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public int getMoney() {
		return money;
	}
}
