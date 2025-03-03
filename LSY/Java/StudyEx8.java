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
