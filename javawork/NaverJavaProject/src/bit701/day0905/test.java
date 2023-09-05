package bit701.day0905;

import java.util.Scanner;

public class test {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<=5;i++) {
			for(int j=0;j<=5;j++) {
				if(i==j) {
					System.out.print(i);
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		Scanner sc = new Scanner(System.in);
		int totalmoney = 0,money =0;
		Exit:
		while(true) {
			System.out.println("-".repeat(30));
			System.out.println("1.예금 | 2.출금 |3.잔고|4.종료");
			System.out.println("-".repeat(30));
			System.out.print("선택>");
			int choice =Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1: {
				System.out.print("예금액>");
				money = Integer.parseInt(sc.nextLine());
				totalmoney+=money;
				System.out.println();
				System.out.println();
				break;
			}
			case 2:{
				System.out.print("출금액>");
				money = Integer.parseInt(sc.nextLine());
				if(totalmoney<money) {
					System.out.println("잔고에 돈 없어!!");
				}else {
					totalmoney-=money;
					System.out.println();
					System.out.println();
					break;
				}
			}
			case 3:{
				System.out.print("잔고>");
				System.out.println(totalmoney);
				System.out.println();
				break;
 			}
			case 4:{
				System.out.println("프로그램 종료>");
				System.out.println();
				break Exit;
			}
			default:System.out.println("1~4 사이의 숫자를 입력하세요");
			}
			
		}

	}

}
