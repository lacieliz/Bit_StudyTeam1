//당신의 생일은 1990년 12월 4일이고 34살 남자입니다. 
//1이면 1900년대 남자 2면 1900년대 여자 3이면 2000이후 남자 4면 2000이후 여자

//String StringBuffer StringTokenizer Wrapper

import java.util.StringTokenizer;
public class Main {

//	String a;
	static String sex;	// 왜 static 이어야 에러가 풀릴까?
	
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer( "901204-1111111", "-" );
		// | 9 | 0 | 1 | 2 | 0 | 4 |				// 문자열 두개를 따로 받을건지, 합쳐서 받을건지 선택 Hint : 합쳐서 받는 게 빠름
		// | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
		
		String birth = st.nextToken();			
		
		while(st.hasMoreTokens() == true) {
			sex = st.nextToken();
		} 
		
//		System.out.println(sex);					// 1111111

		int year;
		String tsex;
//		DistinguishSex sx = new DistinguishSex();
		if( sex.charAt(1) == '1' ) {
//			System.out.println( "1900년대 남자" );
			year = 19;
			tsex = "남자";
		} else if( sex.charAt(1) == '2' ) {
//			System.out.println( "1900년대 여자" );
			year = 19;
			tsex = "여자";
		} else if( sex.charAt(1) == '3' ) {
//			System.out.println( "2000년대 남자" );
			year = 20;
			tsex = "남자";
		} else {
//			System.out.println( "2000년대 여자" );
			year = 20;
			tsex = "여자";
		}

		String birthyear;
		birthyear = year + birth.substring(0,2);
		int age;
		age = 2025 - Integer.valueOf(birthyear);
			
		System.out.println( "당신의 생일은 " + year + birth.substring(0,2) + "년 " + birth.substring(2,4) + "월 " + birth.substring(4,6) + "일이고 " + age + "살 "  + tsex + "입니다.");

	}
}
