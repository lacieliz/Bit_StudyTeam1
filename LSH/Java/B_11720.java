import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		String s = br.readLine();
		String[] arr = s.split("");
		
		for(int i=0; i<N; i++)
			sum+=Integer.parseInt(arr[i]);
		
		System.out.println(sum);
		
		br.close();	
	}
}
