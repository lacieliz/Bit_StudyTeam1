import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_11720 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		String strNum = br.readLine();
		int sum = 0;
		
		for(int i = 0; i<count; i++) {
			sum += strNum.charAt(i) - '0'; // 문자열에서 문자 추출 후 정수 변환
		}
		System.out.println(sum);
	}
}
