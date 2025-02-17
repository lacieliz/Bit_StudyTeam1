<<<<<<< HEAD
package java12;

class Account {		// 쓰레드가 공유할 객체
	private int account = 0;
	
	public synchronized void deposite() {
		if( account > 1000000 ) {
			System.out.println( "입금 최대치가 넘었습니다." );
			try {
				wait();
			} catch( InterruptedException e ) {	
				e.printStackTrace();
			} 
		} else {
			account += 100000;
			System.out.println( "총 입금액 : " + account + "원" );
			notifyAll();
		}
	}

	public synchronized void withdraw( String person, int allowance ) {
		if( account <= allowance ) {
			System.out.println( "출금 가능 금액이 없습니다.");
			try {
				wait();
			} catch( InterruptedException e ) {
				e.printStackTrace();
			}
		} else { 
			account -= allowance;
			System.out.println( "잔여액 : " + account + "원" );
			notifyAll();
		}
	}
	
}

class DepositThread extends Thread {			// 입금
	private Account account;
	private String person;
	public DepositThread( Account account, String person ) {
		this.account = account;
		this.person = person;
//		account.setPerson(person);
	}
	public void run() {
		for( int i=0; i<=10; i++ ) {
			account.deposite();
		}
	}
}

class WithdrawThread extends Thread {		// 출금
	private Account account;
	private String person;
	private int allowance;
	public WithdrawThread( Account account, String person, int allowance ) {
		this.account = account;
		this.person = person;
		this.allowance = allowance;
//		account.setPerson(person);
//		account.setAllowance(allowance);
	}
	public void run() {
		for( int i=0; i<=10; i++ ) {
			account.withdraw( person, allowance );
		}
	}
}

public class ThreadStudy {

	public static void main(String[] args) {
		Account account = new Account();
		DepositThread mother = new DepositThread( account, "엄마" );
		WithdrawThread father = new WithdrawThread( account, "아빠", 50000 );
		WithdrawThread daughter = new WithdrawThread( account, "딸", 30000 );
		WithdrawThread son = new WithdrawThread( account, "아들", 20000 );
		mother.start();
		father.start();
		daughter.start();
		son.start();
		
	}

}
=======
package java11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import java11.Address;
import java11.Search;

class MyAddress	{	// 인터페이스 선언					// 한 명의 데이터를 관리할 용도의 Bean Class(바구니 용도) 
//	이름 나이 전화번호 주소
	String name;
	int age;
	String tel;
	String address;
	int num;
	
	public void MyAddress( String name, int age, String tel, String address) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.address = address;
	}	
	
	public String getName() { return name; }
	public int getAge() { return age; }
	public String getTel() { return tel; }
	public String getAddress() { return address; }
	
	public void setName() { this.name = name; }
	public void setAge() { this.age = age; }
	public void setTel() { this.tel = tel; }
	public void setAddress() { this.address = address; }
	
	public void run() throws NumberFormatException, IOException {
		System.out.println("1. 주소록저장" + "\t" + "2. 주소록검색" + "\t" + "3. 주소록수정" + "\t" + "4. 전체보기" + "\t" + "5. 주소록삭제" + "\t" + "0. 프로그램종료");
		BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ));
		int num;
		num = Integer.parseInt( br.readLine() );
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

class Store extends MyAddress {

	String [] user = { name, String.valueOf(age), tel, address };
	Vector <String[]> v = new Vector<> ();
	
	public void run() {
		BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ));
		MyAddress ma = new MyAddress();
		
		String [] user = { name, String.valueOf(age), tel, address };
		Vector <String[]> v = new Vector<> ();
		
		System.out.println( "이름 : " );
		try {
			name = br.readLine();
			ma.name = name;
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println( "나이 : " );
		try {
			age = Integer.parseInt( br.readLine() );
			ma.age = age;
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		System.out.println( "전화번호 : " );
		try {
			tel = br.readLine();
			ma.tel = tel;
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println( "주소 : " );
		try {
			address = br.readLine();
			ma.address = address;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if( v.add( user ) == true ) {
			System.out.println( "성공적으로 저장했습니다." );
		}	
	}
}

class Search extends Store {		// 상속받아도 객체를 생성해야할 때가 있나?
	BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ));
	public String search;
	public String searchName;
	
	public void run() {
		System.out.println( "검색이름 : ");
		String searchName = null;
		try {
			searchName = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.searchName = searchName;
		for( int i=0; i<super.v.size(); i++) {
			String [] user = super.v.get(i);
			if( user[0].equals(searchName) == true ) {
				System.out.println( v.get(i) );
			} else { 
			System.out.println( searchName + "님은 없습니다." );
			}
		}
	}
	
//	public void fix( String search ) {
//		this.search = search;
//	};
	
	public String getsearch() { return search; }
	public void setsearch(String search) { this.search = search; }
	
}

class Fix extends Search {
	Search sc = new Search();
	public void run() {
		String user = sc.getsearch();
	}
	// search 값으로 수정
}

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

class Terminate extends Address {
	public Terminate() {
		return;
	}
}

public class AddressBookStudy extends Address {
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ));
		MyAddress ma = new MyAddress();
		do {
			ma.run();
			if( ma.num >=0 && ma.num <=5 ) {
				Store st = new Store();
				Search se = new Search();
				switch( ma.num ) {
				case 1: 
					st.run();
					break;
				case 2: 
					se.run();
					break;
				case 3: 
		
				case 4: 
				}
			}
		} while ( ma.num != 0 );
		System.out.println( "프로그램을 종료합니다." );
	}
}

>>>>>>> bd02f495c2e1c8f7e76ca5d0fe8f441f59f90d42
