package point;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import order.OrderDAO;
import order.OrderVO;
import total.TotalDAO;

public class Point_1 {

   

   public void po() throws ClassNotFoundException, SQLException {
      
      OrderDAO od = new OrderDAO();
      PointDAO da = new PointDAO();
      TotalDAO to = new TotalDAO();
      
      int number;
      
      while (true) {
         int p = JOptionPane.showConfirmDialog(null, "--------포인트---------\n"
               + "포인트를 적립하시겠습니까?\n", "포인트창", JOptionPane.YES_NO_OPTION);
         if(p == JOptionPane.YES_OPTION) {
             
             // -- 회원번호 유효성 검사
              
              String nnum = null;
              int num = 0;
              
              while(true) {
              
                nnum = JOptionPane.showInputDialog("회원번호 입력");
                  Pattern pattern = Pattern.compile("\\d{4}"); // "//d{4}" 패턴은 숫자 4개가 연속된 것을 의미
            
                  Matcher matcher = pattern.matcher(nnum);
           
                  if(matcher.matches()) // 4자리 연속된 숫자이면 true, k를 false로 바꾸면서 while문 빠져나옴
                 break;
              else              // 4자리 연속된 숫자가 아니면 false, 에러메세지 출력
                 JOptionPane.showMessageDialog(null, "유효한 번호가 아닙니다.\nForm : 4자리 숫자", "error", JOptionPane.ERROR_MESSAGE);
           
              }
           
           // -- 유효성검사 끝
              
             num = Integer.parseInt(nnum);
              
              da.Select(num);    // 회원번호 있는지 없는지 확인 메소드
              if(num == da.getNumber()) {   // 테이블내의 번호를 받아서 구별          
                 boolean p2 = da.UPDATE1(num);
                 if (p2) {
                    
                    int point = da.getResult();
                    JOptionPane.showMessageDialog(null, "포인트 적립 완료\n현재 포인트 : " + point);
                    
                    ArrayList<OrderVO> vo = od.getAllInfo();
                    
                    for(OrderVO vv : vo) {
                       to.Select(vv.getProductName());
                       if(!vv.getProductName().equals(to.getMenu())) {
                          to.Insert(vv.getProductName(), vv.getChoice());
                       }
                       else {
                          to.UPdate(vv.getProductName(), vv.getChoice());
                       }
                    }
                    
                    if(point > 4)  // 포인트 5달성시 초기화 
                    {
                       JOptionPane.showMessageDialog(null, "포인트 5점 달성으로\n아메리카노 무료 쿠폰을 지급합니다.");
                       da.UPDATE2(num);
                       JOptionPane.showMessageDialog(null, "포인트가 초기화됩니다.\n잔액 포인트: " + da.getResult());
                    }
                    od.ODelete(); // 테이블 초기화메소드
                    break; // 초기메뉴로 되돌리는 용도 
                 }
                 else 
                    JOptionPane.showMessageDialog(null, "포인트 적립 오류");
                 
              }
              else 
                 JOptionPane.showMessageDialog(null, "가입된 번호가 아닙니다.");
              //  회원번호가 등록이 안되있을때 출력 
              
           }
         else if(p == JOptionPane.NO_OPTION) {
            
            JOptionPane.showMessageDialog(null, "결제 완료");
            
            ArrayList<OrderVO> vo = od.getAllInfo();
            
            for(OrderVO vv : vo) {
               to.Select(vv.getProductName());
               if(!vv.getProductName().equals(to.getMenu())) {
                  to.Insert(vv.getProductName(), vv.getChoice());
               }
               else {
               to.UPdate(vv.getProductName(), vv.getChoice());
               }
            }
            od.ODelete();  // 테이블 초기화메소드 
            break; // 초기메뉴로 되돌리는 용도
         }
         
      }   
      
   }         

}