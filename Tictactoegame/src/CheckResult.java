/**
 * 
 * @description 检查棋子有没有获胜
 */
public class CheckResult {
	 public static boolean check(StringBuffer st,int pos){   //
	      char des=st.charAt(pos);
	      char []s=new char[10];
	      /*判断横竖斜是否连城线*/
	      for(int i=1;i<=9;i++) s[i]=st.charAt(i);
	      if((s[3]==des&&s[6]==des&&s[9]==des)||
	      (s[1]==des&&s[4]==des&&s[7]==des)||
	      (s[2]==des&&s[5]==des&&s[8]==des)||
	      (s[1]==des&&s[3]==des&&s[2]==des)||
	      (s[6]==des&&s[4]==des&&s[5]==des)||
	      (s[9]==des&&s[7]==des&&s[8]==des)||
	      (s[1]==des&&s[5]==des&&s[9]==des)||
	      (s[3]==des&&s[5]==des&&s[7]==des)) return true;
	      return false;
	   }
}
