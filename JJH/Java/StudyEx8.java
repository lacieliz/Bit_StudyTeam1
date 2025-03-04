package java12;
//용돈 계좌
//엄마 100000 입금 최대값은 1,000,000
//아빠 50000 출금 10번 출금
//딸30000 출금 10번 출금
//아들 20000 출금 10번 출금
//동기화 처리
class Account {
	private int balance = 0;
	public synchronized void deposit(String name, int money) {
		if(balance > 1000000) {
			System.out.println("최대값 100만 초과");
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			balance += money;
			System.out.println(name + " " + money + "원 입금");
			System.out.println("잔고 : " + balance + "원");
			notifyAll();
		}
	}
	public synchronized void withdraw(String name, int money) {
		if(balance < 0) {
			System.out.println("잔고 없음");
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			balance -= money;
			System.out.println(name + " " + money + "원 출금");
			System.out.println("잔고 : " + balance + "원");
			notifyAll();
		}
	}
}
class DepositThread extends Thread {		// 입금
	private Account ac;
	private String name;
	private int money;
	public DepositThread(Account ac, String name, int money) {
		this.ac = ac;
		this.name = name;
		this.money = money;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			ac.deposit(name,money);
		}
	}
}
class WithdrawThread extends Thread {		// 출금
	private Account ac;
	private String name;
	private int money;
	public WithdrawThread(Account ac, String name, int money) {
		this.ac = ac;
		this.name = name;
		this.money = money;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			ac.withdraw(name, money);
		}
	}
}

public class ThreadStudy {

	public static void main(String[] args) {
		Account account = new Account();
		DepositThread mother = new DepositThread(account, "엄마", 100000);
		WithdrawThread father = new WithdrawThread(account, "아빠", 50000);
		WithdrawThread daughter = new WithdrawThread(account, "딸", 30000);
		WithdrawThread son = new WithdrawThread(account, "아들", 20000);
		mother.start();
		father.start();
		daughter.start();
		son.start();
	}

}
