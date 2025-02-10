import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strNum = new String[100];
		int n = 0;
		while(true) {
			strNum[n] = br.readLine();
			
			if(strNum[n].equals("0 0"))	// 문자열 비교는 equals()
				break;
			n++;
		}
		
		for(int i = 0; i<n; i++) {			// 문자를 정수로 할때는 - '0'
			System.out.println(strNum[i].charAt(0) - '0' + strNum[i].charAt(2) - '0');
		}		
	}
}
