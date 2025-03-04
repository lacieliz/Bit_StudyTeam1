import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_3052 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num[] = new int [10];
		int count = 1;
		int temp = 0;
		
		for (int i = 0; i < 10; i++) {
			num[i] = Integer.parseInt(br.readLine()) % 42;
		}
		
		for(int i = 0; i<10; i++) {
			for(int j = i; j<10; j++) {
				if(num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if(num[i] != num[i+1]) count++;
		}
		System.out.println(count);
	}
}