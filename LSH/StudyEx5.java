package java08;

public class ArrayEx5 {

	public static void main(String[] args) {
		int SIZE = 7;
		int m[][] = new int[SIZE][SIZE];
		int cnt = 0;
		//입력
		//5번
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[i].length ;j++) {

	 		if(i==SIZE/2)
					m[i][j] = ++cnt;
				else if(((i+j)>=(SIZE/2)) && ((j-i)<=(SIZE/2)) && i<(SIZE/2))
					m[i][j] = ++cnt;
				else if(((i-j)<=(SIZE/2)) && (i+j)<=(SIZE/2*3) && i>(SIZE/2))
					m[i][j] = ++cnt;
			}
		}
		//출력
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[i].length ;j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
