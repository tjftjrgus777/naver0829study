package bit701.day0904;

import java.util.Scanner;

public class Ex2_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 점수를 입력받아 총점과 평균을 구해보자(0이 입력되면 점수입력을 종료한다)
		Scanner sc = new Scanner(System.in);
		int score;
		int sum=0,count=0;
		double avg=0;
		
		while(true) {
			System.out.println("점수를 입력하세요");
			score= sc.nextInt();
			if(score==0)
				break;//0입력시 while문을 빠져나간다
			if(score<1 || score>100) {
				System.out.println("\t1~100사이의 점수만 입력해주세요");
				continue;
			}
				count++;// 입력한 갯수구하기
				sum+=score;// 총점구하기
		}
		//0 입력시 빠져나온후 평균 구하기
		System.out.println();
		avg=(double)sum/count;
		System.out.println("입력된 점수 갯수"+ count);
		System.out.println("총 합계"+ sum);
		System.out.println("평균"+ avg);
	}


}
