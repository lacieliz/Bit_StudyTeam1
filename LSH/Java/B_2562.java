import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int SIZE = 9;

	public static int findIndex(int[] num, int radix) {
		for(int i=0;i<9;i++)
		{
			if(num[i]==radix)
				return i+1;
		}
		return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] num = new int[SIZE];
		int[] radix = new int[SIZE];
		
		for(int i=0;i<SIZE;i++)
		{
			num[i] = Integer.parseInt(br.readLine());
			radix[i] = num[i];
		}
		Arrays.sort(radix);
		
		System.out.println(radix[SIZE-1]);
		System.out.println(findIndex(num, radix[SIZE-1]));
	}

}