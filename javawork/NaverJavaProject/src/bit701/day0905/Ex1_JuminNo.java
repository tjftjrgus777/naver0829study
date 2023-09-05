package bit701.day0905;

import java.util.Scanner;

public class Ex1_JuminNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String ssn ="9506241230123";
//		char sex = ssn.charAt(6);
//		switch (sex) {
//		case '1':
//		case '3': {
//			System.out.println("남자입니다");
//			break;
//		}
//		case '2':
//		case '4': {
//			System.out.println("여자입니다");
//			break;
//		}
//
//		}
	
		Scanner sc = new Scanner(System.in);
		String juminNo;
		while(true) {
			
			System.out.println("[실행결과]");
			System.out.println("주민등록 번호 입력 꼭(-)를 사용해주세요");
		    juminNo = sc.nextLine();
			if(juminNo.equalsIgnoreCase("q")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			if(juminNo.charAt(6)!='-') {
				System.out.println("임마 - 쓰라고");
				continue;
			}
			char gender = juminNo.charAt(7);
			String year =juminNo.substring(0,2);
			String month = juminNo.substring(2,4);
			String day = juminNo.substring(4,6);
			System.out.println(year+"년"+month+"월"+day+"일생");
			switch (gender) {
			case '1','3': {
				System.out.println("내국인");
				System.out.println("남성");
				break;
			}
			case '2','4': {
				System.out.println("내국인");
				System.out.println("여성");
				break;
			}
			case '5':{
				System.out.println("외국인");
				System.out.println("남성");
				break;
			}
			case '6':{
				System.out.println("외국인");
				System.out.println("여성");
				break;
			}
			default:System.out.println("너는 어는 나라 사람이냐");
			}
		}
	}

}
