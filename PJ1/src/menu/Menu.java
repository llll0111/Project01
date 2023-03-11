package menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import member.MemberDAO;
import order.OrderDAO;
import point.PointDAO;
import point.Point_1;
import total.TotalDAO;
import total.TotalVO;

public class Menu extends JFrame implements ActionListener{

   
   private JPanel contentPane;
   
   OrderDAO odao = null;
   TotalDAO tdao = null;
   
   
   JLabel Cmenu = new JLabel("카페 메뉴");
   JButton ame = null;
   JButton CafeR = new JButton("카페라떼   2700원");
   JButton Moca = new JButton("카페모카   3700원");
   JButton banil = new JButton("바닐라라떼    3200원");
   JButton Caramel = new JButton("카라멜 마끼아또  3500원");
   JButton Cancel = new JButton("취소");
   JButton Pay = new JButton("결제");
   JButton Join = new JButton("회원생성");
   JButton MDelete = new JButton("회원탈퇴");
   
   private int sum;
   private int drink;
   private final JLabel lblNewLabel_1 = new JLabel("");
   private final JLabel lblNewLabel_1_2 = new JLabel("");
   private final JLabel lblNewLabel_1_3 = new JLabel("");
   private final JLabel lblNewLabel_2 = new JLabel("");
   private String popular = "";
   int count = 0;
   
   
   
   public String getPopular() {
	return popular;
}

public void setPopular(String popular) {
	this.popular = popular;
}

int n1 = 1;
   
   
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Menu frame = new Menu();
               
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
 * @throws SQLException 
 * @throws ClassNotFoundException 
    */
   public Menu()  {
	      
	     try {
	      tdao = new TotalDAO();
	   } catch (ClassNotFoundException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   }
	      setBounds(430, 50, 857, 854);
	      contentPane = new JPanel();
	      contentPane.setBackground(new Color(253, 245, 230));
	      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	      setContentPane(contentPane);
	      contentPane.setLayout(null);
	      
	      ame = new JButton("아메리카노   1500원");
	      ame.setFont(UIManager.getFont("Button.font"));
	      ame.setBounds(165, 228, 158, 54);
	      contentPane.add(ame);
	      banil.setFont(UIManager.getFont("Button.font"));
	      
	      
	      banil.setBounds(450, 228, 169, 54);
	      contentPane.add(banil);
	      CafeR.setFont(UIManager.getFont("Button.font"));
	      
	      
	      CafeR.setBounds(165, 401, 158, 54);
	      contentPane.add(CafeR);
	      Moca.setFont(UIManager.getFont("Button.font"));
	      
	      
	      
	      Moca.setBounds(450, 401, 158, 54);
	      contentPane.add(Moca);
	      
	      
	      Caramel.setBounds(165, 593, 169, 54);
	      contentPane.add(Caramel);
	      
	      
	      Join.setBounds(718, 27, 117, 29);
	      contentPane.add(Join);
	      
	      
	      Pay.setBounds(243, 730, 120, 45);
	      contentPane.add(Pay);
	      
	      
	      Cancel.setBounds(391, 730, 120, 45);
	      contentPane.add(Cancel);
	      
	      
	      MDelete.setBounds(718, 102, 117, 29);
	      contentPane.add(MDelete);
	      
	      JLabel Hot = new JLabel("오늘의 인기메뉴");
	      Hot.setHorizontalAlignment(SwingConstants.CENTER);
	      Hot.setFont(new Font("Dialog", Font.BOLD, 20));
	      Hot.setBounds(6, 27, 158, 43);
	      contentPane.add(Hot);
	     
	      
	      try {
	      ArrayList<TotalVO> to = tdao.getSMenue();
	      for(TotalVO tvo : to ) {
	          popular+=n1+"."+tvo.getName()+"\n";
	          n1++;
	         }
	   } catch (SQLException e) {
	      
	      e.printStackTrace();
	   }
	      
	      JLabel Hot2 = new JLabel(popular);
	      Hot2.setHorizontalAlignment(SwingConstants.LEFT);
	      Hot2.setVerticalAlignment(SwingConstants.TOP);
	      Hot2.setFont(new Font("Dialog", Font.BOLD, 15));
	      Hot2.setBounds(16, 64, 137, 178);
	      contentPane.add(Hot2);
	      Cmenu.setHorizontalAlignment(SwingConstants.CENTER);
	      
	      
	      Cmenu.setFont(new Font("Dialog", Font.BOLD, 25));
	      Cmenu.setBounds(302, 33, 169, 54);
	      contentPane.add(Cmenu);
	      
	      JLabel lblNewLabel = new JLabel("");
	      lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/Image/AmeIM.png")));
	      lblNewLabel.setBounds(211, 135, 80, 89);
	      contentPane.add(lblNewLabel);
	      lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/Image/BanilIM.png")));
	      lblNewLabel_1.setBounds(500, 120, 61, 104);
	      
	      contentPane.add(lblNewLabel_1);
	      lblNewLabel_1_2.setIcon(new ImageIcon(Menu.class.getResource("/Image/CafeRIM.png")));
	      lblNewLabel_1_2.setBounds(211, 306, 80, 83);
	      
	      contentPane.add(lblNewLabel_1_2);
	      lblNewLabel_1_3.setIcon(new ImageIcon(Menu.class.getResource("/Image/CaramelIM.png")));
	      lblNewLabel_1_3.setBounds(224, 465, 61, 115);
	      
	      contentPane.add(lblNewLabel_1_3);
	      lblNewLabel_2.setIcon(new ImageIcon(Menu.class.getResource("/Image/MocaIM.png")));
	      lblNewLabel_2.setBounds(492, 293, 61, 104);
	      
	      contentPane.add(lblNewLabel_2);
	      
	      
	      
	      ame.addActionListener(this);
	      CafeR.addActionListener(this);
	      banil.addActionListener(this);
	      Moca.addActionListener(this);
	      Caramel.addActionListener(this);
	      Pay.addActionListener(this);
	      Cancel.addActionListener(this);
	      Join.addActionListener(this);
	      MDelete.addActionListener(this);
	      
	      addWindowListener(new WindowAdapter() { // add : 창을닫는 이벤트 등록  
	         public void windowClosing(WindowEvent e1) {
	            if(drink == 0) {
	               dispose(); // 메모리 제거
	               System.exit(0);
	            }
	            else {
	               odao.ODelete(); // 제목옆의 빨간 x를 눌러서 닫을때 메뉴 테이블 초기화
	               dispose(); // 메모리 제거
	               System.exit(0);
	            }
	         }
	      });
	   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   PointDAO pdao = null;
	   try {
		pdao = new PointDAO();
	} catch (ClassNotFoundException e3) {
		e3.printStackTrace();
	} catch (SQLException e3) {
		e3.printStackTrace();
	}
	   
	      try {
	         odao = new OrderDAO();
	      } catch (ClassNotFoundException e2) {
	         System.out.println();
	      } catch (SQLException e2) {
	         System.out.println("SQL Exception");
	      }

      MemberDAO mdao = null;
      
      try {
         mdao = new MemberDAO();
      } catch (ClassNotFoundException | SQLException e2) {
         e2.printStackTrace();
      }
      
      if(e.getSource() == ame) {
         String ame1 = "아메리카노";
         int price1 = 1500;
         Count cnt = new Count();
         try {
            cnt.cou();
         } catch (ClassNotFoundException e1) {
            
         } catch (SQLException e1) {
            
         }
         while(true) {
        	 boolean k = true;
             String dia = null;
             while(k) {
             
                dia = JOptionPane.showInputDialog(cnt.getResult()+"\n수량");
                
                Pattern pattern = Pattern.compile("\\d{1}");
       			Pattern pattern2 = Pattern.compile("\\d{2}");
             
                Matcher matcher = pattern.matcher(dia);
             	Matcher matcher2 = pattern2.matcher(dia);
               
                if(matcher.matches() || matcher2.matches()) 
                   k = false;
                else {
               JOptionPane.showMessageDialog(null, "올바른 수량이 아닙니다", "error", JOptionPane.ERROR_MESSAGE);
               
            }
        }
         int su = Integer.parseInt(dia);
         if (su>0) {
            odao.Select(ame1); // INSERT후 다시 INSERT되는지 확인용
            if(!ame1.equals(odao.getName1()))
               odao.insert_product(ame1,su,price1);
            else
               odao.UPDATE1(ame1, su, price1);
            JOptionPane.showMessageDialog(null, "추가되었습니다");
            drink+=su;
            sum+=(price1*su);
            count++;          
            break;
         }
         else
            JOptionPane.showMessageDialog(null, "1개이상 입력해주세요", "error", JOptionPane.ERROR_MESSAGE);
         }
         
         
      }
      
      
      if(e.getSource() == CafeR) {
         
         String ame1 = "카페라떼";
         int price1 = 2700;
         Count cnt = new Count();
         try {
            cnt.cou();
         } catch (ClassNotFoundException e1) {
            
         } catch (SQLException e1) {
            
         }
         while(true) {
        	 boolean k = true;
             String dia = null;
             while(k) {
             
                dia = JOptionPane.showInputDialog(cnt.getResult()+"\n수량");
                
                Pattern pattern = Pattern.compile("\\d{1}"); 
       			Pattern pattern2 = Pattern.compile("\\d{2}");
             
                Matcher matcher = pattern.matcher(dia);
             	Matcher matcher2 = pattern2.matcher(dia);
               
                if(matcher.matches() || matcher2.matches()) 
                   k = false;
                else {
               JOptionPane.showMessageDialog(null, "올바른 수량이 아닙니다", "error", JOptionPane.ERROR_MESSAGE);
               
            }
        }
         int su = Integer.parseInt(dia);
         if (su>0) {
            odao.Select(ame1); // INSERT후 다시 INSERT되는지 확인용
            if(!ame1.equals(odao.getName1()))
               odao.insert_product(ame1,su,price1);
            else
               odao.UPDATE1(ame1, su, price1);
            JOptionPane.showMessageDialog(null, "추가되었습니다");
            drink+=su;
            sum+=(price1*su);
            count++;
            break;
         }
         else
            JOptionPane.showMessageDialog(null, "1개이상 입력해주세요", "error", JOptionPane.ERROR_MESSAGE);
         }
         
      }
      
      if(e.getSource() == Moca) {
         
         String ame1 = "카페모카";
         int price1 = 3700;
         Count cnt = new Count();
         try {
            cnt.cou();
         } catch (ClassNotFoundException e1) {
            
         } catch (SQLException e1) {
            
         }
         while(true) {
        	  boolean k = true;
              String dia = null;
              while(k) {
              
                 dia = JOptionPane.showInputDialog(cnt.getResult()+"\n수량");
                 
                 Pattern pattern = Pattern.compile("\\d{1}"); 
        			Pattern pattern2 = Pattern.compile("\\d{2}");
              
                 Matcher matcher = pattern.matcher(dia);
              	Matcher matcher2 = pattern2.matcher(dia);
                
                 if(matcher.matches() || matcher2.matches()) 
                    k = false;
                 else {
                JOptionPane.showMessageDialog(null, "올바른 수량이 아닙니다", "error", JOptionPane.ERROR_MESSAGE);
                
             }
         }

         int su = Integer.parseInt(dia);
         if (su>0) {
            odao.Select(ame1); // INSERT후 다시 INSERT되는지 확인용
            if(!ame1.equals(odao.getName1()))
               odao.insert_product(ame1,su,price1);
            else
               odao.UPDATE1(ame1, su, price1);
            JOptionPane.showMessageDialog(null, "추가되었습니다");
            drink+=su;
            sum+=(price1*su);
            count++;
            break;
         }
         else
            JOptionPane.showMessageDialog(null, "1개이상 입력해주세요","error", JOptionPane.ERROR_MESSAGE);
         }
         
      }
  
      if(e.getSource() == banil) {
         
         String ame1 = "바닐라라떼";
         int price1 = 3200;
         Count cnt = new Count();
         try {
            cnt.cou();
         } catch (ClassNotFoundException e1) {
            
         } catch (SQLException e1) {
            
         }
       while(true) { 
       boolean k = true;
       String dia = null;
       while(k) {
       
          dia = JOptionPane.showInputDialog(cnt.getResult()+"\n수량");
          
          Pattern pattern = Pattern.compile("\\d{1}");
 			Pattern pattern2 = Pattern.compile("\\d{2}");
       
          Matcher matcher = pattern.matcher(dia);
       	Matcher matcher2 = pattern2.matcher(dia);
         
          if(matcher.matches() || matcher2.matches()) 
             k = false;
          else {
         JOptionPane.showMessageDialog(null, "올바른 수량이 아닙니다", "error", JOptionPane.ERROR_MESSAGE);
         
      }
       }
         int su = Integer.parseInt(dia);
         if (su>0) {
            odao.Select(ame1); // INSERT후 다시 INSERT되는지 확인용
            if(!ame1.equals(odao.getName1()))
               odao.insert_product(ame1,su,price1);
            else
               odao.UPDATE1(ame1, su, price1);
            JOptionPane.showMessageDialog(null, "추가되었습니다");
            drink+=su;
            sum+=(price1*su);
            count++;
            break;
            
         }
         else
            JOptionPane.showMessageDialog(null, "1개이상 입력해주세요");
         }
      }
      
      
      if(e.getSource() == Caramel) {
         
         String ame1 = "카라멜마끼아또";
         int price1 = 3500;
         Count cnt = new Count();
         try {
            cnt.cou();
         } catch (ClassNotFoundException e1) {
            
         } catch (SQLException e1) {
            
         }
         while(true) {
        	 boolean k = true;
             String dia = null;
             while(k) {
             
                dia = JOptionPane.showInputDialog(cnt.getResult()+"\n수량");
                
                Pattern pattern = Pattern.compile("\\d{1}"); 
       			Pattern pattern2 = Pattern.compile("\\d{2}");
             
                Matcher matcher = pattern.matcher(dia);
             	Matcher matcher2 = pattern2.matcher(dia);
               
                if(matcher.matches() || matcher2.matches()) 
                   k = false;
                else {
               JOptionPane.showMessageDialog(null, "올바른 수량이 아닙니다", "error", JOptionPane.ERROR_MESSAGE);
               
            }
        }
         int su = Integer.parseInt(dia);
         if (su>0) {
            odao.Select(ame1); // INSERT후 다시 INSERT되는지 확인용
            if(!ame1.equals(odao.getName1()))
               odao.insert_product(ame1,su,price1);
            else
               odao.UPDATE1(ame1, su, price1);
            JOptionPane.showMessageDialog(null, "추가되었습니다");
            drink+=su;
            sum+=(price1*su);
            count++;
            break;
         }
         else
            JOptionPane.showMessageDialog(null, "1개이상 입력해주세요", "error", JOptionPane.ERROR_MESSAGE);
         }
         
      }
      
      
      if(e.getSource() == Pay) {
    	  if(count >= 1 ) {
         Count cnt = new Count();
         try {
            cnt.cou();
         } catch (ClassNotFoundException e1) {
            System.out.println("class NOT exception");
         } catch (SQLException e1) {
            System.out.println("SQL Exeption");
         }
         int d = JOptionPane.showConfirmDialog
               (null,"--------결제창---------\n"
                     +cnt.getResult()
                     +"\n---------------------\n"+
                     "총수량 : "+drink+"\n결제액 : "+sum
                     ,"주문창",JOptionPane.YES_NO_OPTION);
         if(d == JOptionPane.YES_OPTION) {
            Point_1 poi = new Point_1();
            try {
               poi.po();
               
            } catch (ClassNotFoundException e1) {
               System.out.println("Class Not Exception");
            } catch (SQLException e1) {
               System.out.println("Sql Exception");
            }
            dispose();
            setVisible(false);
            sum = 0;
            drink = 0;
            popular = "";
            count = 0;
            new Menu().setVisible(true);
         }
         else {
            JOptionPane.showMessageDialog(null,"취소되었습니다","취소창",
                  JOptionPane.ERROR_MESSAGE);
         }
      }
    	  else
    		  JOptionPane.showMessageDialog(null, "주문을 하고 결제를 진행해 주세요","ERROR",
    				  JOptionPane.ERROR_MESSAGE);
            
      }
      
      if(e.getSource() == Cancel) {
    	  sum = 0;
    	  drink = 0;
    	  count = 0;
         odao.ODelete();
         JOptionPane.showMessageDialog(null, "주문이 취소되었습니다", "취소창", JOptionPane.ERROR_MESSAGE);
      }
      
      if(e.getSource() == Join) {

             
             // -- 회원가입 유효성 검사
             boolean k = true;
             String joinNum = null;
             
             while(k) {
             
                joinNum = JOptionPane.showInputDialog("가입번호(핸드폰 뒤 4자리)");
                
                Pattern pattern = Pattern.compile("\\d{4}"); // "//d{4}" 패턴은 숫자 4개가 연속된 것을 의미
             
                Matcher matcher = pattern.matcher(joinNum);
             
                if(matcher.matches()) // 4자리 연속된 숫자이면 true, k를 false로 바꾸면서 while문 빠져나옴
                   k = false;
                else              // 4자리 연속된 숫자가 아니면 false, 에러메세지 출력
                   JOptionPane.showMessageDialog(null, "유효한 번호가 아닙니다.\nForm : 4자리 숫자", "error", JOptionPane.ERROR_MESSAGE);
             
             }
             
             // --- 유효성검사 끝 ---
             
             int jjoinNum = Integer.parseInt(joinNum);
             
             pdao.Select(jjoinNum);
             
             if(jjoinNum == pdao.getNumber()) {
                
                JOptionPane.showMessageDialog(null, "등록된 회원번호입니다.", "error", JOptionPane.ERROR_MESSAGE);
                
             }else {
                
                mdao.MInsert(jjoinNum);
                JOptionPane.showMessageDialog(null, "등록되었습니다.", "시스템창", JOptionPane.INFORMATION_MESSAGE);
                
             }
            
         
      }
      
      
      if(e.getSource() == MDelete) {
    	  
    	  
    	  boolean k = true;
          String deleteNum = null;
          
          while(k) {
          
             deleteNum = JOptionPane.showInputDialog("회원번호(핸드폰 뒤 4자리)");
             
             Pattern pattern = Pattern.compile("\\d{4}"); // "//d{4}" 패턴은 숫자 4개가 연속된 것을 의미
          
             Matcher matcher = pattern.matcher(deleteNum);
          
             if(matcher.matches()) // 4자리 연속된 숫자이면 true, k를 false로 바꾸면서 while문 빠져나옴
                k = false;
             else              // 4자리 연속된 숫자가 아니면 false, 에러메세지 출력
                JOptionPane.showMessageDialog(null, "유효한 번호가 아닙니다.\nForm : 4자리 숫자", "error", JOptionPane.ERROR_MESSAGE);
          
          }
          
          // --- 유효성검사 끝 ---
          
          int ddeleteNum = Integer.parseInt(deleteNum);
          
          pdao.Select(ddeleteNum);
          
          if(ddeleteNum == pdao.getNumber()) {
             
        	  mdao.MDelete(ddeleteNum);
              JOptionPane.showMessageDialog(null, "탈퇴되었습니다", "시스템창", JOptionPane.INFORMATION_MESSAGE);
        	 
          }else {
             
        	  JOptionPane.showMessageDialog(null, "없는번호입니다", "error", JOptionPane.ERROR_MESSAGE);
             
          }
    	 
      }
   }
}