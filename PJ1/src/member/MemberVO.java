package member;

import java.sql.SQLException;
import java.util.Scanner;

import point.PointDAO;

public class MemberVO {
	
	public void MInsertVO() throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("회원가입을 위한 핸드폰 뒷자리 4자리를 입력해주십시오");
		System.out.print("번호 입력:");
		int number1 = sc.nextInt();
		
		MemberDAO mdao = new MemberDAO();
		PointDAO pdao = new PointDAO();
		
		pdao.Select(number1);
		
		if(number1 == pdao.getNumber())		 // 회원생성시 중복 방지 
			System.out.println("이미생성된 번호입니다");
		else {
		
		boolean result = mdao.MInsert(number1);
		if (result) 
			System.out.println("회원번호 생성완료");
		else
			System.out.println("회원번호 생성오류");
		}
		
	}

	public void MDeleteVO() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		PointDAO pdao = new PointDAO();
		System.out.println("회원탈퇴를 위한 회원번호를 입력해주십시오");
		System.out.print("번호 입력:");
		int number1 = sc.nextInt();
		
		MemberDAO dao = new MemberDAO();
		
		pdao.Select(number1);
		
		System.out.println(number1);
		System.out.println(pdao.getNumber());
		
		if(number1 != pdao.getNumber())		 // 회원삭제시 없는번호 확인용 
			System.out.println("없는 번호입니다");
		else {
		
		boolean result = dao.MDelete(number1);	 // 회원 삭제메소드
		if (result) 
			System.out.println("회원탈퇴 완료");
		else
			System.out.println("회원탈퇴 오류");
		}
		
		 
		
		
	}

}
