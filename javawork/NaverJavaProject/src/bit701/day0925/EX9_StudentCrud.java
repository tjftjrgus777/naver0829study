package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import db.DbConnect;
import oracle.jdbc.internal.StateSignatures;

public class EX9_StudentCrud {
	DbConnect db=new DbConnect();
	Scanner sc =new Scanner(System.in);
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	String name;
	String blood;
	String phone;
	String writeday;

	public int getMenu()
	{
		System.out.println("1.추가	2.삭제	3.수정	4전체출력	5.검색	6.종료" );
		int menu=Integer.parseInt(sc.nextLine());
		return menu;
	}

	//insert
	public void insertStudent()
	{
		System.out.println("이름을 입력하세요");
		name =sc.nextLine();
		System.out.println("혈액형을 입력하세요");
		blood=sc.nextLine();
		System.out.println("핸드폰번호를 입력하세요");
		phone=sc.nextLine();
		sql="insert into student values(null,?,?,?,now())";
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			//실행
			pstmt.execute();
			System.out.println("추가되었습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//delete
	public void deleteStudent()
	{
		System.out.println("삭제할 이름은?");
		name=sc.nextLine();
		sql="delete from student where name=?";
		conn= db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int n=pstmt.executeUpdate();
			if(n==0) {
				System.out.println("해당 이름을 찾을수 없습니다");
			}else {
				System.out.println("삭제했습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	//update
	public void updateStudent()
	{
		System.out.println("수정할 num 값");
		String num=sc.nextLine();
		System.out.println("이름을 입력하세요");
		name =sc.nextLine();
		System.out.println("혈액형을 입력하세요");
		blood=sc.nextLine();
		System.out.println("핸드폰번호를 입력하세요");
		phone=sc.nextLine();
		sql="update student set name=?,blood=?,phone=? where num=?";
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			pstmt.setString(4, num);
			int n=pstmt.executeUpdate();
			if(n==0) {
				System.out.println("수정 실패");
			}else {
				System.out.println("수정 성공");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//전체 출력
	public void selectAllStudent()
	{
		sql="select * from student order by num";
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			System.out.println("번호\t이름\t혈액형\t전화\t날짜");
			System.out.println("=".repeat(50));
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");
				//String writeday=rs.getString("writeday"); //날짜타입도 String 타입으로 가져와도된다
				Timestamp ts=rs.getTimestamp("writeday");
				//System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+ts.toLocaleString());
				System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+sdf.format(ts));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	//검색-번호 끝 4자리로 검색
	public void searchPhone()
	{
		System.out.println("전화번호 끝 4자리를 입력하세요");
		phone= sc.nextLine();
		sql="select * from student where phone like ?";
		conn= db.getMysqlConnection();
		try {
			pstmt= conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+phone);
			rs=pstmt.executeQuery();
			
			System.out.println("전화번호 "+phone+"검색결과");
			System.out.println("번호\t이름\t혈액형\t전화\t날짜");
			System.out.println("=".repeat(50));
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");
				//String writeday=rs.getString("writeday"); //날짜타입도 String 타입으로 가져와도된다
				Timestamp ts=rs.getTimestamp("writeday");
				//System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+ts.toLocaleString());
				System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+sdf.format(ts));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EX9_StudentCrud ex =new EX9_StudentCrud();
		
		while(true)
		{
			System.out.println("-".repeat(40));
			int menu=ex.getMenu();
			System.out.println("-".repeat(40));
			switch (menu) {
			case 1: {
				ex.insertStudent();
				break;
			}
			case 2: {
				ex.deleteStudent();
				break;
			}
			case 3: {
				ex.updateStudent();
				break;
			}
			case 4: {
				ex.selectAllStudent();
				break;
			}
			case 5: {
				ex.searchPhone();
				break;
			}
			default:
				System.out.println("** 프로그램을 종료합니다**");
			}
		}
	}
	

}
