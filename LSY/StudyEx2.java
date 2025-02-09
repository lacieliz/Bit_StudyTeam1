<<<<<<< HEAD

package java06;

public class ClassStudy {
	// 필드 선언
	private int a;
	private int b;
	private int c;
	
	// 생성자 선언
	ClassStudy( int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		
	}
	// 메소드 선언
	public int total() {
		return a + b + c;
	}
	
	public double average() {
		return (a + b + c) / 3.0;
	}
	
//	public String d() {
//		if((a + b + c) / 3 > 70 ) {
//			System.out.println( "합격" );
//	}
	
	public String pass() {
		if((a + b + c) / 3 > 70 ) {					
			return "합격";
		} else return "불합격";
	}
//		if((a + b + c) / 3 > 70 ) {					// 호호 이게 아니라 return 을 여기다가 쓰면 되는구나?
//			System.out.println( "합격" );
//		} else {
//			System.out.println( "불합격" );
//		}
	
	public static void main(String[] args) {
		// 점수 입력
		ClassStudy cs = new ClassStudy( 75, 88, 91 );	// 받아주는 생성자가 없어서 에러		받아줘야겠지?
														// 점수 입력 받고, setter getter 는 여기서 중요한 게 아니라서 빼주심

		System.out.println( "총점 : " + cs.total() ); 	// 총점 : 254점
		System.out.println( "평균 : " + cs.average() );	// 평균 : 84.6666
		System.out.println( "당락 : " + cs.pass() );		// 당락 : 합격			평균이 70점 미만이면 불합격

							
	}

}

// this 까지 다 사용해야 하고, 변수 이런것도 다 설정해야 함
// + 최대한 코드를 줄여보기

// 참 재밌겠다 ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ
// 오예 신난다
// 오와아아앙아아
=======

package java06;

public class ClassStudy {
	// 필드 선언
	private int a;
	private int b;
	private int c;
	
	// 생성자 선언
	ClassStudy( int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		
	}
	// 메소드 선언
	public int total() {
		return a + b + c;
	}
	
	public double average() {
		return (a + b + c) / 3.0;
	}
	
//	public String d() {
//		if((a + b + c) / 3 > 70 ) {
//			System.out.println( "합격" );
//	}
	
	public String pass() {
		if((a + b + c) / 3 > 70 ) {					
			return "합격";
		} else return "불합격";
	}
//		if((a + b + c) / 3 > 70 ) {					// 호호 이게 아니라 return 을 여기다가 쓰면 되는구나?
//			System.out.println( "합격" );
//		} else {
//			System.out.println( "불합격" );
//		}
	
	public static void main(String[] args) {
		// 점수 입력
		ClassStudy cs = new ClassStudy( 75, 88, 91 );	// 받아주는 생성자가 없어서 에러		받아줘야겠지?
														// 점수 입력 받고, setter getter 는 여기서 중요한 게 아니라서 빼주심

		System.out.println( "총점 : " + cs.total() ); 	// 총점 : 254점
		System.out.println( "평균 : " + cs.average() );	// 평균 : 84.6666
		System.out.println( "당락 : " + cs.pass() );		// 당락 : 합격			평균이 70점 미만이면 불합격

							
	}

}

// this 까지 다 사용해야 하고, 변수 이런것도 다 설정해야 함
// + 최대한 코드를 줄여보기

// 참 재밌겠다 ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ
// 오예 신난다
// 오와아아앙아아
>>>>>>> 30c52ac4e031f9f1a4e38e30923b19a4cd109558
// 이거 풀면 클래스 다 이해한거겠네? 이야ㅑㅑㅑㅑㅑ