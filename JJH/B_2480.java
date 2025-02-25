import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		int sum = 0;
		int [] numArray = new int [3];
		
		for(int i = 0; i<3; i++) {
			numArray[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(numArray);
		
		
		if(numArray[0] == numArray[1] && numArray[1] == numArray[2]) { 
			sum = 10000 + numArray[0]*1000;
		}
		else if(numArray[0] != numArray[1] && numArray[1] != numArray[2] && numArray[2] != numArray[0]) { // 다 다르면
			sum = numArray[2]*100;
		}
		else { 
			sum = 1000+numArray[1]*100;
		}
		System.out.println(sum);
	}

}