import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2562 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num[] = new int[9];
		int max = 0;
		int index = 0;
		for (int i = 0; i < 9; i++) {
			num[i] = Integer.parseInt(br.readLine());
			
			if(max < num[i]) {
				max = num[i];
				index = i+1;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}
