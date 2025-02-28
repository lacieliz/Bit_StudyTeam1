package wed_250212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_3052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int SIZE = 10;
		int num[] = new int[SIZE];
		int mod[] = new int[SIZE];
		
		for(int i=0; i<SIZE; i++) { //num으로 입력받은 후 42로 나눈 나머지를 mod에 저장
			num[i] = Integer.parseInt(br.readLine());
			mod[i] = num[i]%42;
		}
		
		Arrays.sort(mod); //오름차순 정렬
		int count = 1;
		int compare = mod[0];
		
		for(int i=0; i<SIZE;i++){
			if(compare!=mod[i]){ //서로 다른 나머지수 카운트
				compare=mod[i];
				count++;
			}
		}
		System.out.println(count); //출력
	}
}
