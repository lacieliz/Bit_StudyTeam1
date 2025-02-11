package java08;

import java.util.Iterator;

public class ArrayEx5 {

	public static void main(String[] args) {
		int SIZE = 7;
		int m[][] = new int[SIZE][SIZE];
		int cnt = 0;
		// 입력
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if(SIZE%2==1) { // SIZE -> 홀수
					if( j-i <= SIZE/2 && i-j <= SIZE/2 && i+j >= SIZE/2 && i+j <= SIZE/2*3 ) m[i][j] = ++cnt;	
				}		//   좌하단 제외       우상단 제외         좌상단 제외        우하단 제외  
				else {	// SIZE -> 짝수
					if( j-i <= SIZE/2 && i-j <= SIZE/2 && i+j >= SIZE/2-1 && i+j <= SIZE+(SIZE/2-1) ) m[i][j] = ++cnt;
				}      
			}
		}
	
		// 출력
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + "\t" );
			}
			System.out.println();
		}
	}
}