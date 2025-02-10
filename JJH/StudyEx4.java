// 당신의 생일은 1990년 12월 4일이고 34살 남자입니다. 
// 1이면 1900년대 남자 2면 1900년대 여자 3이면 2000이후 남자 4면 2000이후 여자


// String StringBuffer StringTokenizer Wrapper
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) {
		StringTokenizer st =new StringTokenizer("900904-2111111", "-");
		StringBuffer sb = new StringBuffer("");
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken()); // 9012041111111
		}
		
		String s = (sb.charAt(6) == '1') || (sb.charAt(6) == '3') ? "남자" : "여자";
		int Year = (sb.charAt(6) == '1') || (sb.charAt(6) == '2') ? 1900 : 2000;
		int year = Year + Integer.parseInt(sb.substring(0,2));
		int month = Integer.parseInt(sb.substring(2,4));
		int day = Integer.parseInt(sb.substring(4,6));
		int age = 2025-year;

		System.out.println("당신의 생일은 " + year + "년 " + month + "월 " + day + "일이고 " + age + "살 " + s + "입니다.");
	}
}
