package java11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Vector;

class MyAddress{ //Bean Class 콩 바구니 용도 디비로 가면 DTO라고 한다.(Data Type Object)
	private String name; //DB랑 연동할 때는 디비에 저장하는 순서대로 변수를 써야한다.
	private int age;
	private String tel;
	private String address;
	
	//Getter
	public String getName(){
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	public int getAge() {
		return age;
	}
	//Setter
	public void setName(String name){
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
class AddrFunction extends MyAddress{
	public void AddAddr(BufferedReader br,  Vector<MyAddress> mapname) throws IOException {
		System.out.println("1. 주소록 저장");
		
		System.out.print("이름 : ");
		mapname.add(this);
		setName(br.readLine());
		
		System.out.print("나이 : ");
		setAge(Integer.parseInt(br.readLine()));
		
		System.out.print("전화번호 : ");
		setTel(br.readLine());
		
		System.out.print("주소 : ");
		setAddress(br.readLine());
	}
	public void SearchAddr(BufferedReader br, Vector<MyAddress> mapname) throws IOException {
		System.out.print("검색 이름 : ");
		String userName = br.readLine();
		Iterator<MyAddress> it = mapname.iterator();

		if(it.hasNext()) {
			
			MyAddress temp = null;
			System.out.println("========리스트=========");

			while(it.hasNext())
			{
				temp = it.next();
				if(userName.equals(temp.getName())) {
				System.out.print("이름 : ");
				System.out.println(temp.getName());
				
				System.out.print("나이 : ");
				System.out.println(temp.getAge());
				
				System.out.print("전화번호 : ");
				System.out.println(temp.getTel());
				
				System.out.print("주소 : ");
				System.out.println(temp.getAddress());
				System.out.println();

			}
				System.out.println("======================");

			}
		} 
		else
			System.out.println("\""+userName+"\" 님은 목록에 없습니다.");
		
	}
	public void EditAddr(BufferedReader br, Vector<MyAddress> mapname) throws IOException{
		System.out.print("수정하려는 목록의 이름 : ");
		String userName = br.readLine();
		int userIndex  = 0;
		for(int i=0; i<mapname.size();i++) {
			if(userName == mapname.get(i).getName()) {
				userIndex = i;
				break;
			}
		}
		
		System.out.println("1.나이를 수정하시겠습니까?");
		System.out.println("2.전화번호를 수정하시겠습니까?");
		System.out.println("3.주소를 수정하시겠습니까?");
		System.out.println("0.정보수정을 취소하시겠습니까?");
		
		int userInput = Integer.parseInt(br.readLine());
		switch(userInput) {
		case 1: {
			System.out.print("나이를 입력해주세요.");
			mapname.get(userIndex).setAge(Integer.parseInt(br.readLine()));
			System.out.println("성공적으로 수정했습니다.");
			break;
		}
		case 2: {
			System.out.print("전화번호를 입력해주세요.");
			mapname.get(userIndex).setTel(br.readLine());
			System.out.println("성공적으로 수정했습니다.");
			break;
		}
		case 3: {
			System.out.print("주소를 입력해주세요.");
			mapname.get(userIndex).setAddress(br.readLine());
			System.out.println("성공적으로 수정했습니다.");
			break;
			}
		case 0: {
			System.out.println("수정을 취소하셨습니다.");
			break;
			}
		}
	}

public void ShowAddrList( Vector<MyAddress> mapname) {
	
	System.out.println("4.전체보기");
	System.out.println("========전체 보기=========");

	Iterator<MyAddress> it = mapname.iterator();
	
	while(it.hasNext()) {
		//mapname.containsKey(it.next());
		MyAddress temp = it.next();
		System.out.println("이름: " + temp.getName());
		System.out.println("나이: " + temp.getAge());
		System.out.println("전화번호: " + temp.getTel());
		System.out.println("주소: " + temp.getAddress());
		System.out.println();

	}	
	System.out.println("========================");
}

public void DelAddr(BufferedReader br, Vector<MyAddress> mapname) throws IOException {
	
	System.out.println("5.주소록 삭제");
	
	System.out.print("삭제할 주소 이름 입력");
	String s = br.readLine();
	
	for(int i=0; i<mapname.size();i++) {
		if(s.equals(mapname.get(i).getName())){
			System.out.println("\""+s+"\" 님을 정말 삭제하시겠습니가?");
			System.out.print("입력(Y or N) : ");
			String userInput = br.readLine();
			
			if((userInput.equals("Y") || userInput.equals("y"))) {
				mapname.remove(i);
				System.out.println("\""+s+"\" 님이 삭제되었습니다.");
			}
		}
	}
}
}
class MakeMenu{
	public void printMenu() {
		System.out.println("1. 주소록 저장");
		System.out.println("2. 주소록 검색");
		System.out.println("3. 주소록 수정");
		System.out.println("4. 전체보기");
		System.out.println("5. 주소록 삭제");
		System.out.println("0. 프로그램 종료");
	}
	
	public int inputMenu(BufferedReader br) throws NumberFormatException, IOException {
		System.out.print("번호 입력 : ");
		int userInput = Integer.parseInt(br.readLine());
		return userInput;
	}
	
	public boolean noAddr(int userInput) {
		if(userInput==3 || userInput==5) {
			return true;
		}
		return false;
	}
	
	public void selectMenu(int userInput, BufferedReader br, 
			               AddrFunction exe, Vector<MyAddress>mapname) 
			            		   throws IOException {
		switch(userInput) {
		
		    case 1: {
			    AddrFunction my = new AddrFunction();
			    my.AddAddr(br, mapname); 
			    System.out.println("성공적으로 저장했습니다.");
			    break;
	     	}
		    case 2: {
			    exe.SearchAddr(br, mapname); 
			    break;
		    }
		    case 3: {
			    exe.EditAddr(br, mapname); 
			    break;
		    }
		    case 4: {
			    exe.ShowAddrList(mapname);
			    break;
		    }
		    case 5: {
			    exe.DelAddr(br, mapname);
			    break;
		    }
		    case 0: {
			    System.out.println("프로그램이 종료되었습니다.");
			    br.close();
			    break;
		    }
		}
	}

}
public class AddressBookStudy_Vector {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {		
		//Map<String,MyAddress>mapname = new HashMap<>(); 
		//동명이인 저장이 안된다.
		Vector<MyAddress> mapname = new Vector<>();
		AddrFunction exe = new AddrFunction();
		MakeMenu menu = new MakeMenu();
		int userInput =1 ;
		while(userInput!=0) {
		try {
			menu.printMenu();
			userInput = menu.inputMenu(br);
			if(menu.noAddr(userInput) && mapname.isEmpty())
			{
				System.out.println("저장된 주소가 없습니다.");
			}
			else {
				menu.selectMenu(userInput, br, exe, mapname);			
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("다시 입력해주세요.");
		}
	}
	}
}


