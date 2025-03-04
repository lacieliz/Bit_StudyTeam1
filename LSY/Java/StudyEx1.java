public class WhileStudy2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
//		char eng;
		String eng;
		
		do {													
			
			int cnt = 0;
			int tot = 0;
			
			for( int i=1; i <= 10; i++) {
				
				int a = (int)( Math.random() * 100 ) + 1;	// 1 ~ 100		
				int b = (int)( Math.random() * 100 ) + 1;	// 1 ~ 100
				System.out.print( "[ " + i + "번 문제 ] " + a + " + " + b + " : " );
				
				int user = Integer.parseInt(br.readLine());	
				
						if( user == a+b ) {
							System.out.println( "맞았다" );
							cnt += 1;
							tot = cnt*10;
						} else {
							
							System.out.println( "틀렸다" + "\t" + "정답 : " + (a + b) );
						}

					}
			
					System.out.println();								// 얘를 위에다 적으면 좋겠네
					System.out.println( "정답 개수 : " + cnt + " 개" );
					System.out.println( "정답 : " + tot + " 점" );
					System.out.println();
					System.out.print( " 문제 더 풀거야? " );
//					eng = (char)br.read();
//					br.readLine();							// 라인을 읽어주는 건 가능하고, 왜 System.in.read(); 두번으로 엔터 버퍼 없애주는 건 안되는거?
					eng = br.readLine();
				
			} while( eng == "Y" || eng == "y" );			// 문자열은 등호로 비교하면 주소값이랑 비교하기에 절대 안 같음.
															// equals 로 비교해야 함.	
			
			
			