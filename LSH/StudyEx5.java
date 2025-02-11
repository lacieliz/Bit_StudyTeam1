package java08;

public class ArrayEx5 {

	public static void main(String[] args) {
		int SIZE = 7;
		int m[][] = new int[SIZE][SIZE];
		int cnt = 0;
		int mid = SIZE/2;
		//입력
		//5번
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[i].length ;j++) {
	 		if(i==mid)
				m[i][j] = ++cnt;
			else if(((i+j)>=mid) && ((j-i)<=mid) && i<mid)
				m[i][j] = ++cnt;
			else if(((i-j)<=mid) && (i+j)<=(mid*3) && i>(mid))
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
