package java07;

import java.util.StringTokenizer;

//당신의 생일은 1990년 12월 4일이고 34살 남자입니다.
//1이면 1900년대 남자 2면 1900년대 여자 3이면 2000이후 남자 4면 2000이후 여자
//String StringBuffer StringTokenizer Wrapper
public class StringStudy {
	private int year = 0;
	private int month = 0;
	private int day = 0;
	private int age  = 0;
	private String gender = null;

	public void setBirth(String front) {
		this.year = Integer.parseInt(front.substring(0, 2));
		this.month = Integer.parseInt(front.substring(2, 4));
		this.day = Integer.parseInt(front.substring(4, 6));
	}
	
	public void setGender(String back) {
		char key = back.charAt(0);
		
		if(key=='1') {
			this.year+=1900;
			this.gender="남자";
		}
		else if(key=='2') {
			this.year+=1900;
			this.gender="여자";
		}
		else if(key=='3') {
			this.year+=2000;
			this.gender="남자";
		}
		else {
			this.year+=2000;
			this.gender="여자";
		}
	}

	
	public void print() {
		System.out.print("당신의 생일은 "+this.year+"년 ");
		System.out.print(this.month+"월 ");
		System.out.print(this.day+"일 이고 ");
		System.out.print((2025-this.year-1)+"살 ");
		System.out.println(this.gender+"입니다.");
	}
	
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("901204-1111111", "-");
		
		String front = st.nextToken();
		String back = st.nextToken();
		
		StringStudy user = new StringStudy();
		user.setBirth(front);
		user.setGender(back);
	
		user.print();
	}
}
