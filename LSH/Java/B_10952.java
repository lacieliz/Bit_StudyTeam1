import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		int A = 0;
		int B = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> dynamicArray = new ArrayList<Integer>();
		
		do{
			String[] num = br.readLine().split(" ");

			A = Integer.parseInt(num[0]);
			B = Integer.parseInt(num[1]);
			
			dynamicArray.add(A+B);			
		}while(A!=0 && B!=0);
		
		for(int i=0;i<dynamicArray.size()-1;i++)
		{
			System.out.println(dynamicArray.get(i));
		}
		br.close();
	}
}
