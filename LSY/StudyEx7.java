package Exercise;

// 아직 수정 필요
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;

class MyAddress	{				// 한 명의 데이터를 관리할 용도의 Bean Class(바구니 용도) 
//	이름 나이 전화번호 주소
	private String name;
	private int age;
	private String tel;
	private String address;
	int num;
	
	public String getName() { return name; }
	public int getAge() { return age; }
	public String getTel() { return tel; }
	public String getAddress() { return address; }
	
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	public void setTel(String tel) { this.tel = tel; }
	public void setAddress(String address) { this.address = address; }
	
	public void MyAddress( String name, int age, String tel, String address) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.address = address;
	}	
	
	public void run() throws IOException {
		System.out.println();
		System.out.println( "\t1. 주소록저장" );
		System.out.println( "\t2. 주소록검색" );
		System.out.println( "\t3. 주소록수정" );
		System.out.println( "\t4. 전체보기" );
		System.out.println( "\t5. 주소록삭제" );
		System.out.println( "\t0. 프로그램종료" );
		System.out.println( "\t메뉴선택 : " );
		BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ));
		int num = Integer.parseInt( br.readLine() );
		if( num == 1 || num == 2 || num == 0 ) {
			this.num = num;
		} else if( num == 3 || num == 4 || num == 5 ) { 	// 숫자 3,4,5 라면 2. 주소록 검색으로 돌아갈 수 있도록 만들기 
			do {
				System.out.println( "검색을 먼저 수행해야 합니다." );
				num = Integer.parseInt( br.readLine() );
			} while ( num == 3 || num == 4 || num == 5 );
			this.num = num;
		} else {
			System.out.println( "메뉴 번호를 다시 입력해주세요. (0 ~ 5)" );
			num =Integer.parseInt( br.readLine() );
			this.num = num;
		}
	}
}

public class AddressBookStudy extends MyAddress {
//	class Store extends MyAddress {						// 클래스로 잡지 않고 이렇게 두면 가능해지려나?
	BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ));
	MyAddress ma = new MyAddress();
	Vector <String[]> v = new Vector<> ();
	String [] user;
	public void store() throws IOException {
//		MyAddress ma = new MyAddress();
//		String [] user = { name, String.valueOf(age), tel, address };
//		Vector <String[]> v = new Vector<> ();
		System.out.println( "이름 : " );
			String name = br.readLine();
			ma.setName(name);
		System.out.println( "나이 : " );
			int age = Integer.parseInt( br.readLine() );
			ma.setAge(age);
		System.out.println( "전화번호 : " );
			String tel = br.readLine();
			ma.setTel(tel);
		System.out.println( "주소 : " );
			String address = br.readLine();
			ma.setAddress(address);		
		user = new String[] { name, String.valueOf(age), tel, address };
		if( v.add( user ) == true ) {
			System.out.println( "성공적으로 저장했습니다." );
			System.out.println( Arrays.toString(user) );
		}
	}
//}

//	class Search extends Store {		// 상속받아도 객체를 생성해야할 때가 있나?
//	BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ));
	public String[] search;
	public String searchName;
	public void search() throws IOException {
		System.out.println( "검색이름 : ");
		String searchName = br.readLine();
		this.searchName = searchName;
		for( int i=0; i<v.size(); i++) {
			Arrays.toString(v.get(i));
			if( user[0].equals(searchName) == true ) {
				search = v.get(i);
				System.out.println( Arrays.toString( search ) );
			} else { 
			System.out.println( searchName + "님은 없습니다." );
			}
		}
	}
	
	public void fix( ) throws IOException {
		System.out.println( searchName + "님의 정보를 수정하시겠습니까? ");
		System.out.println( "1. 나이를 수정" );					
		System.out.println( "2. 전화번호 수정" );
		System.out.println( "3. 주소를 수정" );
		System.out.println( "0. 수정 취소" );
		System.out.println( "메뉴선택 : " );
		int num = Integer.parseInt(br.readLine());
		
		switch( num ) {
		case 1 : 
			System.out.println( search[1] );
			break; 
		case 2 : 
			System.out.println( search[2] );
			break;
		case 3 : 
			System.out.println( search[3] );
			break;
		case 0 : 
			return;
		}
	}
	

////	class Fix extends Search {
//	Search sc = new Search();
//	public void run() {
//		String user = sc.getsearch();
//	}
//	// search 값으로 수정
//}
/*	3. 주소록수정
	1. 나이를 수정하시겠습니까?
	2. 전화번호를 수정하시겠습니까?
	3. 주소를 수정하시겠습니까?
	0. 정보수정을 취소하시겠습니까?
	
	해당 데이터 입력 후 수정
	"성공적으로 수정했습니다." 출력
*/

//class Look extends Store {
//	public void run() {
//		System.out.println( "전체보기" );
//		for( int i=0; i<v.size(); i++ ) {
//			System.out.println( v.get(i) );
//		}
//	}
//}
/*
4. 전체보기
이름으로 오름차순해서 주소록 데이터 모두 출력. 
*/


//class Delete extends Store {
//	Search sc = new Search();
//	public void run() throws IOException {
//		BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ));
//		String user = sc.getsearch();
//		System.out.println( user + "님을 정말 삭제하시겠습니까? (Y/N)" );
//		String check = br.readLine();
//		if( check == "Y" ) {
//			v.remove( user );
//		} else if ( check == "N" ) {
//
//		} else {
//			do {
//				System.out.println( user + "님을 정말 삭제하시겠습니까? (Y/N)" );
//				check = br.readLine();
//			} while (check != "Y" && check != "N");
//		}
//	}
//}
/*
	5. 주소록삭제
	____님을 정말 삭제하시겠습니까? (Y/y)	
	
	단, 프로그램을 재시작하면 데이터는 없다.
*/

class Terminate extends MyAddress {
	public Terminate() {
		return;
	}
}
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ));
		MyAddress ma = new MyAddress();
		AddressBookStudy abs = new AddressBookStudy();
		do {
			ma.run();
			if( ma.num >=0 && ma.num <=5 ) {
				switch( ma.num ) {
				case 1: 
					abs.store();
					break;
				case 2: 
					abs.search();
					break;
				case 3: 
					abs.fix();
					break;
		
				case 4: 
				}
			}
		} while ( ma.num != 0 );
		System.out.println( "프로그램을 종료합니다." );
	}
}
