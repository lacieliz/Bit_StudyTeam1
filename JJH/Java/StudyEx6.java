package java09;
class Car {
	private String name;
	private String fuel;
	
	public Car(String name, String fuel) {
		this.name = name;
		this.fuel = fuel;
	}
	
	public String getName() {
		return name;
	}
	public String getFuel() {
		return fuel;
	}
}

class Truck extends Car{
	private int carry;
	
	public Truck(String name, String fuel, int carry) {
		super(name, fuel);
		this.carry = carry;
	}
	
	public int getCarry() {
		return carry;
	}
}

class Bus extends Car{
	private int number;
	
	public Bus(String name, String fuel, int number) {
		super(name, fuel);
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
}

class Bike extends Car{
	public Bike(String name, String fuel) {
		super(name, fuel);
	}
	
}

public class InherStudy {
	public static void main(String[] args) {
		// Car 클래스를 상속 받은 Truck, Bus, Bike 클래스를 구현한다. 상속 -> 변수 줄이기
		Truck truck = new Truck( "포터", "경유", 1 );
		System.out.println( "차종 : " + truck.getName() );
		System.out.println( "연료 : " + truck.getFuel() );
		System.out.println( "적재 : " + truck.getCarry() + "ton" );
		
		Bus bus = new Bus( "현대", "가스", 407 );
		System.out.println( "차종 : " + bus.getName() );
		System.out.println( "연료 : " + bus.getFuel() );
		System.out.println( "노선 : " + bus.getNumber() );
		
		Bike bike = new Bike( "대림", "경유" );
		System.out.println( "차종 : " + bike.getName() );
		System.out.println( "연료 : " + bike.getFuel() );
	}

}
