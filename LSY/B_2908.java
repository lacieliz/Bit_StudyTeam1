import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
//		int user1 = Integer.parseInt(br.readLine());	
//		int user2 = Integer.parseInt(br.readLine());	
		
		String [] input = br.readLine().split(" "); 		
		int user1 = Integer.parseInt(input[0]);
		int user2 = Integer.parseInt(input[1]);
		
//		int num[] = { user1 };
		
		String num1 = String.valueOf(user1);
		String num2 = String.valueOf(user2);
		
		char [] usernum1 = { num1.charAt(2), num1.charAt(1), num1.charAt(0) };
		char [] usernum2 = { num2.charAt(2), num2.charAt(1), num2.charAt(0) };
//		char [] charArr1 = num1.toCharArray();
//		char [] charArr2 = num2.toCharArray();	
//		string num1 = charArray1;
	
		user1 = Integer.parseInt(String.valueOf(usernum1));
		user2 = Integer.parseInt(String.valueOf(usernum2));
		
		if( user1 > user2 ) {
			System.out.println( user1 );
		} else {
			System.out.println( user2 );
		}
		
	}

}