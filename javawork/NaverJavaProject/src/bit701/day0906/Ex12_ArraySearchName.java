package bit701.day0906;

import java.util.Iterator;
import java.util.Scanner;

public class Ex12_ArraySearchName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names = {"강호동","유재석","한채영","이효리","이승기",
				"강남길","이민정","이서진","손미나","유미리"};
		/*
		 *		검색할 성은? 이
		 *		4:이효리
		 *		5:이승기
		 *		7:이민정
		 *		8:이서진
		 *		 총 4명
		 *
		 *	검색할 성은?박
		 *		'박'씨성을 가진 멤버는 없습니다
		 *
		 *	검색할 성은?끝
		 *		종료합니다
		 *
		 *	변수 :	String searchSung
		 *			int count;
		 *			boolean bFind;
		 *
		 *	startsWish 이용해서 프로그램 작성해보세요
		 */
		String searchSung;
		int count;
		boolean bFind;
		while(true) {
			Scanner sc =new Scanner(System.in);
			searchSung="";
			count=0;
			
			System.out.println("검색할 성은?");
			searchSung=sc.nextLine();
			
			if(searchSung.equals("끝")) {
				System.out.println("** 종료합니다 **");
				break;
			}
			
			for(int i=0;i<names.length;i++) {
				if(names[i].startsWith(searchSung)) {
					System.out.println(i+1+":"+names[i]);
					count++;
					bFind=true;
				}
			}
			if(count==0) {
				System.out.printf("\"%s\"씨성을 가진 멤버는 없습니다\n",searchSung);
				System.out.println();
			}else {
				System.out.println("총"+count+"명");
			}
			
			
		}
	}

}
