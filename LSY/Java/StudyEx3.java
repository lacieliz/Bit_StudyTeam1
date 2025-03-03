package java06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// input() 	정수 하나를 입력. 2~9사이가 아니면 다시 입력					// 여기도 입력 받아야 하니 throws Exception 추가 해야 함. 
// output() 구구단 출력

public class MethodStudy {
	
	public int input() throws Exception {
    	 
    	 BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
    	 System.out.println( "정수를 입력해주세요. (2~9)" );
    	 int a = Integer.parseInt( br.readLine() );
    	 
    	 while( true ) {
    		 
		 if( a < 2 || a > 9 ) {
			 
			 System.out.println();
			 System.out.println( "정수를 다시 입력해주세요. (2~9)" );
	    	 a = Integer.parseInt( br.readLine() );
	    	 
			 } else break;
    	 }
    	 return a;
     }
     
     public void output( int a ) {
    	 
    	 System.out.println();
    	 System.out.println( "[ " + a + "단 ] " );

    	 for( int i=1; i < 10; i++ ) {
    		 
    		 System.out.println( a + " * " + i + " = " + (a*i) );
    	 }
	}

	public static void main(String[] args) throws Exception {	// 입력 받아야 된다는 얘기겠지?		// input 에서 예외를 던지면 main 으로는 날라오기에 두번 적어야 함.
		
		MethodStudy me = new MethodStudy();
		me.output( me.input());

	}

}