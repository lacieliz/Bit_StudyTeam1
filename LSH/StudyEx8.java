package java12;
//용돈 계좌
//엄마 100,000씩 입금 10번 입금 최대값은 1,000,000
//아빠  50,000씩  출금 10번 출금
//딸    30,000씩 출금 10번 출금
//아들   20,000씩 출금 10번 출금
//동기화처리
class Account{
	private int cash = 0;
	
	public synchronized void deposit() {
		if(cash > 1000000) {
			System.out.println("잔액 초과다~");
			try{
				wait(); //강제성 있는 함수로 운영체제 스케줄을 방해한다.
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			cash+=100000;
			System.out.println("입금 완료 **잔액 : "+cash);
			notifyAll();
		}
	}

	public synchronized void wirhdraw(String name, int out) {
		if((cash-out) < 0) {
			System.out.println(name+" 출금 시도! 잔액이 부족하다 **잔액 : "+cash);
			try{
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			cash-=out;
			System.out.println(name+" 출금 완료 **잔액 : "+cash);
			notifyAll();
		}
	}
	
}
class DepositThread extends Thread{
	private Account account;
	private String name;
	
	public DepositThread(Account account, String name) {
		this.account = account;
		this.name = name;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			if(name.equals("엄마")) {
				account.deposit();
			}
		}	
	}
}
class WithDrawThread extends Thread{
	private Account account;
	private String name;
	private int out;
	
	public WithDrawThread(Account account, String name, int out) {
		this.account = account;
		this.name = name;
		this.out = out;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			account.wirhdraw(name, out);
		}	
	}
}
public class ThreadStudy {

	public static void main(String[] args) {
		Account account = new Account();
		DepositThread mother = new DepositThread(account, "엄마");
		WithDrawThread father = new WithDrawThread(account, "아빠", 50000);
		WithDrawThread daughter = new WithDrawThread(account, "딸", 30000);
		WithDrawThread son = new WithDrawThread(account, "아들", 20000);
		
		mother.start();
		father.start();
		daughter.start();
		son.start();
		}

}
