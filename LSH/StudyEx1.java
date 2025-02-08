package java05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudyEx1 {
	public void game(BufferedReader br) {
		int count = 0;
		int num = 0;
		System.out.println("총 10개의 문제가 출제됩니다.");
		do {
		     num++;
		     int a = (int)(Math.random()*100)+1; //1~100
		     int b = (int)(Math.random()*100)+1; //1~100
		     int answer = a+b;
			
		     System.out.println("["+num+"] "+a+" + "+b+" = ");
		     int input;
			 try {
				    input = Integer.parseInt(br.readLine());
				
				    if(input==answer) {
				       count++;
				       System.out.println("정답입니다! 정답 개수 : "+count+"개");
			         }
			         else{
				        System.out.println("틀렸습니다.ㅠㅠ 정답은 : "+answer+"입니다.");
			         }	
			      } catch (NumberFormatException | IOException e) {
                         System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                         num--;
                }    
		 }while(num<10);
		 System.out.println("모든 문제를 풀었습니다.\n정답 개수 : "+count+"\n점수 : "+count*10);
	}

	public static void main(String[] args) throws IOException {

		char key = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			boolean exe = true;
			while(exe) {
				System.out.println("====================================");
				System.out.println("1~100 사이의 숫자 2개의 합을 구하는 게임입니다.");
				System.out.println("게임을 시작하시겠습니까? (Y or N):");

				key = br.readLine().charAt(0);

				if(key=='Y' || key=='y') {
					StudyEx1 hw = new StudyEx1();
					hw.game(br);
				}
				else if(key=='N' || key=='n'){
					System.out.println("프로그램이 종료됩니다.\n");
					exe = false;
				}
				else
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
			}
	}
}
