public class main {

	public static void main(String[] args) {
		// 5번째																			// if else 를 사용해서 if else 각각에 for 문을 사용하면 쉽기는 함. 그치만 하나로도 가능.

		int SIZE = 5;
		int m[][] = new int [SIZE][SIZE];
		int cnt = 0;
		int a; 
		
		for( int i=0; i<m.length; i++ ) {
			for( int j=0; j<m[i].length; j++ ) {
			a = Math.abs( SIZE/2-i ); 
			if( a <= j && j < SIZE - a )
				
			// 중간 두줄을 주고, 가운데를 주면 되겠는데?
			// if( j == SIZE / 2 || i == SIZE / 2 || ! ( i == 0 || i == SIZE-1 || j == 0 || j == SIZE-1  ) )
			m[i][j] = ++cnt;
			}
		}
		
		// 출력
		for( int i=0; i<m.length; i++ ) {
			for( int j=0; j<m[i].length; j++ ) {
				System.out.print( m[i][j] + "\t" );
			}
			System.out.println();
			}
		
		}
}
