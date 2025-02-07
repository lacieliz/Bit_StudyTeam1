
import java.io.BufferedReader;
import java.io.InputStreamReader;

// input()  정수 하나를 입력 	2~9 사이가 아니면 다시 입력
// output() 구구단 출력

public class MethodStudy {
	private int number;
	
	public void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		while(true) {
			System.out.print("정수 하나를 입력 : ");
			int n = Integer.parseInt(br.readLine());
			
			if(n>1 && n<10) {
				this.number = n; 
				break;
			}
			else System.out.println("다시 입력 하세요.");
		}
	}
	
	public void output() {
		for(int i = 1; i<10; i++) {
			System.out.println(number + " * " + i + " = " + number*i );
		}
	}

	public static void main(String[] args) throws Exception {
		MethodStudy m1 = new MethodStudy();
		m1.input();
		m1.output();
	}

}
