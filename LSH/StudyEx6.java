package java09;
class Car{
	protected String name;
	protected String fuel;
	
	public String getName() {
		return name;
	}
	public String getFuel() {
		return fuel;
	}
}
class Truck extends Car{
	protected int ton;
	public Truck(String name, String fuel, int ton) {
		this.name=name;
		this.fuel=fuel;
		this.ton=ton;
	}
	public int getCarry() {
		return ton;
	}
}
class Bus extends Car{
	protected int line;
	public Bus(String name, String fuel, int line) {
		this.name=name;
		this.fuel=fuel;
		this.line=line;
	}
	public int getNumber() {
		return line;
	}
}
class Bike extends Car{
	public Bike(String name, String fuel) {
		this.name=name;
		this.fuel=fuel;
	}
}
public class InherStudy {
	public static void main(String[] args) {		
		// Car 클래스를 상속 받은 Truck, Bus, Bike 클래스를 구현한다. 
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
