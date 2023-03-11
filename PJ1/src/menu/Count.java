package menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import order.OrderDAO;
import order.OrderVO;
import total.TotalDAO;

public class Count {
	private int num;
	private int sum;
	private int drink;
	private String result;

	
	
	
	public String getResult() {
		return result;
	}




	public void setResult(String result) {
		this.result = result;
	}




	public int getSum() {
		return sum;
	}




	public void setSum(int sum) {
		this.sum = sum;
	}




	public int getDrink() {
		return drink;
	}




	public void setDrink(int drink) {
		this.drink = drink;
	}




	public int getNum() {
		return num;
	}




	public void setNum(int num) {
		this.num = num;
	}




	public void cou() throws ClassNotFoundException, SQLException {
		OrderDAO oda = new OrderDAO();
		TotalDAO to = new TotalDAO();
		
		String name = "";
		
		ArrayList<OrderVO> vo = oda.getAllInfo();
		
		for(OrderVO vv : vo) {	 // 여태까지 주문한 목록 메뉴 테이블에서 출력 
			name+=vv.getProductName()+" "+vv.getChoice()+""
			+"개 "+vv.getPrice()+"원\n";
		
		}
		setResult(name);


	}
	
	

}
