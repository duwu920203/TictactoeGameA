import java.util.Random;
import javax.swing.*;

/**
 * @description 三子棋
 * @create 2023/03/01
 */

public class Main {
  
   public static void main(String[] args) {
      StringBuffer s= new StringBuffer("0123456789");
      String tp;
      
      for(int i=0;i<=5;){
         int k=-1;
         tp=JOptionPane.showInputDialog("—————————\n|    "+s.charAt(1)+"    |    "+s.charAt(2)+"    |    "+s.charAt(3)+"    |\n—————————\n|    "+s.charAt(4)+"    |    "+s.charAt(5)+"    |    "+s.charAt(6)+"    |\n—————————\n|    "+s.charAt(7)+"    |    "+s.charAt(8)+"    |    "+s.charAt(9)+"    |\n—————————\n"+"请输入落子位置(1~9)：");
         boolean f=true;
         /*解决直接关闭弹窗程序报错*/
         if(tp == null) {
         	return;
         }
         if(tp.length()==1){
            k=tp.charAt(0)-'0';
            if(k>=1&&k<=9){
               if(s.charAt(k)>='1'&&s.charAt(k)<='9'){
                  i++;        //有效下棋
                  f=false;
               }
            }
         }
         while(f){
            tp=JOptionPane.showInputDialog("—————————\n|    "+s.charAt(1)+"    |    "+s.charAt(2)+"    |    "+s.charAt(3)+"    |\n—————————\n|    "+s.charAt(4)+"    |    "+s.charAt(5)+"    |    "+s.charAt(6)+"    |\n—————————\n|    "+s.charAt(7)+"    |    "+s.charAt(8)+"    |    "+s.charAt(9)+"    |\n—————————\n"+"输入错误，请重新输入落子的位置：");
            /*解决直接关闭弹窗程序报错*/
            if(tp == null) {
            	return;
            }
            if(tp.length()==1){
               k=tp.charAt(0)-'0';
               if(k>=1&&k<=9){
                  if(s.charAt(k)>='1'&&s.charAt(k)<='9'){
                     i++;        //有效下棋
                     f=false;
                  }
               }
            }
         }
         //在k处落子
         s.replace(k,k+1,"O");
         if(CheckResult.check(s,k)){
            //获胜
            JOptionPane.showMessageDialog(null,"—————————\n|    "+s.charAt(1)+"    |    "+s.charAt(2)+"    |    "+s.charAt(3)+"    |\n—————————\n|    "+s.charAt(4)+"    |    "+s.charAt(5)+"    |    "+s.charAt(6)+"    |\n—————————\n|    "+s.charAt(7)+"    |    "+s.charAt(8)+"    |    "+s.charAt(9)+"    |\n—————————\n"+"恭喜你，你赢了！");
            break;                              
         }
         //电脑随机落子
         if(i==5) {
            JOptionPane.showMessageDialog(null,"—————————\n|    "+s.charAt(1)+"    |    "+s.charAt(2)+"    |    "+s.charAt(3)+"    |\n—————————\n|    "+s.charAt(4)+"    |    "+s.charAt(5)+"    |    "+s.charAt(6)+"    |\n—————————\n|    "+s.charAt(7)+"    |    "+s.charAt(8)+"    |    "+s.charAt(9)+"    |\n—————————\n"+"平局！");
            break;
         }
         Random rs=new Random();
         k=rs.nextInt(9)+1;
         while(k<1||k>9||s.charAt(k)=='*'||s.charAt(k)=='O') k=rs.nextInt(9)+1;
         s.replace(k,k+1,"*");
         if(CheckResult.check(s,k)){
            //电脑胜
            JOptionPane.showMessageDialog(null,"—————————\n|    "+s.charAt(1)+"    |    "+s.charAt(2)+"    |    "+s.charAt(3)+"    |\n—————————\n|    "+s.charAt(4)+"    |    "+s.charAt(5)+"    |    "+s.charAt(6)+"    |\n—————————\n|    "+s.charAt(7)+"    |    "+s.charAt(8)+"    |    "+s.charAt(9)+"    |\n—————————\n"+"你输了，再接再厉吧！");
            break;
         }
      }
   }
}