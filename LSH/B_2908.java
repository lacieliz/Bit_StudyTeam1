import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public int Reverse(String[] input, int start) {
		int num =0;
		
		for(int i=0;i<=2;i++)
		{
			num+=Integer.parseInt(input[start])*(Math.pow(10, i));
			start++;
		}
		return num;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine().replaceAll(" ",""); 
		String[] input = s.split("");
		
		Main fun = new Main();
		int num[] = new int[2];
		for(int i=0; i<2; i++)
		{
			num[i]=fun.Reverse(input, i*3);
		}
		
		int large = (num[0]>=num[1]?num[0]:num[1]);
		System.out.println(large);

	}

}