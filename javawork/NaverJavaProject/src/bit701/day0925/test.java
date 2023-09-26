package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DbConnect;

public class test {
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql;
	String name;
	String blood;
	String phone;


	public void insertStudent()
	{
		System.out.println("학생정보 추가");
		System.out.println("이름");
		name =sc.nextLine();
		System.out.println("혈액형");
		blood =sc.nextLine();
		System.out.println("전화번호");
		phone =sc.nextLine();
		
		sql="insert into student values(null,?,?,?,now())";
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			pstmt.execute();
			System.out.println("학생 추가 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteStudent()
	{
		System.out.println("삭제할 학생 이름 입력");
		name= sc.nextLine();
		sql="delete from student where name=?";
		conn=db.getMysqlConnection();
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int n=pstmt.executeUpdate();
			if(n==0) {
				System.out.println("학생 없어요");
			}else {
				System.out.println("학생 삭제 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	public void updateStudent()
	{
		System.out.println("수정할 num값");
		String num = sc.nextLine();
		System.out.println("이름?");
		name = sc.nextLine();
		System.out.println("혈액형?");
		blood =sc.nextLine();
		System.out.println("전화번호?");
		phone =sc.nextLine();
		sql="update student set name=?,blood=?,phone=? where num=? ";
		conn= db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			pstmt.setString(4, num);
			int n=pstmt.executeUpdate();
			if(n==0) {
				System.out.println("수정실패");
			}else {
				System.out.println("수정성공");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void selectAllStudent()
	{
		sql="slect * from student order by num";
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				//rs.getString();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchStudent()
	{
		
	}
	
	
	public void menu() {
		System.out.println("번호를 입력하세요");
		int num= Integer.parseInt(sc.nextLine());
		switch (num) {
		case 1: {
			
			break;
		}
		case 2: {

			break;
		}
		case 3: {

			break;
		}
		case 4: {

			break;
		}
		case 5: {

			break;
		}
		
		default:
			break;
		}
	}

	public static void main(String []args) {
		test ex = new test();
		ex.menu();
		
	}
}
