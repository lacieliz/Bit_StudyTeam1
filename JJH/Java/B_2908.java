import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		String num1 = st.nextToken();
		String num2 = st.nextToken();
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		for (int i = 2; i >= 0; i--) {
			sb1.append(num1.charAt(i));
			sb2.append(num2.charAt(i));
		}
		System.out.println(Integer.parseInt(sb1.toString()) > Integer.parseInt(sb2.toString()) ? sb1 : sb2);
	}
}