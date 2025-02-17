package java11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class MyAddress{
	private String name;
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
	public void AddAddr(BufferedReader br,  Map<String,MyAddress> mapname) throws IOException {
		System.out.println("1. 주소록 저장");
		
		System.out.print("이름 : ");
		setName(br.readLine());
		mapname.put(getName(), this);
		
		System.out.print("나이 : ");
		setAge(Integer.parseInt(br.readLine()));
		
		System.out.print("전화번호 : ");
		setTel(br.readLine());
		
		System.out.print("주소 : ");
		setAddress(br.readLine());
	}
	public void SearchAddr(BufferedReader br, Map<String,MyAddress> mapname) throws IOException {
		System.out.print("검색 이름 : ");
		String userName = br.readLine();
		
		if(mapname.get(userName) != null) {
			Iterator<String> it = mapname.keySet().iterator();
			
			while(it.hasNext() && userName.equals(it.next())) {
			System.out.print("이름 : ");
			System.out.println(mapname.get(userName).getName());

			System.out.print("나이 : ");
			System.out.println(mapname.get(userName).getAge());
			
			System.out.print("전화번호 : ");
			System.out.println(mapname.get(userName).getTel());
			
			System.out.print("주소 : ");
			System.out.println(mapname.get(userName).getAddress());
			System.out.println();
			}
		} 
		else
			System.out.println("\""+userName+"\" 님은 목록에 없습니다.");
		
	}
	public void EditAddr(BufferedReader br, Map<String,MyAddress> mapname) throws IOException{
		System.out.print("수정하려는 목록의 이름 : ");
		String userName = br.readLine();
		
		System.out.println("1.나이를 수정하시겠습니까?");
		System.out.println("2.전화번호를 수정하시겠습니까?");
		System.out.println("3.주소를 수정하시겠습니까?");
		System.out.println("0.정보수정을 취소하시겠습니까?");
		
		int userInput = Integer.parseInt(br.readLine());
		switch(userInput) {
		case 1: {
			System.out.print("나이를 입력해주세요.");
			mapname.get(userName).setAge(Integer.parseInt(br.readLine()));
			System.out.println("성공적으로 수정했습니다.");
			break;
		}
		case 2: {
			System.out.print("전화번호를 입력해주세요.");
			mapname.get(userName).setTel(br.readLine());
			System.out.println("성공적으로 수정했습니다.");
			break;
		}
		case 3: {
			System.out.print("주소를 입력해주세요.");
			mapname.get(userName).setAddress(br.readLine());
			System.out.println("성공적으로 수정했습니다.");
			break;
			}
		case 0: {
			System.out.println("수정을 취소하셨습니다.");
			break;
			}
		}
	}

public void ShowAddrList( Map<String,MyAddress> mapname) {
	
	System.out.println("4.전체보기");

	Iterator<String> it = mapname.keySet().iterator();
	while(it.hasNext()) {
		//mapname.containsKey(it.next());
		String key = it.next();
		System.out.println();
		System.out.println("이름: " + mapname.get(key).getName());
		System.out.println("나이: " + mapname.get(key).getAge());
		System.out.println("전화번호: " + mapname.get(key).getTel());
		System.out.println("주소: " + mapname.get(key).getAddress());
		System.out.println();
	}	
}

public void DelAddr(BufferedReader br, Map<String,MyAddress> mapname) throws IOException {
	
	System.out.println("5.주소록 삭제");
	
	System.out.print("삭제할 주소 이름 입력");
	String s = br.readLine();
	
	if(!mapname.containsKey(s)) {
		System.out.println("없는 이름입니다.");
		System.out.println("메인화면으로 돌아갑니다.");
	}
	
	System.out.println("\""+s+"\" 님을 정말 삭제하시겠습니가?");
	System.out.print("입력(Y or N) : ");
	String userInput = br.readLine();

	if((userInput.equals("Y") || userInput.equals("y")) && mapname.containsKey(s)) {
		mapname.remove(s);
		System.out.println("\""+s+"\" 님이 삭제되었습니다.");
	}
	else
	{
		System.out.println("없는 이름입니다.");
		System.out.println("메인화면으로 돌아갑니다.");
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
			               AddrFunction exe, Map<String,MyAddress>mapname) 
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
public class AddressBookStudy {
	public static void main(String[] args) {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String,MyAddress>mapname = new HashMap<>();
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

