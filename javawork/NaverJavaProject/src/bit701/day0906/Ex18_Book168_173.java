package bit701.day0906;

public class Ex18_Book168_173 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		// 배열 변수 선언과 배열 생성
//		String[] season = {"Spring","Summer","Fall","Winter"};
//		
//		//배열의 항목값 읽기
//		System.out.println("season[0] : " + season[0]);
//		System.out.println("season[1] : " + season[1]);
//		System.out.println("season[2] : " + season[2]);
//		System.out.println("season[3] : " + season[3]);
//		
//		//인덱스 1번 항목의 값 변경
//		season[1] = "여름";
//		System.out.println("season[1] : "+season[1]);
//		System.out.println();
//		
//		//배열 변수 선언과 배열 생성
//		int[] scores = {83,90,87};
//		
//		//총합과 평균 구하기
//		int sum =0;
//		for(int i=0; i<scores.length;i++) {
//			sum += scores[i];
//		}
//		System.out.println("총합 : " +sum);
//		double avg =(double)sum/3;
//		System.out.println("평균: "+avg);
		
		// 배열 변수 선언과 배열 생성
		int[] arr1=new int[3];
		// 배열 항목의 초기값 출력
		for(int i=0;i<3;i++) {
			System.out.println("arr1["+i+"]:"+arr1[i]+",");
		}
		System.out.println();
		//배열 항목의 값 변경
		arr1[0]=10;
		arr1[1]=20;
		arr1[2]=30;
		//배열 항목의 변경 값 출력
		for(int i=0;i<3;i++) {
			System.out.println("arr1["+i+"]:"+arr1[i]+",");
		}
		System.out.println("\n");
		
		//배열 변수 선언과 배열 생성
		double[] arr2 = new double[3];
		
		
	}

}
