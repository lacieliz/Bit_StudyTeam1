
public class ClassStudy {
	private int kor;
	private int eng;
	private int mat;
	
	public ClassStudy() {}
	
	public ClassStudy(int kor, int eng, int mat) {
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public int total() {
		return kor+eng+mat;
	}
	public double average() {
		return (kor+eng+mat) / 3.0;
	}
	public String pass() {
		if ((kor+eng+mat) / 3.0 < 70) {
			return "불합격";
		}
		else return "합격";
	}
		
	public static void main(String[] args) {
		// 점수 입력
		ClassStudy cs = new ClassStudy( 75, 88, 91 );
		
		System.out.println("총점 : " + cs.total() );  		// 총점 : 254
		System.out.println("평균 : " + cs.average());  		// 평균 : 84.66666
		System.out.println("당락 : " + cs.pass());	 		// 당락 : 합격		평균 70점 미만이면 불합격
		
	}

}
