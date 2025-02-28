package java12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

class MyAddress{									// Bean Class 바구니 용도 DTO
	private String name;
	private int age;
	private String tel;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}

public class AddressBookStudy2 {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private boolean isSearch ;					// 검색 여부 저장	멤버변수 boolean false로 자동 초기화 / 
	
	public static Vector<MyAddress> v = new Vector<MyAddress>();
	
	public String menu() throws IOException{
		System.out.println();
		System.out.println("\t1. 주소록저장");
		System.out.println("\t2. 주소록검색");
		System.out.println("\t3. 주소록수정");
		System.out.println("\t4. 전체보기");
		System.out.println("\t5. 주소록삭제");
		System.out.println("\t0. 프로그램종료");
		System.out.print("\t메뉴 선택 : ");
		return br.readLine();
	}
	
	public void bookStart() throws IOException{
		MyAddress ma = null;
		while(true) {
			switch(menu()) {
			case "1": add(); break;									// 저장
			case "2":  												// 검색
				isSearch = true;
				ma = search();
				if(ma == null) {
					System.out.println("\t<<검색한 사람이 없습니다.>>");
					isSearch = false;
				}
				break;							
			case "3": 												// 수정
				if(isSearch) {
					modify(ma);
					isSearch = false;
				}
					
				else
					System.out.println("\t검색을 먼저 수행해야 합니다.");
				break;							
			case "4": 												// 출력
				list();
				break;							
			case "5": 												// 삭제
				if(isSearch) {
					delete(ma);
					isSearch = false;
				}
				else
					System.out.println("\t검색을 먼저 수행해야 합니다.");
				break;							
			case "0": return;										// 종료
			}
		}
	}
	
	public void add() throws IOException{							// 저장
		MyAddress newAddress = new MyAddress();
		System.out.println();
		System.out.print("\t이름 : " );
		newAddress.setName(br.readLine());
		System.out.println("\t나이 : ");
		newAddress.setAge(Integer.parseInt(br.readLine()));
		System.out.print("\t전화번호 : " );
		newAddress.setTel(br.readLine());
		System.out.print("\t주소 : " );
		newAddress.setAddress(br.readLine());
		
		AddressBookStudy2.v.add(newAddress);
		
		System.out.println("\t<<성공적으로 저장했습니다>>");
		
		System.out.println("\t전체 주소 수 " + v.size());
	}
	public MyAddress search() throws IOException{					// 검색
		// 전체 출력을 해서 원하는 주소를 선택하던지 
		// 한명만 출력해서 원하는 주소는 선택하고 아니면 다음 주소로 이동
		
		// 이름, 전화번호, 주소로 검색 선택
		System.out.println();
		System.out.println("\t 찾을 이름 : ");
		String name = br.readLine();
		MyAddress ma = null;
		for (int i = 0; i < AddressBookStudy2.v.size(); i++) {
			ma = AddressBookStudy2.v.get(i);
			if(name.equals(ma.getName())) {
				System.out.println("\t이름 : " + ma.getName());
				System.out.println("\t나이 : " + ma.getAge());
				System.out.println("\t전화번호 : " + ma.getTel());
				System.out.println("\t주소 : " + ma.getAddress());
				break;
			}
		}
		if(ma == null)
			return null;
		else
			return ma;
	}
	public void modify(MyAddress ma) throws IOException {								// 수정
		System.out.println();
		System.out.println("\t1. 나이를 수정");
		System.out.println("\t2. 전화번호를 수정");
		System.out.println("\t3. 주소를 수정");
		System.out.println("\t0. 정보수정 취소");
		System.out.print("\t메뉴 선택 : ");
		
		MyAddress m = new MyAddress();
		m.setName(ma.getName());
		m.setAge(ma.getAge());
		m.setTel(ma.getTel());
		m.setAddress(ma.getAddress());
		
		switch (br.readLine()) {
		case "1":
			System.out.println("\t수정할 나이 : " );
			m.setAge(Integer.parseInt(br.readLine()));
			break;
		case "2":
			System.out.println("\t수정할 전화번호 : " );
			m.setTel(br.readLine());
			break;
		case "3":
			System.out.println("\t수정할 주소 : " );
			m.setAddress(br.readLine());
			break;
		case "0": return;
		}
		AddressBookStudy2.v.remove(ma);
		AddressBookStudy2.v.add(m);
		search();
	}
	public void list() {																// 출력  
		// 이름, 전화번호, 주소 선택해서 정렬
		for (int i = 0; i < AddressBookStudy2.v.size()-1; i++) {						// 기준
			for (int j = i+1; j < AddressBookStudy2.v.size(); j++) {					// 비교
				MyAddress mi = AddressBookStudy2.v.get(i); 
				MyAddress mj = AddressBookStudy2.v.get(j);
				if( mi.getName().compareTo(mj.getName()) > 0  ) {
					AddressBookStudy2.v.remove(i);
					AddressBookStudy2.v.add(i, mj);
					AddressBookStudy2.v.remove(j);
					AddressBookStudy2.v.add(j, mi);		
				}
			}
		}
		System.out.println("\t이름\t나이\t번호\t주소");
		for (int i = 0; i < AddressBookStudy2.v.size(); i++) {
			MyAddress ma = AddressBookStudy2.v.get(i);
			System.out.println(
					"\t" + ma.getName()
					+"\t" + ma.getAge()
					+"\t" + ma.getTel()
					+"\t"+ma.getAddress()
					);
		}
		
	}
	public void delete(MyAddress ma) {								// 삭제
		for (int i = 0; i < AddressBookStudy2.v.size(); i++) {
			MyAddress m = AddressBookStudy2.v.get(i);
			if(ma.getName().equals(m.getName()) && ma.getTel().equals(m.getTel())) {
				AddressBookStudy2.v.remove(i);
				break;
			}
		}
		System.out.println("\t<<성공적으로 삭제했습니다>>");
		System.out.println("\t전체 주소 수 : " + AddressBookStudy2.v.size());
	}

	public static void main(String[] args) throws IOException{
		AddressBookStudy2 abs = new AddressBookStudy2();
		abs.bookStart();
	}
}
