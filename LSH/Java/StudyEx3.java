package java06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//input() 정수 하나를 입력 ,2~9사이가 아니면 다시 입력. throws Exception 추가.

//output() 구구단 출력
public class HW_MethodStudy {
	
	public void output(int num) {
		
		System.out.println("["+num+"단"+"]");

		for(int i=1; i<10;i++)
		{
			System.out.println(num+" x "+i+" = "+(num*i));
		}
	}
	
	public int input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num =0;
		
			do{
				  System.out.print("2~9사이의 숫자를 입력해주세요 : ");
				  try {
				        num= Integer.parseInt(br.readLine());
				      } catch (NumberFormatException | IOException e) {
					       System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				   }
			}while(num<2 || num>9);
			
			return num;
	}

	public static void main(String[] args) {
		
		HW_MethodStudy hw = new HW_MethodStudy();
		
		int user_input_num = hw.input();
		hw.output(user_input_num);
	}
}
