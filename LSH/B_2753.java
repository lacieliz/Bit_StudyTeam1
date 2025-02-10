import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int year = Integer.parseInt(br.readLine());
		int isYear = 0;
		
		if((year%4)==0 && (year%100)!=0)
			isYear = 1;
		else if((year%400)==0)
			isYear = 1;
		
		System.out.println(isYear);
		br.close();	
	}
}
