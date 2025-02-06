import java.util.Arrays;
import java.util.Scanner;

public class B_2480 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numArray[] = new int[3];
		int result =0;
		
		for(int i=0; i<3; i++)
			numArray[i] = sc.nextInt();
		
		
		Arrays.sort(numArray);
		
		if(numArray[0]==numArray[1] && numArray[1]==numArray[2])
			result = 10000+numArray[0]*1000;
		else if(numArray[0]!=numArray[1] && numArray[1]!=numArray[2] && numArray[0]!=numArray[2])
			result = numArray[2]*100;
		else
			result = 1000+numArray[1]*100;
		
		System.out.println(result);
	}
}