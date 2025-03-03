import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		int num1;
		int num2;
		int num3;
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		System.out.println( " 주사위 눈금을 입력해주세요. ");
//		int a = Integer.parseInt( br.readLine() );
//		int b = Integer.parseInt( br.readLine() );
//		int c = Integer.parseInt( br.readLine() );
		String [] input = br.readLine().split(" "); 
		
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		
//		num1 = a;
//		num2 = b;
//		num3 = c;
		
		if( a == b && b == c) {
			System.out.println("축하합니다. 주사위 눈 3개가 일치하여 상금 : " + (10000 + (a * 1000)) + "원 을 획득하셨습니다." );
		} else if( a == b || a == c ) {
			System.out.println("축하합니다. 주사위 눈 2개가 일치하여 상금 " + (1000 + (a * 100))  + "원 을 획득하셨습니다.");
		} else if ( b == c ) {
			System.out.println("축하합니다. 주사위 눈 2개가 일치하여 상금 " + (1000 + b * 100)  + "원 을 획득하셨습니다.");
		} else {
			System.out.println("아쉽게도 일치한 주사위 눈금이 없어 상금 " + Math.max(a, Math.max( b, c ))*100 + "원 을 획득하셨습니다.");
		}
//		} else if ( a > b && a > c ) {
//			System.out.println( "아쉽게도 일치한 주사위 눈금이 없어 상금 " + a*100 + "원 을 획득하셨습니다.");
//		} else if ( b > c && b > a ) {
//			System.out.println( "아쉽게도 일치한 주사위 눈금이 없어 상금 " + b*100 + "원 을 획득하셨습니다.");
//		} else if ( c > a && c > b ) {
//			System.out.println( "아쉽게도 일치한 주사위 눈금이 없어 상금 " + c*100 + "원 을 획득하셨습니다.");
//		}
		

	}

}
