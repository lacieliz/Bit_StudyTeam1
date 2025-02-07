package java06;

public class HW_ClassStudy {
	private int kor=0;
	private int eng = 0;
	private int mat = 0;
	
	private int sum = 0;
	private float avg =0;

	public HW_ClassStudy(int kor, int eng, int mat) {		
		setKor(kor);
		setEng(eng);
		setMat(mat);
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}
	public int total() {	
		sum = getKor()+getEng()+getMat();
		return sum;
	}
	public float average() {
		avg = total() / 3f;
		return avg;
	}
	
	public String pass() {
		if(avg>60)
		  return "합격입니다.";
		else
		  return "불합격입니다.";
	}
	public static void main(String[] args) {
		HW_ClassStudy cs = new HW_ClassStudy(75, 88, 91);
		System.out.println("총점 : "+cs.total());
		System.out.println("평균 : "+cs.average());
		System.out.println("당락 : "+cs.pass());
		
	}

}
