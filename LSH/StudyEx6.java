package java09;
class Car{
	protected String name;
	protected String fuel;
	protected int ton;
	protected int line;
	
	public String getName() {
		return name;
	}
	public String getFuel() {
		return fuel;
	}
	public int getCarry() {
		return ton;
	}
	public int getNumber() {
		return line;
	}
}
class Truck extends Car{
	public Truck(String name, String fuel, int ton) {
		this.name=name;
		this.fuel=fuel;
		this.ton=ton;
	}
}
class Bus extends Car{
	public Bus(String name, String fuel, int line) {
		this.name=name;
		this.fuel=fuel;
		this.line=line;
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
