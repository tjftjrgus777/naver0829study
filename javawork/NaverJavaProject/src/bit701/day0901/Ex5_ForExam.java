package bit701.day0901;

import java.util.Scanner;

public class Ex5_ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 숫자n을 입력받은후 1부터 n까지의 총 합계를 출력하시오
		Scanner sc = new Scanner(System.in);
		int n= 0;
		int sum=0;
		System.out.println("숫자를 입력하시오");
		n = sc.nextInt();
		//계산
		for(int i=0; i<=n; i++) {
			sum+=i;
		}
		//출력
		System.out.println("1부터 "+n+"까지의 합은 "+sum+"입니다");

		/*2. 구구단 숫자 2-9 사이의 숫자를 입력받은후 범위를 벗어날경우
		 "잘못 입력하여 종료합니다"라고 종료!
		 제대로 입력시 해당 구구단 출력
		 ** 5단 **
		 	5 x 1 = 5
		 	5 x 2 = 10
		 	.
		 	.
		 	5 x 9 = 45
		 */


		int dan =0;
		System.out.println("2~9사이의 숫자를 입력하시오");
		dan = sc.nextInt();
		if(2<=dan && dan<=9) {
			System.out.println("\t**"+dan+"단 **\n");
			for(int i=1;i<10;i++) {
				System.out.printf("%6d x %d = %2d\n",dan,i,dan*i);
			}
		}else {
			System.out.println("잘못 입력하여 종료합니다");
			return ;
		}
	}

}
