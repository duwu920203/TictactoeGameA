import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class TicMain {
	
	public static void main(String[] args) {
		
		String[] arr = new String[9];//创建二维数组3*3
		Scanner sc = new Scanner(System.in);
		String str = "-1";
		Random rd = new Random();
		for(int i=0;i<9;i++) {
			
				/*数组赋值*/
				arr[i] = String.valueOf("!");
		
		}
//		String s1 = "";
//		System.out.println("请按数字1-9输入你要下棋的位置！");
//		System.out.println("——————————");
//		for(int i=0;i<9;i++) {
//			
//			
//				s1 = s1 + (String)arr[i] + " | ";
//			if((i)/3 == 0) {
//			System.out.println(s1);
//			System.out.println("——————————");
//			}
//		}
		
		for(int i=0;i<6;) {
			printmsg(arr);
		
			Boolean bl = true;
			str = sc.nextLine();
			System.out.println("str = " + str);
			if(str.length() == 1) {
				if(str.charAt(0) >= '1' && str.charAt(0) <= '9') {
					System.out.println(Integer.valueOf(str)-1);
					if(arr[Integer.valueOf(str)-1] == "!") {
						bl = false;
						i++;
						System.out.println("i = " + i);
						arr[Integer.valueOf(str)-1] = "X";
						System.out.println("arr[] = " +arr[Integer.valueOf(str)-1]);
						if(check(arr, arr[Integer.valueOf(str)-1])) {
							System.out.println("恭喜你，胜利了！");
							printmsg(arr);
							i = 6;
							break;
						}
					}
				}
			}
			while(bl) {
				printmsg(arr);
				str = sc.nextLine();
				if(str.length() == 1) {
					if(str.charAt(0) >= '1' && str.charAt(0) <= '9') {
						if(arr[Integer.valueOf(str)-1] == "!") {
							bl = false;
							i++;
							System.out.println("i = " + i);
							arr[Integer.valueOf(str)-1] = "X";
							System.out.println("arr[] = " +arr[Integer.valueOf(str)-1]);
							if(check(arr, arr[Integer.valueOf(str)-1])) {
								System.out.println("恭喜你，胜利了！");
								break;
							}
						}
					}
				}
				
			}
			
			
			
			int k = rd.nextInt(9)+1;
			Boolean f = true;
			while(f) {
				if(k >= 1 && k <= 9) {
					if(arr[k-1] == "!") {
						arr[k-1] = "O";
						f = false;
						if(check(arr, arr[k-1])) {
							System.out.println("很遗憾，你输了！");
							printmsg(arr);
							i = 6;
							break;
						}
					}
				}
				k = rd.nextInt(9)+1;
			}
		}
	}

	public static void printmsg(String arr[]) {
		
		System.out.println("——————————");
		String s1 = "";
		for(int i=0;i<9;i++) {
			
			
				s1 = s1 + (String)arr[i] + " | ";
			if((i+1)%3 == 0) {
			System.out.println(s1);
			System.out.println("——————————");
			s1 = "";
			}
		}
		System.out.println("请按数字1-9输入你要下棋的位置！");
	}
	
	public static boolean check(String s[],String p){   //
	      String des= p;
	     
	      /*判断横竖斜是否连城线*/
	      if((s[2]==des&&s[5]==des&&s[8]==des)||
	      (s[0]==des&&s[3]==des&&s[6]==des)||
	      (s[1]==des&&s[4]==des&&s[7]==des)||
	      (s[0]==des&&s[2]==des&&s[1]==des)||
	      (s[5]==des&&s[3]==des&&s[4]==des)||
	      (s[8]==des&&s[6]==des&&s[7]==des)||
	      (s[0]==des&&s[4]==des&&s[8]==des)||
	      (s[2]==des&&s[4]==des&&s[6]==des))
	    	 {return true;}else {
	      return false;
	      }
	   }
}
