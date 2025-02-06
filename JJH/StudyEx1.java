import java.io.BufferedReader;
import java.io.InputStreamReader;

//1~100사이의 난수를 2개 발생하여 덧셈을 맞추는 게임
//10문제만 풀기
//[1] 25 + 36 = 100
//틀렸다...정답 : 61
//[2] 50 + 36 = 86
//맞았다
//... 정답 개수 : XX개
//점수 : XX점 하나당 10점
//문제를 더 풀지를 묻는다.
//'Y' 또는 'y' 입력되면 다시 10문제를 출제한다.
//'Y' 또는 'y' 이외의 값이 입력되면 프로그램 종료

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char retry;
		
		do {
			int cnt = 0;
			
			for(int i = 0; i < 10; i++) {
				
				int a = (int)(Math.random()*100) + 1;
				int b = (int)(Math.random()*100) + 1;
				
				System.out.print(i+1 + "번 문제 : " + a + " + " + b + " = ");
				int input = Integer.parseInt(br.readLine());
				
				if (input == (a+b)) {
					System.out.println("맞았다.");
					cnt += 1;
				} else {
					System.out.println("틀렸다. 정답 : " + (a+b));
				}
			}
			
			System.out.println("정답 개수 : " + cnt);
			System.out.println("점수 : " + cnt*10);	
			
			System.out.println("다시 하려면 Y 또는 y 입력");
			retry = (char)br.read();
			br.read();
			br.read();
			
		} while(retry == 'y' || retry == 'Y');
	}
}